/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dronix.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import ru.dronix.db.DB_Products;
import ru.dronix.entity.Category;

/**
 *
 * @author ADMIN
 */

@ManagedBean(eager = true)
@SessionScoped
public class CategoryController {
    
    private List<Category> mobiles=null;
    private List<Category> notepad=null;
    private List<Category> notebook=null;
    private DB_Products dataBase=null;
    
    public CategoryController(){
        mobiles=new ArrayList<Category>();
        notepad=new ArrayList<Category>();
        notebook=new ArrayList<Category>();
        dataBase=new DB_Products();
        mobiles=dataBase.getCategories("mobile");
        notepad=dataBase.getCategories("notepad");
        notebook=dataBase.getCategories("notebook");
    }
    
    public List<Category> getMobiles(){
        return mobiles;
    }

    public List<Category> getNotepad() {
        return notepad;
    }

    public List<Category> getNotebook() {
        return notebook;
    }
    
}
