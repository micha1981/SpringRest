package pl.org.rudnicki.dao;



import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import pl.org.rudnicki.model.Car;

@Repository
public class MySqlDataAccessService implements CarDao{

	private Session session=null;
	private SessionFactory sessionFactory=null;
	
	
	 public MySqlDataAccessService() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.org.rudnicki.model.Car.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	
	
	@Override
	public Car getCarById(Integer id) {
		session = sessionFactory.openSession();
	    Car car = session.get(Car.class, id);
	    session.close();
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getCarList() {
		try {
			session = sessionFactory.openSession();
			Query<Car> query = session.createQuery("from Car l");
			List<Car> list =query.getResultList();
			session.close();
			return list;
			
		} catch (Exception e) {	
			e.printStackTrace();
			session.close();
			return null;
		}
	}

	@Override
	public Boolean saveCar(Car car) {
		try {
			session=sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(car);
			tr.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			session.close();
			return false;
		}
		
	}



	@Override
	public Boolean deleteCar(Integer id) {
		Car car = new Car();
		car = this.getCarById(id);
		System.out.println("car created");
		
        session = sessionFactory.openSession();
	 Transaction tr = session.beginTransaction();
	
		try {
					
			session.remove(car);
		
			tr.commit();
			session.close();
			System.out.println("client removed");
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			tr.rollback();
			session.close();
			return false;
		}
	}



	@Override
	public Boolean updateCar(Car car) {
		System.out.println(car.getMark());
		session = sessionFactory.openSession();
		Transaction tr=null;
		
		try {
			tr = session.beginTransaction();
			session.update(car);
			tr.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			tr.rollback();
			session.close();
			return false;
		}
	}
}


