package com.csi.service;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerService {

    public void signUp(Customer customer);

    public boolean signIn(String custEmailId, String custPassword);

    public List<Customer> getAllData();

    public Customer getDataById(int custId);

    public List<Customer> getDataByName(String custName);

    public void updateData(int custId, Customer customer);

    public void deleteDataById(int custId);

    public void deleteAllData();
}
