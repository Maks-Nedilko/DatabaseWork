/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.dao;

import java.util.List;
import ua.itea.entity.EmplProj;


/**
 *
 * @author makst
 */
public interface EmplProjDao {
    
     //create
    
    void add(EmplProj emplproj);
    
    //read
    
    EmplProj getById(long emplId, long projId);
    List<EmplProj> getAll();
    
    //update
    
    void update(EmplProj emplproj);
    
    //delete
    
    void delete(EmplProj emplproj);
    
}
