package model;
//Cassandra Wruck

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class CarItem {
	
	// attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="YEAR")
	private String year;
	@Column(name="MODEL")
	private String model;
	
	//default no arg
	public CarItem(){
		super();
	}
	
	//3 args
	public CarItem(String make, String year, String model) {
		super();
		this.make = make;
		this.year = year;
		this.model = model;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	//print method
	public String returnItemDetails() {
		return make + " "  + year + " " + model;
	}

}
