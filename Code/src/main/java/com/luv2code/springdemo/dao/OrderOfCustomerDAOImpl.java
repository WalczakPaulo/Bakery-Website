package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.OrderOfCustomer;
import com.luv2code.springdemo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderOfCustomerDAOImpl implements OrderOfCustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderOfCustomer> getOrders() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderOfCustomer> theQuery =
                currentSession.createQuery("from OrderOfCustomer",
                        OrderOfCustomer.class);

        // execute query and get result list
        List<OrderOfCustomer> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public void saveOrderOfCustomer(OrderOfCustomer theOrder) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theOrder);
    }
}
