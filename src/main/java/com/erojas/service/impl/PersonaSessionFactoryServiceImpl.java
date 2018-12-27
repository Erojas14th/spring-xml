package com.erojas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erojas.model.Persona;
import com.erojas.repository.PersonaSessionFactoryRepository;
import com.erojas.service.PersonaService;

@Service("personaSessionFactoryServiceImpl")
public class PersonaSessionFactoryServiceImpl implements PersonaService{
	@Autowired
	@Qualifier("sessionFactory")
	private PersonaSessionFactoryRepository dao;
	
	@Override
	public List<Persona> findAll() {
		
		return dao.findAll();
	}

	@Override
	public void save(Persona persona) {
		dao.save(persona);
		
	}

	@Override
	public void update(Persona persona) {
		dao.update(persona);
		
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public Persona getOne(Integer id) {
		
		return dao.getOne(id);
	}

}
