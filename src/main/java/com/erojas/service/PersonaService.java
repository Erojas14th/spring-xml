package com.erojas.service;

import java.util.List;

import com.erojas.model.Persona;

public interface PersonaService {
	List<Persona> findAll();
	void save(Persona persona);
	void update(Persona persona);
	void deleteById(Integer id);
	Persona getOne(Integer id);
}
