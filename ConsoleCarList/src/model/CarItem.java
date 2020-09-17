package model;
//Cassandra Wruck

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class CarItem {
	
	// attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="YEAR")
	private String year;
	
	//default no arg
	public CarItem(){
		super();
	}
	
	//2 args
	public CarItem(String year, String model) {
		super();
		this.year = year;
		this.model = model;
	}

	//getters and setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	//print method
	public String returnItemDetails() {
		return year + ":	" + model;
	}

}
