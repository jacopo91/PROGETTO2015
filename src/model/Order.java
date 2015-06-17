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
import javax.persistence.OneToMany;
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
	private boolean chiuso;
	@Column(nullable = false)
	private boolean evaso;
	@Column(nullable = false)
	private boolean sospeso;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;//creazione dal cliente
	@Temporal(TemporalType.TIMESTAMP)
	private Date completedTime;//chiusura dal cliente
	@Temporal(TemporalType.TIMESTAMP)
	private Date processedTime;//evasione dall'amministratore

	@OneToMany (cascade= {CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	@ManyToOne
	private Customer customer;
	
	public Order(){}
	
	public Order (Date creationTime,Customer customer) {
		this.creationTime = creationTime;
		this.customer = customer;
		this.chiuso = false;
		this.orderLines = new ArrayList<OrderLine>();
	}
	
	public void addOrderLine(OrderLine orderLine){
		this.orderLines.add(orderLine);
	}
	
	public Long getId() {
		return id;
	}
	
	public boolean isChiuso() {
		return chiuso;
	}

	public void setChiuso() {
		this.chiuso = true;
	}

	public boolean isEvaso() {
		return evaso;
	}

	public void setEvaso() {
		this.evaso = true;
	}

	public boolean isSospeso() {
		return sospeso;
	}

	public void setSospeso() {
		this.sospeso = true;
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

	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	public Date getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(Date processedtime) {
		this.processedTime = processedtime;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public OrderLine checkOrderLine(Product product) {
		OrderLine orderLine = new OrderLine();
		for(OrderLine line : this.orderLines) {
			if(line.getProduct().getId().equals(product.getId()))
				orderLine = line;
		}
		return orderLine;
	}

	
}
