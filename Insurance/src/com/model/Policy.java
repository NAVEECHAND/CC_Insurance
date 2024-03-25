package com.model;

import java.sql.Date;
import java.time.LocalDate;

public class Policy {
	 	private int policyId;
	    private String policyNumber;
	    private Date startDate;
	    private java.util.Date endDate;
	    private Double amount;
	    private Client client;
	    
		public Policy() {}

		public Policy(int policyId, String policyNumber, LocalDate startDate, LocalDate endDate, Double amount,
				Client client) {
			super();
			this.policyId = policyId;
			this.policyNumber = policyNumber;
			this.startDate = startDate;
			this.endDate = endDate;
			this.amount = amount;
			this.client = client;
		}

		public int getPolicyId() {
			return policyId;
		}

		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}

		public String getPolicyNumber() {
			return policyNumber;
		}

		public void setPolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public java.util.Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date date) {
			this.endDate = date;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		@Override
		public String toString() {
			return "Policy [policyId=" + policyId + ", policyNumber=" + policyNumber + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", amount=" + amount + ", client=" + client + "]";
		}

		
		
		
	    
	    

}
