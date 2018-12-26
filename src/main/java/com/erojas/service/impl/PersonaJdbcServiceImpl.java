package com.erojas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erojas.config.Conexion;
import com.erojas.model.Persona;
import com.erojas.repository.PersonaJdbcRepository;
import com.erojas.service.PersonaService;

@Service
public class PersonaJdbcServiceImpl  implements PersonaService{

	private PersonaJdbcRepository personaJdbcRepository;
	
	public PersonaJdbcServiceImpl () {
		 this.personaJdbcRepository= new PersonaJdbcRepository();
	}
	
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaJdbcRepository.findAll();
	}

	@Override
	public void save(Persona persona) {
		personaJdbcRepository.save(persona);
		
	}

	@Override
	public void update(Persona persona) {
		personaJdbcRepository.update(persona);
		
	}

	@Override
	public void deleteById(Integer id) {
		personaJdbcRepository.deleteById(id);
		
	}

	@Override
	public Persona getOne(Integer id) {
		// TODO Auto-generated method stub
		return personaJdbcRepository.getOne(id);
	}

}