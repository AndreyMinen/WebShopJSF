/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dronix.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import ru.dronix.db.DB_Products;
import ru.dronix.entity.TableProducts;


@ManagedBean(eager = true)
@SessionScoped
public class ProductsController implements Serializable{
    
    private List<TableProducts> products=null;
    private DB_Products dataBase=null;
    private String methodSort;
    private String type;
    private String brand;
    
    public ProductsController(){
        products=new ArrayList<TableProducts>();
        dataBase=new DB_Products();
        setDefaultSort();
        products=dataBase.getAllProducts();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMethodSort() {
        return methodSort;
    }

    public void setMethodSort(String methodSort) {
        this.methodSort = methodSort;
    }
    
    public List<TableProducts> getProducts() {
        return products;
    }

    public void setProducts(List<TableProducts> products) {
        this.products = products;
    }
    
    public void ordered(){
        Map<String, String> params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        products=dataBase.getProductsOrderByPrice(params.get("sort"));
        setSorting(params.get("sort"));
        setDefaultTypeAndBrand();
    }
    
    private void setSorting(String method){
        switch(method){
            case "asc":
                methodSort="От дешовых к дорогим";
                break;
            case "desc":
                methodSort="От дорогих к дешовым";
                break;    
        }
    }
    
    private void setDefaultTypeAndBrand(){
        type="Главная страница";
        brand="Все модели";
    }
    
    private void setTypeAndBrand(Map<String,String> param){
        switch(param.get("type")){
            case "mobile":
                type="Мобильные телефоны";
                break;
            case "notebook":
                type="Ноутбуки";
                break;
            case "notepad":
                type="Планшеты";
                break;
        }
        
        if(!(param.get("brand")==null)){
            brand=param.get("brand");
        }else{
            brand="Все модели";
        }
        
        methodSort="Без сортировки";
        
    }
    
    private void setDefaultSort(){
        methodSort="Без сортировки";
        type="Главная страница";
        brand="Все модели";
    }
    
    public void productsByCategory(){
        Map<String,String>params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        products=dataBase.getProductsByCategory(params.get("type"), params.get("brand"));
        setTypeAndBrand(params);
    }
    
    public void productsByAllModel(){
        Map<String,String>params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        products=dataBase.getProductsAllModel(params.get("type"));
        setTypeAndBrand(params);
    }
    

    
}
