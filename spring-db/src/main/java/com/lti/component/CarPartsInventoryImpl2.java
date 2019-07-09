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
import org.springframework.stereotype.Component;

@Component("carPartsImpl2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {
	
	@Autowired
	@Qualifier("DS1")
	private DataSource dataSource;

	public void addNewPart(CarPart cp) {
		Connection conn=null;
		try {
			
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			conn=dataSource.getConnection(); //use datasource for establishing connection
			
			PreparedStatement stmt=conn.prepareStatement("insert into TBL_CARPARTS values(?,?,?,?)");
			
			stmt.setInt(1, cp.getPartNo());
			stmt.setString(2, cp.getPartName());
			stmt.setString(3, cp.getCarModel());
			stmt.setInt(4, cp.getQuantity());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close(); }
			catch(Exception e)
			{

			}

		}
	}

		public List<CarPart> getAvailableParts() {
			Connection conn=null;
			ResultSet rs=null; 
			List<CarPart> partsList = new ArrayList<CarPart>();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");				
				PreparedStatement stmt=conn.prepareStatement("select * from TBL_CARPARTS");		
				rs=stmt.executeQuery();
				while(rs.next()) {
					CarPart p1=new CarPart();
					p1.setPartNo(rs.getInt(1));
					p1.setPartName(rs.getString(2));
					p1.setCarModel(rs.getString(3));
					p1.setQuantity(4);
					partsList.add(p1);
				}
				
			}
			catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver not found");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {conn.close(); }
				catch(Exception e)
				{
					
				}
				return partsList;
			}
		}

	}
