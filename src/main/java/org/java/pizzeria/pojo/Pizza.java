package org.java.pizzeria.pojo;


import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String url;
	private int price;
	
	@OneToMany(mappedBy = "pizza")
	private List<Offer>offers;
	
	@ManyToMany
	private List<Ingredient>ingredients;
	
	public Pizza() {}

	public Pizza(String name,String description,String url,int price,Ingredient...Ingredients) {
		setName(name);
		setDescription(description);
		setUrl(url);
		setPrice(price);
		setIngredients(ingredients);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void setIngredients(Ingredient[] ingredients) {
		setIngredients(Arrays.asList(ingredients));
	}

	@Override
	public String toString() {
		return "["+getId()+"]"+ getName()
		+"\n"+getDescription()
		+"\nfoto piatto:"+getUrl()
		+"\n"+getPrice()+"-"+getUrl();
	}
	
}
