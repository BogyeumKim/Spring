package com.aia.guest.model;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Guest_test {

	private double x;
	private double y;
	private int r;

	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	}


	@Override
	public String toString() {
		return "Guest_test [x=" + x + ", y=" + y + ", r=" + r + "]";
	}

}
