package com.DigitalStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tvshow")
public class TvShowCollection {

	@Id
	private String id;
	private String name;
	private String price;
	private String description;
	private String image_path;
	private String cover_path;
	private String rent;
	private String buy;
	private String isFeatured;
	
	
	
	
	public TvShowCollection() {
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
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
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
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getIsFeatured() {
		return isFeatured;
	}
	public void setIsFeatured(String isFeatured) {
		this.isFeatured = isFeatured;
	}


	public TvShowCollection(String id, String name, String price, String description, String image_path,
			String cover_path, String rent, String buy, String isFeatured) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image_path = image_path;
		this.cover_path = cover_path;
		this.rent = rent;
		this.buy = buy;
		this.isFeatured = isFeatured;
	}


	@Override
	public String toString() {
		return "TvShowCollection [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", image_path=" + image_path + ", cover_path=" + cover_path + ", rent=" + rent + ", buy=" + buy
				+ ", isFeatured=" + isFeatured + "]";
	}
		
	
}
