package com.DigitalStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class MoviesCollection {
	
	@Id
	private String id;
	private String name;
	private String Price;
	private String rent;
	private String description;
	private String image_path;
	private String cover_path;
	private String purchase;
	private String isFeature;
	
	
	
	public MoviesCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getCover_path() {
		return cover_path;
	}
	public void setCover_path(String cover_path) {
		this.cover_path = cover_path;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public String getIsFeatured() {
		return isFeature;
	}
	public void setIsFeatured(String isFeatured) {
		this.isFeature = isFeatured;
	}
	
	public MoviesCollection(String id, String name, String price, String rent, String description, String image_path,
			String cover_path, String purchase, String isFeatured) {
		super();
		this.id = id;
		this.name = name;
		Price = price;
		this.rent = rent;
		this.description = description;
		this.image_path = image_path;
		this.cover_path = cover_path;
		this.purchase = purchase;
		this.isFeature = isFeatured;
	}
	
	
	@Override
	public String toString() {
		return "MoviesCollection [id=" + id + ", name=" + name + ", Price=" + Price + ", rent=" + rent
				+ ", description=" + description + ", image_path=" + image_path + ", cover_path=" + cover_path
				+ ", purchase=" + purchase + ", isFeatured=" + isFeature + "]";
	}
	
	

}
