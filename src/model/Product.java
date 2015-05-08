package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true, nullable = false)
	private String code;
	@Column(nullable = false)
	private String name;
	@Column(length = 2000)
	private String description;
	@Column(nullable = false)
	private Float price;
	@Column(nullable = false)
	private int quantity;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private List<Provider> providers;
	
	public Product(String name, Float price, String description, String code, int quantity) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
		this.quantity = quantity;
		this.providers = new ArrayList<Provider>();
	}
	
	public Product() {
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	public void addProvider(Provider provider){
		this.providers.add(provider);
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.code.equals(product.getCode());
	}

	public int hashCode() {
		return this.code.hashCode();
	}
}