package org.hibernate.bugs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import us.pdinc.products.cresaptown.ds.beans.db.frontend.Profile;
import us.pdinc.products.cresaptown.ds.beans.db.int1.PersonRole;

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
    public void hhh13959TestProfile() throws Exception
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Profile p = new Profile();
        assertNull(p.getId());
        entityManager.persist(p);

        entityManager.getTransaction().begin();
        entityManager.flush();

        System.out.println(p);
        System.out.println(p.getId());

        assertNotNull(p.getId());
        assertNull(p.getCmisPersonRole());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void hhh13959TestPersonRole() throws Exception
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PersonRole p = new PersonRole();
        assertNull(p.getRoleId());
        entityManager.persist(p);
        assertNull(p.getRoleId());

        entityManager.getTransaction().begin();
        entityManager.flush();

        System.out.println(p);
        System.out.println(p.getRoleId());

        assertNotNull(p.getRoleId());
        assertNull(p.getProfile());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void hhh13959TestBothSameTime() throws Exception
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PersonRole pr = new PersonRole();
        assertNull(pr.getRoleId());

        Profile p = new Profile();
        assertNull(p.getId());

        p.setCmisPersonRole(pr);
        pr.setProfile(p);

        System.out.println("persisting pr");
        entityManager.persist(pr);
        System.out.println("persisting p");
        entityManager.persist(p);
        System.out.println("done persisting");

        // no SQL logged... no TX open, how did it get an ID? // this issues is not related to the current issue...
        //assertNotNull(pr.getRoleId());
        //assertNotNull(p.getId());

        entityManager.getTransaction().begin();
        entityManager.flush();

        System.out.println(pr);
        System.out.println(pr.getRoleId());
        System.out.println(p);
        System.out.println(p.getId());

        assertNotNull(pr.getRoleId());
        assertNotNull(pr.getProfile());
        assertNotNull(p.getId());
        assertNotNull(p.getCmisPersonRole());
        assertSame(pr, p.getCmisPersonRole());
        assertSame(p, pr.getProfile());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void hhh13959TestBothRelateLater() throws Exception
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PersonRole pr = new PersonRole();
        assertNull(pr.getRoleId());

        Profile p = new Profile();
        assertNull(p.getId());

        //p.setCmisPersonRole(pr);
        //pr.setProfile(p);

        entityManager.persist(pr);
        entityManager.persist(p);

        p.setCmisPersonRole(pr);
        pr.setProfile(p);

        entityManager.persist(pr);
        entityManager.persist(p);

        assertNull(pr.getRoleId());
        assertNull(p.getId());

        entityManager.getTransaction().begin();
        entityManager.flush();

        System.out.println(pr);
        System.out.println(pr.getRoleId());
        System.out.println(p);
        System.out.println(p.getId());

        assertNotNull(pr.getRoleId());
        assertNotNull(pr.getProfile());
        assertNotNull(p.getId());
        assertNotNull(p.getCmisPersonRole());
        assertSame(pr, p.getCmisPersonRole());
        assertSame(p, pr.getProfile());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
