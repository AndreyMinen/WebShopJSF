/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dronix.db;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import ru.dronix.db.impl.Products;
import ru.dronix.entity.Category;
import ru.dronix.entity.TableProducts;

public class DB_Products implements Products {

    private List<TableProducts> products=null;
    private List<Category> categories=null;
    private SessionFactory session=HibernateUtil.getSessionFactory();
    private Criteria criteria=null;

    
    @Override
    public void addProduct(TableProducts product) {
        try{
            
            session.getCurrentSession().beginTransaction();
            session.getCurrentSession().save(product);
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBus(TableProducts product){
        
        try{
            
            session.getCurrentSession().beginTransaction();
            session.getCurrentSession().update(product);
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBus(TableProducts product) {
        try{
            
            session.getCurrentSession().beginTransaction();
            session.getCurrentSession().delete(product);
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public TableProducts getProductById(Integer product_id){
        TableProducts product=null;
        
        try{
            
            session.getCurrentSession().beginTransaction();
            product=(TableProducts)session.getCurrentSession().get(TableProducts.class, product_id);
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
        return product;
    }
    
    @Override
    public List<TableProducts> getAllProducts(){
        
        try{
            
            session.getCurrentSession().beginTransaction();
            products=session.getCurrentSession().createCriteria(TableProducts.class).list();
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
        
        return products;
    }
    
    
    public List<TableProducts> getProductsOrderByPrice(String ordered){
        try{
            
            session.getCurrentSession().beginTransaction();
            criteria=session.getCurrentSession().createCriteria(TableProducts.class);
            
            switch(ordered){
                case "asc":
                    products=(List<TableProducts>)criteria.addOrder(Order.asc("price")).list();
                    break;
                case "desc":
                    products=(List<TableProducts>)criteria.addOrder(Order.desc("price")).list();
                    break;
            }
            
            session.getCurrentSession().getTransaction().commit();
        
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
        
        return products;
        
    }
    
    public List<Category> getCategories(String type){
        try{
            
            session.getCurrentSession().beginTransaction();
            categories=session.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("type", type)).list();
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            ex.printStackTrace();
        }
        
        return categories;
    }
    
    public List<TableProducts> getProductsByCategory(String type, String brand){
        
        try{
            
            session.getCurrentSession().beginTransaction();
            
            products=session.getCurrentSession().createCriteria(TableProducts.class).add(Restrictions.eq("typeProduct", type)).add(Restrictions.eq("brand", brand)).list();
            
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            
            ex.printStackTrace();
        }
        
        return products;
    }
    
    public List<TableProducts> getProductsAllModel(String type){
        
        try{
            
            session.getCurrentSession().beginTransaction();
            
            products=session.getCurrentSession().createCriteria(TableProducts.class).add(Restrictions.eq("typeProduct", type)).list();
            
            session.getCurrentSession().getTransaction().commit();
            
        }catch(Exception ex){
            if(session.getCurrentSession().getTransaction().isActive()){
                session.getCurrentSession().getTransaction().rollback();
                session.close();
            }
            
            ex.printStackTrace();
        }
        
        return products;
    }
    
}
