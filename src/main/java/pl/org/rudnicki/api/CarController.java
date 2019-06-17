package pl.org.rudnicki.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import pl.org.rudnicki.model.Car;
import pl.org.rudnicki.service.CarService;


@RequestMapping("/api")
@RestController
public class CarController {

	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping
	public List<Car> getCarList() {
		
		return carService.getCarList();
	}
	
	
	
	@PostMapping()
	
	public void saveCar(@RequestBody Car car) {
		System.out.println(car.getModel());
		carService.saveCar(car);
	}
	
	@PutMapping
	public Boolean updateeCar(@RequestBody Car car) {
		
		return carService.updateCar(car);
	
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public Boolean deleteCar(@PathVariable(value="id") Integer id) {
		
			return carService.deleteCar(id);
		
	} 
	
	
	
	@GetMapping("/id/{id}")
	public Car getCar(@PathVariable Integer id) {
		System.out.println(id.getClass());
		return carService.getCarById(id);
	}
	
}
