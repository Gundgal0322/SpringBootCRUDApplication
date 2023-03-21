package com.csi.service;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements  CustomerService {

    @Autowired
    CustomerDao customerDaoImpl;

    @Override
    public void signUp(Customer customer) {
        customerDaoImpl.signUp(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {
        return customerDaoImpl.signIn(custEmailId, custPassword);
    }

    @Override
    public List<Customer> getAllData() {
        return customerDaoImpl.getAllData();
    }

    @Override
    public Customer getDataById(int custId) {
        return customerDaoImpl.getDataById(custId);
    }

    @Override
    public List<Customer> getDataByName(String custName) {
        return customerDaoImpl.getDataByName(custName);
    }

    @Override
    public void updateData(int custId, Customer customer) {
        customerDaoImpl.updateData(custId, customer);
    }

    @Override
    public void deleteDataById(int custId) {
    customerDaoImpl.deleteDataById(custId);
    }

    @Override
    public void deleteAllData() {
        customerDaoImpl.deleteAllData();
    }
}
