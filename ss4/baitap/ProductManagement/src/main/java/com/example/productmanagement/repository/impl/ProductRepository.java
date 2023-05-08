package com.example.productmanagement.repository.impl;

import com.example.productmanagement.config.ConnectionUtil;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            return  session.createQuery("FROM Product ",Product.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction ;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction ;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            product.setName(product.getName());
            product.setDate(product.getDate());
            product.setDetail(product.getDetail());
            session.update(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session ;
        Transaction transaction ;
        try {
            Product product = findById(id);
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        String query = " FROM Product where id = :id";
        return session.createQuery(query, Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        String query = " FROM Product where name like concat('%',:name,'%') ";
        return session.createQuery(query, Product.class).setParameter("name", name).getResultList();
    }

}
