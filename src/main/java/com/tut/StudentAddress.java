package com.tut;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="student_address")
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="s_address_id")
	private int addressId;
	
	@Column(name="s_street", length=50)
	private String street;
	
	@Column(name="s_city", length=100)
	private String city;
	
	@Transient
	private double xyz;
	
	@Column(name="c_is_open")
	private boolean isOpen;
	
	private LocalDate date;
	
	@Lob
	private byte[] image;
	
	public StudentAddress() {
		
	}

	public StudentAddress(int addressId, String street, String city, double xyz, boolean isOpen, LocalDate date,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.xyz = xyz;
		this.isOpen = isOpen;
		this.date = date;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getXyz() {
		return xyz;
	}

	public void setXyz(double xyz) {
		this.xyz = xyz;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "StudentAddress [addressId=" + addressId + ", street=" + street + ", city=" + city + ", xyz=" + xyz
				+ ", isOpen=" + isOpen + ", date=" + date + ", image=" + Arrays.toString(image) + "]";
	}
	
}
