/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.dao;

import java.util.List;
import ua.itea.entity.Address;

/**
 *
 * @author makst
 */
public interface AddressDao {
    
    //create
    
    void add(Address address);
    
    //read
    
    Address getById(long id);
    List<Address> getAll();
    
    //update
    
    void update(Address address);
    
    //delete
    
    void delete(Address address);
    
}
