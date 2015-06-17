package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.OrderLine;
import model.Product;

@Stateless(name="orderLineFacade")
public class OrderLineFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public OrderLine createOrderLine(Product product, int quantity,float unitPrice) {
		OrderLine orderLine = new OrderLine(product,quantity,unitPrice);
		em.persist(orderLine);
		return orderLine;
	}

	public OrderLine getOrderLine(Long id) {
		OrderLine orderLine = em.find(OrderLine.class, id);
		return orderLine;
	}

	public void updateOrderLine(OrderLine orderLine) {
		em.merge(orderLine);
	}

	private void deleteOrderLine(OrderLine orderLine) {
		em.remove(orderLine);
	}

	public void deleteProduct(Long id) {
		OrderLine orderLine = em.find(OrderLine.class, id);
		deleteOrderLine(orderLine);
	}
}
