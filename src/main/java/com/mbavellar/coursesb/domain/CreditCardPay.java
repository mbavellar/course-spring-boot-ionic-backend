package com.mbavellar.coursesb.domain;

import javax.persistence.Entity;

import com.mbavellar.coursesb.domain.enums.PaymentState;

@Entity
public class CreditCardPay extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public CreditCardPay() { }
	
	public CreditCardPay(Integer id, PaymentState paymentState, Order order, Integer numberOfInstallments) {
		super(id, paymentState, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
}
