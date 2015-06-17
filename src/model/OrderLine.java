package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderLine")
public class OrderLine {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (nullable = false)
	private int quantity;
	@Column (nullable = false)
	private Float unitPrice;
	@OneToOne
	private Product product;

	public OrderLine (Product prodotto, int quantity, Float unitPrice) {
		this.product = prodotto;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public OrderLine() {
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float price) {
		this.unitPrice = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}

