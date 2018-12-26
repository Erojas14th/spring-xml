package com.erojas.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaSessionFactoryServiceImpl;

public class App {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		//Crud crud =ap.getBean("personaJdbcRepository",PersonaJdbcRepository.class);
		PersonaService crud =ap.getBean("personaSessionFactoryServiceImpl",PersonaSessionFactoryServiceImpl.class);
		List<Persona> lista = crud.findAll();
		lista.stream().forEach(p -> System.out.println(p.getNombre()));
	}

}
