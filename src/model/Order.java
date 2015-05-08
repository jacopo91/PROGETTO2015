package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;//creazione dal cliente
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingTime;//chiusura dal cliente
	@Temporal(TemporalType.TIMESTAMP)
	private Date evasionTime;//evasione dall'amministratore
	@Column(nullable = false)
	private String state;//stato dell'ordine
	@OneToMany (cascade= {CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	@ManyToOne
	private Customer customer;
	
	public Order () {
		this.creationTime = new Date();
		this.state = "open";
		this.orderLines = new ArrayList<OrderLine>();
	}
	
	public void addOrderLine(OrderLine orderLine){
		this.orderLines.add(orderLine);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

	public Date getEvasionTime() {
		return evasionTime;
	}

	public void setEvasionTime(Date evasiontime) {
		this.evasionTime = evasiontime;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}