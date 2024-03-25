package com.dao;

import com.exception.DatabaseConnectionException;
import com.model.Client;
import com.model.Policy;
import com.util.DBConnection;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PolicyServiceImpl implements IPolicyService{


	    @Override
	    public boolean createPolicy(Policy policy) throws DatabaseConnectionException, SQLException {
	    	Connection conn = DBConnection.getdbConnect();
	    	
	        String sql = "INSERT INTO Policy (policyId, policyNumber, startDate, endDate, premiumAmount, clientId) VALUES (?, ?, ?, ?, ?, ?)";
	       
			PreparedStatement pstmt = conn.prepareStatement(sql);

	        pstmt.setInt(1, policy.getPolicyId());
	        pstmt.setString(2, policy.getPolicyNumber());
	        pstmt.setDate(3, policy.getStartDate());
	        pstmt.setDate(4, policy.getEndDate());
	        pstmt.setDouble (5, policy.getAmount());
	        pstmt.setInt(6, policy.getClient().getClientId());

	        int rowsInserted = pstmt.executeUpdate();
	        return rowsInserted > 0;
	    }

	    @Override
	    public Policy getPolicy(int policyId) throws DatabaseConnectionException, SQLException {
	    	Connection conn = DBConnection.getdbConnect();
	        String sql = "SELECT * FROM Policy WHERE policyId = ?";
	     
			PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, policyId);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            Policy policy = new Policy();
	            policy.setPolicyId(rs.getInt("policyId"));
	            policy.setPolicyNumber(rs.getString("policyNumber"));
	            policy.setStartDate(rs.getDate("startDate"));
	            policy.setEndDate(rs.getDate("endDate"));
	            policy.setAmount(rs.getDouble("Amount"));
	           
	            Client client = getClientById(rs.getInt("clientId"));
	            policy.setClient(client);
	            return policy;
	        }

	        return null;
	    }

	    private Client getClientById(int int1) {
			
			return null;
		}

		@Override
	    public List<Policy> getAllPolicies() throws DatabaseConnectionException, SQLException {
			
			Connection conn = DBConnection.getdbConnect();
	        List<Policy> policies = new ArrayList<>();
	        String sql = "SELECT * FROM Policy";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Policy policy = new Policy();
	            policy.setPolicyId(rs.getInt("policyId"));
	            policy.setPolicyNumber(rs.getString("policyNumber"));
	            policy.setStartDate(rs.getDate("startDate"));
	            policy.setEndDate(rs.getDate("endDate"));
	            policy.setAmount(rs.getDouble("Amount"));
	           
	            Client client = getClientById(rs.getInt("clientId"));
	            policy.setClient(client);
	            policies.add(policy);
	        }

	        return policies;
	    }

	    @Override
	    public boolean updatePolicy(Policy policy) throws DatabaseConnectionException, SQLException {
	    	Connection conn = DBConnection.getdbConnect();
	        String sql = "UPDATE Policy SET policyNumber = ?, startDate = ?, endDate = ?, premiumAmount = ?, clientId = ? WHERE policyId = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, policy.getPolicyNumber());
	        pstmt.setDate(2, policy.getStartDate());
	        pstmt.setDate(3, policy.getEndDate());
	        pstmt.setDouble(4, policy.getAmount());
	        pstmt.setInt(5, policy.getClient().getClientId());
	        pstmt.setInt(6, policy.getPolicyId());

	        int rowsUpdated = pstmt.executeUpdate();
	        return rowsUpdated > 0;
	    }

	    @Override
	    public boolean deletePolicy(int policyId) throws DatabaseConnectionException, SQLException {
	    	Connection conn = DBConnection.getdbConnect();
	        String sql = "DELETE FROM Policy WHERE policyId = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, policyId);

	        int rowsDeleted = pstmt.executeUpdate();
	        return rowsDeleted > 0;
	    }
	}

