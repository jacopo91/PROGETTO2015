package facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Customer;
import model.Order;

@Stateless(name="oFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public OrderFacade(){}
	
	public Order createOrder(Date creationTime,Customer customer) {
		Order order = new Order(creationTime,customer);
		em.persist(order);
		return order;
	}
	
	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}
	
	public List<Order> getAllOrders(Customer customer) {
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.customer =: customer", Order.class);
		query.setParameter("customer", customer);
		List<Order> orders = query.getResultList();
		return orders;
	}

	public List<Order> getAllClosedOrders(){
		Query query = em.createQuery("SELECT o FROM Order o WHERE o.chiuso = true");
		List<Order> orders = query.getResultList();
		return orders;
	}

	public void updateOrder(Order order) {
		em.merge(order);
	}

	private void deleteOrder(Order order) {
		em.remove(order);
	}

	public void deleteProduct(Long id) {
		Order order = em.find(Order.class, id);
		deleteOrder(order);
	}
}

