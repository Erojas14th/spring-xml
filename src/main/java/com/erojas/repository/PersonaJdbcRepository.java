package com.erojas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.erojas.config.Conexion;
import com.erojas.model.Persona;

@Repository("jdbcRepository")
public class PersonaJdbcRepository implements Crud {

	private Connection cn;

	public PersonaJdbcRepository() {
		cn = new Conexion().conectar();
	}

	@Override
	public List<Persona> findAll() {
		List<Persona> lista = new ArrayList<>();
		try {
            String sql = "select * from persona";
            Statement st =cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            	Persona per = new Persona();
            	per.setId(rs.getInt("id"));
            	per.setNombre(rs.getString("nombre"));
            	lista.add(per);
            	
			}
            st.close();
            rs.close();
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void save(Persona persona) {
		try {
		       
            String sql = "insert into persona (id,nombre) values (?,?)";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setInt(1,persona.getId());
            ps.setString(2,persona.getNombre());
            ps.executeUpdate();

            ps.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub
		if(persona.getId()!=null && persona.getId()!=0) {
			try {
			       
	            String sql = "update  persona set nombre=?  where id=?";
	            PreparedStatement ps =cn.prepareStatement(sql);
	            ps.setInt(1,persona.getId());
	            ps.setString(2,persona.getNombre());
	            ps.executeUpdate();

	            ps.close();


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
		       
            String sql = "delete from persona where id=?";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

            ps.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Persona getOne(Integer id) {
		Persona person = new Persona();
		try {
            String sql = "select * from persona where id=?";
            PreparedStatement ps =cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            
            	person.setId(rs.getInt("id"));
            	person.setNombre(rs.getString("nombre"));
            	
            	
			}
            ps.close();
            rs.close();
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

}
