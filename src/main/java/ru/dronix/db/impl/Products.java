/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dronix.db.impl;

import java.util.List;
import ru.dronix.entity.TableProducts;

/**
 *
 * @author ADMIN
 */
public interface Products {
    
    public void addProduct(TableProducts product);
    public void updateBus(TableProducts product);
    public void deleteBus(TableProducts product);
    public TableProducts getProductById(Integer product_id);
    public List<TableProducts> getAllProducts();
}
