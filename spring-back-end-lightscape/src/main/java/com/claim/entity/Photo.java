package com.claim.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class Photo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column (name="portfolio_photo")
	private byte[] portfolioPhoto; 
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="email")
	private Photographer photographer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPortfolioPhoto() {
		return portfolioPhoto;
	}

	public void setPortfolioPhoto(byte[] portfolioPhoto) {
		this.portfolioPhoto = portfolioPhoto;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}
	
	
	
	
}