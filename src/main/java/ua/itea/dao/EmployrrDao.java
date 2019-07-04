/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.dao;

import java.util.List;

import ua.itea.entity.Employrr;

/**
 *
 * @author makst
 */
public interface EmployrrDao {
    
     //create
    
    void add(Employrr employrr);
    
    //read
    
    Employrr getById(long id);
    List<Employrr> getAll();
    
    //update
    
    void update(Employrr employrr);
    
    //delete
    
    void delete(Employrr employrr);
    
}
