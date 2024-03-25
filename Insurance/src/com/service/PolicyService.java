package com.service;


import java.sql.SQLException;
import java.util.Collection;
import com.dao.*;
import com.exception.DatabaseConnectionException;
import com.model.Policy;

public class PolicyService {

		IPolicyService policyDao = new PolicyServiceImpl();

	    public Collection<Policy> getAllPolicies() throws SQLException, DatabaseConnectionException {
	        return policyDao.getAllPolicies();
	    }

	    public Policy getPolicy(int policyId) throws SQLException, DatabaseConnectionException {
	        return policyDao.getPolicy(policyId);
	    }

	    public boolean createPolicy(Policy policy) throws SQLException, DatabaseConnectionException {
	        return policyDao.createPolicy(policy);
	    }

	    public boolean updatePolicy(Policy policy) throws SQLException, DatabaseConnectionException {
	        return policyDao.updatePolicy(policy);
	    }

	    public boolean deletePolicy(int policyId) throws SQLException, DatabaseConnectionException {
	        return policyDao.deletePolicy(policyId);
	    }
	}



