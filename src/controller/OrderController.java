package controller;

import facade.OrderFacade;
import facade.ProductFacade;
import facade.OrderLineFacade;
import facade.CustomerFacade;
import model.OrderLine;
import model.Customer;
import model.Order;
import model.Product;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean
public class OrderController {
	@ManagedProperty(value="#{param.id}")
	private Long id;

	@ManagedProperty(value="#{sessionScope['currentOrder']}")
	private Order currentOrder;

	@ManagedProperty(value="#{param.currentCustomer}")
	private Customer customer;

	@ManagedProperty(value="#{sessionScope['currentProduct']}")
	private Product currentProduct;

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
	@EJB(beanName="customerFacade")
	private CustomerFacade customerFacade;
	@EJB(beanName="orderLineFacade")
	private OrderLineFacade orderLineFacade;

	public String createOrder() {
		this.currentOrder = orderFacade.createOrder(new Date(),this.customer);
		//this.customer.addOrder(this.currentOrder);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", this.currentOrder);
		return "customerOrder";
	}

	public String addOrderLine() {
		OrderLine orderLine = this.currentOrder.checkOrderLine(currentProduct);
		if(orderLine!= null){
			orderLine.setQuantity(orderLine.getQuantity()+this.quantity);
			orderLineFacade.updateOrderLine(orderLine);


		} else {
			orderLine = orderLineFacade.createOrderLine(currentProduct, this.quantity,currentProduct.getPrice() );
			this.currentOrder.addOrderLine(orderLine);
			orderFacade.updateOrder(currentOrder);
		
		}
		return "customerOrder";
	}
	
	
	
	public String closeOrder() {
		this.currentOrder.setCompletedTime(new Date());
		this.currentOrder.setChiuso();
		orderFacade.updateOrder(currentOrder);
		customerFacade.updateCustomer(customer);
		this.message = "Ordine chiuso correttamente!";
		return "order";
	}

	public String processedOrder() {
		this.currentOrder.setProcessedTime(new Date());
		this.currentOrder.setEvaso();
		orderFacade.updateOrder(currentOrder);
		customerFacade.updateCustomer(customer);
		this.message = "Ordine evaso correttamente!";
		return "order";
	}

	public String suspendOrder() {
		this.currentOrder.setSospeso();
		orderFacade.updateOrder(currentOrder);
		customerFacade.updateCustomer(customer);
		this.message = "Ordine sospeso!";
		return "order";
	}

	public Long getId() {
		return id;
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}


	public OrderLineFacade getOrderLineFacade() {
		return orderLineFacade;
	}


	public void setOrderLineFacade(OrderLineFacade orderLineFacade) {
		this.orderLineFacade = orderLineFacade;
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
		return "order";
	}

	public String findOrder(Long id) {
		this.currentOrder = orderFacade.getOrder(id);
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

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

}




