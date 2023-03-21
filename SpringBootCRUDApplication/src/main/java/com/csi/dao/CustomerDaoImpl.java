package com.csi.dao;

import com.csi.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CustomerDaoImpl implements CustomerDao{

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();

    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {
        boolean flag= false;

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        for (Customer customer : getAllData()){

            if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<Customer> getAllData() {
        Session session = factory.openSession();
        return session.createQuery("from Customer").list();
    }

    @Override
    public Customer getDataById(int custId) {

        Session session = factory.openSession();

        Customer customer = (Customer) session.get(Customer.class, custId);
        return  customer;
    }

    @Override
    public List<Customer> getDataByName(String custName) {
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        return getAllData().stream().filter(cust-> cust.getCustName().equals(custName)).collect(Collectors.toList());

        }

    @Override
    public void updateData(int custId, Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        Customer customer1 = getDataById(custId);

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        session.update(customer1);

        transaction.commit();

    }

    @Override
    public void deleteDataById(int custId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(getDataById(custId));

        transaction.commit();
    }

    @Override
    public void deleteAllData() {

        Session session = factory.openSession();

        for (Customer customer: getAllData()){

            Transaction transaction = session.beginTransaction();

            session.delete(customer);
            transaction.commit();
        }

    }
}
