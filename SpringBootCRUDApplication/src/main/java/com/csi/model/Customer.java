package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue

    @Column(name = "cust_id")
    private  int custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_account_balance")
    private Double custAccountBalance;

    @Column(name = "cust_contact_number")
    private Long custContactNumber;

    @Column(name = "cust_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @Column(name = "cust_email_id")
    private String custEmailId;

    @Column(name = "cust_password")
    private String custPassword;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public Double getCustAccountBalance() {
        return custAccountBalance;
    }

    public void setCustAccountBalance(Double custAccountBalance) {
        this.custAccountBalance = custAccountBalance;
    }

    public Long getCustContactNumber() {
        return custContactNumber;
    }

    public void setCustContactNumber(Long custContactNumber) {
        this.custContactNumber = custContactNumber;
    }

    public Date getCustDOB() {
        return custDOB;
    }

    public void setCustDOB(Date custDOB) {
        this.custDOB = custDOB;
    }

    public String getCustEmailId() {
        return custEmailId;
    }

    public void setCustEmailId(String custEmailId) {
        this.custEmailId = custEmailId;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }
}
