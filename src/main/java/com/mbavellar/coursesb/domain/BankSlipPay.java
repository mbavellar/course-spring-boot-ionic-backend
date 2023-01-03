package com.mbavellar.coursesb.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mbavellar.coursesb.domain.enums.PaymentState;

@Entity
public class BankSlipPay extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dueDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date payDate;
	
	public BankSlipPay() { }
	
	public BankSlipPay(Integer id, PaymentState paymentState, Order order, Date dueDate, Date payDate) {
		super(id, paymentState, order);
		this.dueDate = dueDate;
		this.payDate = payDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}
