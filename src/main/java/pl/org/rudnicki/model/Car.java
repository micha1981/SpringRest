package pl.org.rudnicki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private  Integer id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="mark")
	private  String mark;
	
	@Column(name="year")
	private  Integer year;
	
	@Column(name="price")
	private  Integer price;
	
	
	
	
	

	public Car(Integer id, String model, String mark, Integer year, Integer price) {
		super();
		this.id = id;
		this.model = model;
		this.mark = mark;
		this.year = year;
		this.price = price;
	}

	public Car() {
		
	}


	public Integer getId() {
		return id;
	}


	public String getModel() {
		return model;
	}


	public String getMark() {
		return mark;
	}


	public Integer getYear() {
		return year;
	}


	public Integer getPrice() {
		return price;
	}
	
	
	
	
}
