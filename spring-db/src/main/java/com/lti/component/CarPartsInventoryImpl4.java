package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carPartsImpl4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {
	
	//This time we are injecting entity manager
	//object required when using JPA
	//Autowired doesn't work for injecting the same
	//We use @PersistentContext annotation instead
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional				//Begin and commit codes 
	public void addNewPart(CarPart cp) {
		
			entityManager.persist(cp);
			
	}
	class CarPartRowMapper implements RowMapper<CarPart>{

		public CarPart mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CarPart carPart =new CarPart();
			
			carPart.setPartNo(rs.getInt(1));
			carPart.setPartName(rs.getString(2));
			carPart.setCarModel(rs.getString(3));
			carPart.setQuantity(rs.getInt(4));
			
			return carPart;
		
		}
		
	}

		public List<CarPart> getAvailableParts() {
			
			
			/* Query q = entityManager.createQuery("select obj from  CarPart as obj ");
			List<CarPart> list=q.getResultList();
			
			return list; */
			
			return entityManager.createQuery("select obj from  CarPart as obj ").getResultList();
						
		}

	}
