package org.java.pizzeria.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate startDate;
	private LocalDate finishDate;
	private String title;
	private int discountPerc;
	
	@ManyToOne
	private Pizza pizza;
	
	public Offer (){}
	
	public Offer(LocalDate startDate,LocalDate finishDate,String title,int discountPrice,Pizza pizza) {
		
		setStartDate(startDate);
		setFinishDate(finishDate);
		setTitle(title);
		setDiscountPerc(discountPerc);
		setPizza(pizza);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDiscountPerc() {
		return discountPerc;
	}

	public void setDiscountPerc(int discountPerc) {
		this.discountPerc = discountPerc;
	}
	

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String toString() {
		return "["+getId()+"]"+ getTitle() + getDiscountPerc()+"%"
		+"\nStart date: "+getStartDate()
		+"\nFinish date: :"+getFinishDate();
	}
	
	
}
