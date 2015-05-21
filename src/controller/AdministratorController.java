package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import facade.AdministratorFacade;
import model.Administrator;

@ManagedBean
public class AdministratorController {
		private Long id;
		private String firstName;
		private String lastName;
		private String username;
		private String password;
		private Date dateOfBirth;
		private Administrator currentAdministrator;
		@EJB
		private AdministratorFacade administratorFacade;

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
		
}

