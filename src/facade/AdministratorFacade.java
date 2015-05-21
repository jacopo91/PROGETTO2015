package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Administrator;

@Stateless
public class AdministratorFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;
		
	public Administrator getAdministrator(String username) {
		TypedQuery<Administrator> query = em.createQuery("SELECT adm FROM Administrator adm WHERE adm.username = :username", Administrator.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

}
