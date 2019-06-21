package com.glen.GetBookListMicroService2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cmimet_Liber")
public class Book {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="titull")
	private String titull;
	
	@Column(name="autori")
	private String autori;
	
	@Column(name="sasia")
	private int sasia;
	
	@Column(name="vlera")
	private double vlera;
	
	@Column(name="isbn")
	private int isbn;

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitull() {
		return titull;
	}

	public void setTitull(String titull) {
		this.titull = titull;
	}

	public String getAutori() {
		return autori;
	}

	public void setAutori(String autori) {
		this.autori = autori;
	}

	

	public double getVlera() {
		return vlera;
	}

	public void setVlera(double vlera) {
		this.vlera = vlera;
	}

	public int getSasia() {
		return sasia;
	}

	public void setSasia(int sasia) {
		this.sasia = sasia;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", titull=" + titull + ", autori=" + autori + ", sasia=" + sasia + ", vlera="
				+ vlera + "]";
	}


	
	
}
