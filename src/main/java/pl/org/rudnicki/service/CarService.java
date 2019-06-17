package pl.org.rudnicki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pl.org.rudnicki.dao.CarDao;
import pl.org.rudnicki.model.Car;

@Service
public class CarService {
	
	
	private final CarDao carDao;

	@Autowired
	public CarService(CarDao carDao) {
		super();
		this.carDao = carDao;
	}
	
	public Boolean saveCar(Car car) {
		return carDao.saveCar(car);
	}
	
	
	public Car getCarById(Integer id) {
		return carDao.getCarById(id);
	}
	public List<Car> getCarList(){
		return carDao.getCarList();
	}
	
	public Boolean deleteCar(Integer id) {
		try {
			carDao.deleteCar(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean updateCar(Car car) {
		try {
			carDao.updateCar(car);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
