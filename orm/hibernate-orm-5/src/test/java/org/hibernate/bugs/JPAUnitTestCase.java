package org.hibernate.bugs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import us.pdinc.products.cresaptown.ds.beans.db.approval.Routing;
import us.pdinc.products.cresaptown.ds.beans.db.frontend.Profile;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
    public void hhh13941Test() throws Exception
    {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        Profile p = new Profile();
        assertNull(p.getId());
        entityManager.persist(p);
        assertNull(p.getId());

        Routing r = new Routing();
        r.setProfile(p);
        assertNull(r.getId());

        System.out.println("no insert/update SQL trace shown yet");

        entityManager.getTransaction().begin();
        // Do stuff...

        System.out.println("about to persist Profile (again)");
        entityManager.persist(p);
        assertNull(p.getId());
        assertNull(r.getId());

        System.out.println("about to persist Routing, will flush because needs FK to Profile AND we are in TX");
        entityManager.persist(r);
        //        //p.id / r.id is updating without explicit flush
        //        assertNull(r.getId());
        //        assertNull(p.getId());

        System.out.println("about to flush");
        entityManager.flush();

        Profile foundp = entityManager.find(Profile.class, 1L);
        assertNotNull(foundp);
        assertTrue(p == foundp);

        entityManager.refresh(p);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
