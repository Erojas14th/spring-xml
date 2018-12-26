package com.erojas.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erojas.model.Persona;

@Repository("personaJdbcDaoSupportRepository")
@Qualifier("jdbcDaoSupport")
@Transactional
public class PersonaJdbcDaoSupportRepository extends JdbcDaoSupport implements Crud{

	private DataSource dataSource;
	
	public PersonaJdbcDaoSupportRepository(DataSource dataSource) {
		this.dataSource=dataSource;
		setDataSource(this.dataSource);
	}
	
	@Override
	public List<Persona> findAll() {
		String sql = "select * from persona";
		List<Persona> lista = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
		return lista;
	}

	@Override
	public void save(Persona persona) {
		String sql = "INSERT INTO PERSONA (id.nombre) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] { persona.getId(), persona.getNombre() });

	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE persona SET nombre = ? WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] { persona.getNombre(), persona.getId() });

	}

	@Transactional("transactionManager")
	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM persona WHERE id = ?";

		getJdbcTemplate().update(sql, new Object[] { id });

		sql = "UPDATE persona SET nombre = ?,  WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] { null, 1 });

	}

	@Override
	public Persona getOne(Integer id) {
		String sql = "SELECT id,nombre FROM persona WHERE id = ?";
		Persona objeto = getJdbcTemplate().queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
		return objeto;
	}

}
