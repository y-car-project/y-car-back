package com.back.ycar.dto;

public class UsedCar {
	private int car_code, car_price, car_year, car_km;
	private String car_name,car_fuel, car_img;
	private Boolean car_weekly;
	public int getCar_code() {
		return car_code;
	}
	public void setCar_code(int car_code) {
		this.car_code = car_code;
	}
	public int getCar_price() {
		return car_price;
	}
	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}
	public int getCar_year() {
		return car_year;
	}
	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}
	public int getCar_km() {
		return car_km;
	}
	public void setCar_km(int car_km) {
		this.car_km = car_km;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_fuel() {
		return car_fuel;
	}
	public void setCar_fuel(String car_fuel) {
		this.car_fuel = car_fuel;
	}
	public String getCar_img() {
		return car_img;
	}
	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}
	public Boolean getCar_weekly() {
		return car_weekly;
	}
	public void setCar_weekly(Boolean car_weekly) {
		this.car_weekly = car_weekly;
	}
	public UsedCar(int car_code, int car_price, int car_year, int car_km, String car_name, String car_fuel,
			String car_img, Boolean car_weekly) {
		super();
		this.car_code = car_code;
		this.car_price = car_price;
		this.car_year = car_year;
		this.car_km = car_km;
		this.car_name = car_name;
		this.car_fuel = car_fuel;
		this.car_img = car_img;
		this.car_weekly = car_weekly;
	}
	public UsedCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsedCar(Car car) {
	    this.car_code = car.getId();
	    this.car_price = car.getCarPrice();
	    this.car_year = car.getCarYear();
	    this.car_km = car.getCarKm();
	    this.car_name = car.getCarName();
	    this.car_fuel = car.getCarFuel();
	    this.car_img = car.getCarImg();
	}

	@Override
	public String toString() {
		return "UsedCar [car_code=" + car_code + ", car_price=" + car_price + ", car_year=" + car_year + ", car_km="
				+ car_km + ", car_name=" + car_name + ", car_fuel=" + car_fuel + ", car_img=" + car_img
				+ ", car_weekly=" + car_weekly + "]";
	}


}
