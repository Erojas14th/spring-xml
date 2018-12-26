package com.erojas.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaJdbcServiceImpl;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		PersonaService ps = ap.getBean(PersonaJdbcServiceImpl.class);
		List<Persona> lista = ps.findAll();
		lista.stream().forEach(p -> System.out.println(p.getNombre()));
	}

}
