package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import facade.ProductFacade;
import facade.ProviderFacade;
import model.Product;
import model.Provider;

@ManagedBean
public class ProductController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	@ManagedProperty(value="#{currentProduct}")
	private Product product;
	private List<Product> products;
	private int quantity;
	private String message;

	@ManagedProperty(value="#{param.idProvider}")
	private Long idProvider;
	private Provider provider;
	private List<Provider> providers;

	@EJB
	private ProductFacade productFacade;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Long getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}
	
	public String listProviders() {
		this.providers = providerFacade.getAllProviders();
		return "listProviders";
	}

	public String productProviders() {
		this.providers = providerFacade.getProductProviders(product);
		return "product";
	}

	public String addProvider() {
		this.provider = providerFacade.getProvider(idProvider);
		productFacade.addProvider(provider, product);
		providerFacade.addProduct(provider, product);
		this.providers = providerFacade.getProductProviders(product);
		return "product";
	}


	public String createProduct() {
		String nextPage = "errorProduct";
		try {
			this.product = productFacade.findProduct(code);
		}
		catch (Exception e) {
			this.product = productFacade.createProduct(name, code, price, description,quantity);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentProduct", this.product);
			nextPage = "product";
		}

		return nextPage; 
	}

	public String updateProductQuantity() {
		this.product = productFacade.getProduct(id);
		productFacade.updateProductQuantity(product, quantity);
		this.products = productFacade.getAllProducts();
		return "catalog";
	}


	public String listProducts() {
		this.products = productFacade.getAllProducts();
		this.setMessage("Catalogo prodotti");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentProduct");
		return "catalog"; 
	}

	public String findProduct() {
		this.product = productFacade.getProduct(id);
		this.providers = providerFacade.getProductProviders(product);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentProduct", this.product);
		return "product";
	}

}