package com.back.ycar.dto;

public class AllCarList {
	private int car_code;
	private String car_name, car_img;
	public int getCar_code() {
		return car_code;
	}
	public void setCar_code(int car_code) {
		this.car_code = car_code;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_img() {
		return car_img;
	}
	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}
	public AllCarList(int car_code, String car_name, String car_img) {
		super();
		this.car_code = car_code;
		this.car_name = car_name;
		this.car_img = car_img;
	}
	public AllCarList() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AllCarList [car_code=" + car_code + ", car_name=" + car_name + ", car_img=" + car_img + "]";
	}


}
