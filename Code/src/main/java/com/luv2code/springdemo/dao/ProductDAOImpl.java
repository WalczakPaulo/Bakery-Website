package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Product> theQuery =
                currentSession.createQuery("from Product order by productName",
                        Product.class);

        // execute query and get result list
        List<Product> products = theQuery.getResultList();

        // return the results
        return products;
    }

    @Override
    public Product getProduct(int theID) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Product.class, theID);
    }
}
