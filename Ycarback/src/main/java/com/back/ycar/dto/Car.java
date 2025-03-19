package com.back.ycar.dto;

public class Car {
    private int id;
    private String carName;
    private int carPrice;
    private int carYear;
    private int carKm;
    private String carFuel, carImg;
    
	public Car(int id, String carName, int carPrice, int carYear, int carKm, String carFuel, String carImg) {
		super();
		this.id = id;
		this.carName = carName;
		this.carPrice = carPrice;
		this.carYear = carYear;
		this.carKm = carKm;
		this.carFuel = carFuel;
		this.carImg = carImg;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getCarKm() {
		return carKm;
	}
	public void setCarKm(int carKm) {
		this.carKm = carKm;
	}
	public String getCarFuel() {
		return carFuel;
	}
	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}

	public String getCarImg() {
		return carImg;
	}

	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carPrice=" + carPrice + ", carYear=" + carYear + ", carKm="
				+ carKm + ", carFuel=" + carFuel + ", carImg=" + carImg + "]";
	}
	
    
}
