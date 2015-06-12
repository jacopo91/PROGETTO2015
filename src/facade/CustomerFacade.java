package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Address;
import model.Customer;

import java.util.Date;
import java.util.List;

@Stateless
public class CustomerFacade {
	
	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public void createCustomer(String name, String lastname, String email, String password, Date dateOfBirth, String street, String city, String country) {
		Address address = new Address(street,city,country);
		em.persist(address);
		Customer customer = new Customer(name, lastname, email, password, dateOfBirth, address);
		em.persist(customer);
	}

	public Customer getCustomer(Long id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}
	
	public List<Customer>getAllCustomers(){
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c",Customer.class);
		return query.getResultList();
	}

	public Customer getCustomer(String email) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email",Customer.class);
		query.setParameter("email", email);
		return query.getSingleResult();

	}

	public List<Customer> getSuspendedCustomers() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.confermato = :confermato", Customer.class);
		query.setParameter("confermato", false);
		return query.getResultList();
	}

	public void confirmCustomer(Customer customer) {
		customer.setConfermato(true);
		em.merge(customer);
	}
}

