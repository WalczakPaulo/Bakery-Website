package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {


    private SessionFactory sessionFactory;

    @Override
    public List<OrderItem> getOrderedItems() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderItem> theQuery =
                currentSession.createQuery("from OrderItem",
                        OrderItem.class);

        // execute query and get result list
        List<OrderItem> orderedItems = theQuery.getResultList();

        // return the results
        return orderedItems;
    }


}
