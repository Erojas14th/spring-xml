package com.erojas.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erojas.model.Persona;
import com.erojas.repository.Crud;
import com.erojas.repository.PersonaJdbcDaoSupportRepository;

public class App {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		//Crud crud =ap.getBean("personaJdbcRepository",PersonaJdbcRepository.class);
		Crud crud =ap.getBean("personaJdbcDaoSupportRepository",PersonaJdbcDaoSupportRepository.class);
		List<Persona> lista = crud.findAll();
		lista.stream().forEach(p -> System.out.println(p.getNombre()));
	}

}
