package facade;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;

@Stateless(name="orderFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public Order createOrder(Customer customer) {
		Order order = new Order(customer);
		em.persist(order);
		return order;
	}

	public void createOrderLine(Order order, Product prodotto, int quantita, Float prezzo){
		OrderLine ol = null;
		boolean trovato = false;
		Iterator<OrderLine> iteratore = order.getOrderLines().iterator();
		while (iteratore.hasNext() && !trovato){
			ol = iteratore.next();
			if (ol.getProduct().getCode().equals(prodotto.getCode())){
				ol.setQuantity(ol.getQuantity()+quantita);
				trovato = true;
			}
		}
		if (!trovato){
			ol = new OrderLine (prodotto, quantita, prezzo);
			order.addOrderLine(ol);
		}
		em.merge(order);
	}

	public void closeOrder(Order order){
		order.setState("closed"); 
		order.setClosingTime(new Date());
		em.merge(order);
	}

	public List<Order> getAllOrders(Customer customer) {
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.customer =: customer", Order.class);
		query.setParameter("customer", customer);
		List<Order> orders = query.getResultList();
		return orders;
	}

	public List<Order> getAllClosedOrders(){
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.state = 'closed'", Order.class);
		List<Order> orders = query.getResultList();
		return orders;
	}
	
	


	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}

	public void removeOrder(Order order) {
		em.remove(order);
	}

	public void evasionOrder(Order order) {
		order.setState("sent");
		order.setEvasionTime(new Date());
		em.merge(order);
	}

}

