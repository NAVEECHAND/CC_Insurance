package com.controller;
import com.exception.DatabaseConnectionException;
import com.model.Policy;
import com.service.PolicyService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InsuranceController {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        PolicyService policyService = new PolicyService();
	        while (true) {
	            System.out.println();
	            System.out.println("*Insurance Policy*");
	            System.out.println("Press 1. Get Policy By PolicyId");
	            System.out.println("Press 2. Get All Policies");
	            System.out.println("Press 3. Create Policy");
	            System.out.println("Press 4. Update Policy");
	            System.out.println("Press 5. Delete Policy");
	            System.out.println("Press 0. Exit");
	            System.out.println("");
	            
	            int input = sc.nextInt();
	            if (input == 0) {
	                System.out.println("Exiting. Thank you!");
	                break;
	            }
	            switch (input) {
	                case 1:
	                    try {
	                        System.out.println("Enter Policy Id: ");
	                        int policyId = sc.nextInt();
	                        Policy policy = policyService.getPolicy(policyId);
	                        if (policy != null) {
	                            System.out.println(policy);
	                        } else {
	                            System.out.println("Policy not found!");
	                        }
	                    } catch (DatabaseConnectionException | SQLException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 2:
	                    try {
	                        List<Policy> policies = (List<Policy>) policyService.getAllPolicies();
	                        for (Policy policy : policies) {
	                            System.out.println(policy);
	                        }
	                    } catch (DatabaseConnectionException | SQLException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 3:
	                    try {
	                        System.out.println("Enter Policy Number: ");
	                        String policyNumber = sc.next();
	                        System.out.println("Enter Start Date (YYYY-MM-DD): ");
	                        String startDate = sc.next();
	                        System.out.println("Enter End Date (YYYY-MM-DD): ");
	                        String endDate = sc.next();
	                        System.out.println("Enter Amount: ");
	                        Double Amount = sc.nextDouble();
	                       
	                        Policy newPolicy = new Policy();
	                        newPolicy.setPolicyNumber(policyNumber);
	                        newPolicy.setStartDate(java.sql.Date.valueOf(startDate));
	                        newPolicy.setEndDate(java.sql.Date.valueOf(endDate));
	                        newPolicy.setAmount(Amount);
	                        
	                        boolean created = policyService.createPolicy(newPolicy);
	                        if (created) {
	                            System.out.println("Policy created successfully!");
	                        } else {
	                            System.out.println("Failed to create policy.");
	                        }
	                    } catch (DatabaseConnectionException | SQLException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 4:
	                    try {
	                        System.out.println("Enter Policy Id: ");
	                        sc.nextInt();
	                        System.out.println("Enter Policy Number: ");
	                        sc.next();
	                        System.out.println("Enter Start Date (YYYY-MM-DD): ");
	                        sc.next();
	                        System.out.println("Enter End Date (YYYY-MM-DD): ");
	                        sc.next();
	                        System.out.println("Enter Premium Amount: ");
	                        sc.nextDouble();
	                      
	                        Policy updatedPolicy = new Policy();
	                       
	                       
	                        boolean updated = policyService.updatePolicy(updatedPolicy);
	                        if (updated) {
	                            System.out.println("Policy updated successfully!");
	                        } else {
	                            System.out.println("Failed to update policy.");
	                        }
	                    } catch (DatabaseConnectionException | SQLException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 5:
	                    try {
	                        System.out.println("Enter Policy Id to delete: ");
	                        int deletePolicyId = sc.nextInt();
	                       
	                        boolean deleted = policyService.deletePolicy(deletePolicyId);
	                        if (deleted) {
	                            System.out.println("Policy deleted successfully!");
	                        } else {
	                            System.out.println("Failed to delete policy.");
	                        }
	                    } catch (DatabaseConnectionException | SQLException e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                default:
	                    System.out.println("Invalid input. Please try again.");
	            }
	        }
	        sc.close();
	    }
	}


