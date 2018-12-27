package com.erojas.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erojas.model.Persona;

@Repository("personaSessionFactoryRepository")
@Qualifier("sessionFactory")
@Transactional
public class PersonaSessionFactoryRepository implements Crud {

	private SessionFactory sessionFactory;

	public PersonaSessionFactoryRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public List<Persona> findAll() {
		String hql = "FROM persona";
		Query query = getSession().createQuery(hql);
		List<Persona> lista = query.list();
		return lista;
	}

	@Override
	public void save(Persona persona) {
		getSession().persist(persona);

	}

	@Override
	public void update(Persona persona) {
		getSession().update(persona);

	}

	@Transactional("transactionManager")
	@Override
	public void deleteById(Integer id) {
		String hql = "DELETE FROM persona WHERE id = :id";

		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();

	}

	@Override
	public Persona getOne(Integer id) {
		List<Persona> lista;
		String sql = "FROM persona WHERE id = :id";

		Query query = getSession().createQuery(sql);
		query.setParameter("id", id);

		lista = query.list();

		Persona per = lista != null && !lista.isEmpty() ? lista.get(0) : new Persona();
		return per;
	}

}
