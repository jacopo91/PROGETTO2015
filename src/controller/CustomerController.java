package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import facade.CustomerFacade;
import model.Customer;

@ManagedBean
public class CustomerController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dateOfBirth;
	private Customer currentCustomer;
	@EJB
	private CustomerFacade customerFacade;
	private Customer customer;
	private List<Customer> customers;
	private String street;
	private String city;
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String createCustomer() {
		customerFacade.createCustomer(firstName, lastName, email, password, dateOfBirth,street,city,country);
		return "registrationCompleteCustomer"; 
	}
	
	public String loginCustomer() {
		String nextPage = "errorLogin";
		try{
			Customer customer = customerFacade.getCustomer(email);
			if (customer.verificaPassword(password) && customer.isConfermato()) {
				this.currentCustomer = customer;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentCustomer", this.currentCustomer);
				nextPage = "customerConfirmed";
			}
		}
		catch (Exception e) {
		}
		return nextPage;
	}
	
	public String logoutCustomer() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentCustomer");;
		return "firstPage";
	}
	
	public String findCustomer() {
		this.customer = customerFacade.getCustomer(id);
		return "profileCustomer";
	}
	
	public String getCustomerProfile() {
		this.customer = customerFacade.getCustomer(id);
		return "profileCustomer";
	}
	
	public String acceptCustomer() {
		this.customer = customerFacade.getCustomer(id);
		customerFacade.confirmCustomer(customer);
		this.customers = customerFacade.getSuspendedCustomers();
		return "customersWaiting";
	}
	
	public String findSuspendedCustomers (){
		this.customers = customerFacade.getSuspendedCustomers();
		return "customersWaiting";
	}
	
}
