package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Order;
import model.OrderLine;
import model.Product;
import model.Provider;

import java.util.Iterator;
import java.util.List;

@Stateless(name="pFacade")
public class ProductFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public ProductFacade(){}
	
	public Product createProduct(String name, String code, Float price, String description, int quantity,Provider provider) {
		Product product = new Product(name, price, description, code, quantity, provider);
		em.persist(product);
		return product;
	}


	public void updateProductQuantity(Product product, int quantity) {
		product.setQuantity(product.getQuantity() + quantity);
		em.merge(product);
	}


	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> getAllProducts(){
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> products = query.getResultList();
		return products;
	}

	public boolean verificaQuantity(Order order) {
		boolean evadi = true;
		Iterator<OrderLine> iteratore = order.getOrderLines().iterator();
		try{
			while (iteratore.hasNext() && evadi){
				OrderLine ol = iteratore.next();
				if (ol.getQuantity() > ol.getProduct().getQuantity()) 
					evadi = false;
			}
		}
		catch (Exception e){
			evadi = false;
		}
		return evadi;
	}

	public void reduceQuantity(Order order) {
		try{
			for(OrderLine ol : order.getOrderLines()){
				ol.getProduct().setQuantity(ol.getProduct().getQuantity()-ol.getQuantity());
				em.merge(ol.getProduct());
			}
		}
		catch (Exception e){
		}
	}

	public Product findProduct(String code){
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.code = :code", Product.class);
		query.setParameter("code", code);
		Product product = query.getSingleResult();
		return product;
	}

	public void addProvider(Provider provider, Product product) {
		product.addProvider(provider);
		em.merge(product);
	}

	

}
