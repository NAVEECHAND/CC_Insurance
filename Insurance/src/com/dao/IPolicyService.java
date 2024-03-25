package com.dao;

import com.exception.DatabaseConnectionException;
import com.model.Policy;

import java.sql.SQLException;
import java.util.List;

public interface IPolicyService {

    void createPolicy(Policy policy) throws DatabaseConnectionException, SQLException;

    Policy getPolicy(int policyId) throws DatabaseConnectionException, SQLException;

    List<Policy> getAllPolicies() throws DatabaseConnectionException, SQLException;

    void updatePolicy(Policy policy) throws DatabaseConnectionException, SQLException;

    void deletePolicy(int policyId) throws DatabaseConnectionException, SQLException;
}
