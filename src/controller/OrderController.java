package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import facade.OrderFacade;
import facade.ProductFacade;
import model.Customer;
import model.Order;
import model.Product;

@ManagedBean
public class OrderController {
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	@ManagedProperty(value="#{param.currentOrder}")
	private Order currentOrder;
	@ManagedProperty(value="#{param.currentCustomer}")
	private Customer customer;
	private Date closingTime;
	private Date evasionTime;
	private List<Order> orders;
	private String message;
	private List<Product> products;
	private int quantity; 
	private Order order;
	@ManagedProperty(value="#{param.idProduct}")
	private Long idProduct;

	@EJB(name="oFacade")
	private OrderFacade orderFacade;
	@EJB(name="pFacade")
	private ProductFacade productFacade;

	public Long getId() {
		return id;
	}

	
	public OrderFacade getOrderFacade() {
		return orderFacade;
	}
	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}
	public ProductFacade getProductFacade() {
		return productFacade;
	}
	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Order getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public void setEvasionTime(Date evasionTime) {
		this.evasionTime = evasionTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String evasionOrder(){
		String nextPage = "listCustomerOrders";
		this.order = orderFacade.getOrder(id);
		if (productFacade.verificaQuantity(order)){
			productFacade.reduceQuantity(order);
			orderFacade.evasionOrder(order);
			this.orders = orderFacade.getAllClosedOrders();
		}
		else 
			nextPage = "errorEvasion";

		return nextPage;
	}

	public String listOrders() {
		this.orders = orderFacade.getAllOrders(customer);
		return "listCustomerOrders";
	}

	public String listClosedOrders() {
		this.orders = orderFacade.getAllClosedOrders();
		return "listCustomerOrders";

	}
	public String findOrder() {
		this.currentOrder = orderFacade.getOrder(id);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", this.currentOrder);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentProduct");
		return "order";
	}

	public String createOrder(){
		this.currentOrder = orderFacade.createOrder(customer);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", this.currentOrder);
		return "order";
	}

	public String addOrderProduct(){
		Product product = productFacade.getProduct(idProduct);
		orderFacade.createOrderLine(currentOrder,product, quantity, product.getPrice());
		return "order";
	}

	public String fineInserimento() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentOrder");
		if(this.customer != null)
			this.orders = orderFacade.getAllOrders(customer);
		else
			this.orders = orderFacade.getAllClosedOrders();
		return "listCustomerOrders";
	}

	public String closeOrder() {
		orderFacade.closeOrder(currentOrder);
		this.orders = orderFacade.getAllOrders(customer);
		return "listCustomerOrders";
	}

	public String allOrders(){
		return message;
		
	}
	
	
	
}




