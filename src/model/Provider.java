package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "findAllProviders",query = "SELECT pr FROM Provider pr")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column
	private String phoneNumber;
	@Column
	private String pIva;
	@Column
	private String email;
	@ManyToMany (fetch = FetchType.EAGER)
	private List<Product> products;

	@OneToOne 
	private Address address;

	public Provider(String name, String phoneNumber,String pIva, String email,Address address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pIva=pIva;
		this.email = email;
		this.address = address;
	}

	public Provider() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.add(product);
	}
	@Override
	public boolean equals(Object obj) {
		Provider provider = (Provider)obj;
		return this.name.equals(provider.getName());
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}