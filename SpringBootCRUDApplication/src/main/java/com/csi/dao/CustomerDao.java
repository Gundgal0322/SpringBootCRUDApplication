package com.csi.dao;

import com.csi.model.Customer;

import java.security.PublicKey;
import java.util.List;

public interface CustomerDao {

    public void signUp(Customer customer);

    public boolean signIn(String custEmailId, String custPassword);

    public List<Customer> getAllData();

    public Customer getDataById(int custId);

    public List<Customer> getDataByName(String custName);

    public void updateData(int custId, Customer customer);

    public void deleteDataById(int custId);

    public void deleteAllData();
 }
