package com.lti.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("BidLib1")
public class BidderInfoLibraryImp1 implements BidderInfoLibrary {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addBidderInfo(BidderInformation bi) {
		// TODO Auto-generated method stub
		entityManager.persist(bi);
		
		
	}
	
	class BidderInformationRowMapper implements RowMapper<BidderInformation>{
		
		public BidderInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			BidderInformation bi = new BidderInformation();
			bi.setBidderName(rs.getString(2));
			bi.setBidEmail(rs.getString(3));
			return bi;
		}
		
	}

	public List<BidderInformation> showAllBidderDetails() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select b from BidderInformation as b ").getResultList();
		
	}
	
	

}
