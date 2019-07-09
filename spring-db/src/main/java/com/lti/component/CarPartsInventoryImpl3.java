package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("carPartsImpl3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {
	
	@Autowired
	@Qualifier("DS1")
	private DataSource dataSource;

	public void addNewPart(CarPart cp) {
		
			//Introducing Springs JDBCTemplate API
			JdbcTemplate jt=new JdbcTemplate(dataSource);
			
		
			jt.update("insert into TBL_CARPARTS values(?,?,?,?)",
			cp.getPartNo(),
			cp.getPartName(),
			cp.getCarModel(),
			cp.getQuantity());
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
			
			JdbcTemplate jt=new JdbcTemplate(dataSource);
			
			String sql="select * from TBL_CARPARTS where quantity=?";	//? will be replaced by 10
			List<CarPart> list=jt.query(sql, new CarPartRowMapper(),10);	//pass all arguments in the end
			
			return list;
						
		}

	}
