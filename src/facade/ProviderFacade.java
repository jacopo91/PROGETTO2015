package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Address;
import model.Product;
import model.Provider;


@Stateless(name="prFacade")
public class ProviderFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public ProviderFacade(){}
	
	
	public Provider createProvider(String name, String email, String phoneNumber,String pIva,String street, String city, String country) {
		Address address = new Address(street, city, country);
		em.persist(address);
		Provider provider = new Provider (name, email, phoneNumber,pIva, address);
		em.persist(provider);
		return provider;
	}

	public List<Provider> getAllProviders() {
		TypedQuery<Provider> query = em.createQuery("SELECT p FROM Provider p ORDER BY p.name", Provider.class);
		List<Provider> providers = query.getResultList();
		return providers;
	}
	
	public List<Provider> getProductProviders(Product product){
		return product.getProviders();
	}

	public Provider getProvider(Long id) {
		Provider provider = em.find(Provider.class, id);
		return provider;
	}

	public void addProduct(Provider provider, Product product) {
		provider.addProduct(product);
		em.merge(provider);		
	}

	public Provider findProvider(String name) {
		TypedQuery<Provider> query = em.createQuery("SELECT p FROM Provider p WHERE p.name = :name", Provider.class);
		query.setParameter("name", name);
		Provider provider = query.getSingleResult();
		return provider;
	}

	

	
}
