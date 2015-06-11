package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import facade.ProviderFacade;
import model.Provider;


@ManagedBean
public class ProviderController {
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private List<Provider> providers;
	private Provider provider;
	private String street;
	private String pIva;
	private String city;
	private String country;

	@EJB
	private ProviderFacade providerFacade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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



	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String createProvider() {
		String nextPage = "errorProvider";
		try {
			this.provider = providerFacade.findProvider(name);//???
		}
		catch (Exception e) {
		this.provider = providerFacade.createProvider(name, email, phoneNumber,pIva,street,city,country);
		nextPage = "profileProvider"; 
		}
		return nextPage;
	}

	public String findProvider() {
		this.provider = providerFacade.getProvider(id);
		return "profileProvider";
	}

	
}
