package controller;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import facade.AdministratorFacade;
import facade.OrderFacade;
import model.Administrator;
import model.Order;

@ManagedBean
public class AdministratorController {
		private Long id;
		private String firstName;
		private String lastName;
		private String username;
		private String password;
		private Date dateOfBirth;
		private List<Order>orders;
		private Administrator currentAdministrator;
		@EJB(name="aFacade")
		private AdministratorFacade administratorFacade;
		@EJB(beanName="orderFacade")
		private OrderFacade orderFacade;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		
		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		public OrderFacade getOrderFacade() {
			return orderFacade;
		}

		public void setOrderFacade(OrderFacade orderFacade) {
			this.orderFacade = orderFacade;
		}

		public AdministratorFacade getAdministratorFacade() {
			return administratorFacade;
		}

		public void setAdministratorFacade(AdministratorFacade administratorFacade) {
			this.administratorFacade = administratorFacade;
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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public Administrator getCurrentAdministrator() {
			return currentAdministrator;
		}

		public void setCurrentAdministrator(Administrator currentAdministrator) {
			this.currentAdministrator = currentAdministrator;
		}
		
		public String loginAdministrator() {
			String nextPage = "errorLogin";
			try{
				Administrator administrator = administratorFacade.getAdministrator(username);
				if (administrator.verificaPassword(password)) {
					this.currentAdministrator = administrator;
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentAdministrator", this.currentAdministrator);
					nextPage = "administratorConfirmed";
				}
			}
			catch (Exception e) {
			}
			return nextPage;
		}
		
		public String logoutAdministrator() {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentAdministrator");;
			return "firstPage";
		}
		
		public String allOrders() {
			this.orders = orderFacade.getAllClosedOrders();
			return "administratorOrders";
		}
		
		
		public String listClosedOrders() {
			this.orders = orderFacade.getAllClosedOrders();
			return "listAdministratorOrders";
		}
}

