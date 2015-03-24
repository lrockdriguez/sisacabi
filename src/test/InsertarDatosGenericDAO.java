package test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.equidad.sisddeq.DAO.Impl.RolSisddeqDAOImpl;
import com.equidad.sisddeq.entidades.SisddeqCRol;
import com.equidad.sisddeq.service.impl.RolSisddeqServiceImpl;

public class InsertarDatosGenericDAO {

	@Inject
	public RolSisddeqDAOImpl _rolSisddeqDAO;

	@Inject
	public RolSisddeqServiceImpl rolSisddeqService = new RolSisddeqServiceImpl();

	private static EntityManager em;

	@Before
	public void antesDelTest() {
		// if (em == null) {
		// em = (EntityManager)
		// Persistence.createEntityManagerFactory("sisddeq-persistencia").createEntityManager();
		// _rolSisddeqDAO = new RolSisddeqDAOImpl(em);
		// }
	}

	@After
	public void despuesDelTest() {
		// em.getTransaction().commit();
		// System.out.println("Aespues del test");
	}

	@Test
	public void test() {

		// em.getTransaction().begin();
		SisddeqCRol sisddeqcrol = new SisddeqCRol();
		try {
			rolSisddeqService.consultaRol();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}
}
