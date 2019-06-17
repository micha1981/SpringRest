package pl.org.rudnicki.dao;

import java.util.List;

import pl.org.rudnicki.model.Car;

public interface CarDao {

	public Car getCarById(Integer id);
	
	public List<Car> getCarList();
	
	public Boolean saveCar(Car car);
	
	public Boolean deleteCar(Integer id);
	
	public Boolean updateCar(Car car);
	
	
}
