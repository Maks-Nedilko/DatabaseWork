/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.business;

import java.sql.Date;
import java.time.Month;
import java.util.List;
import ua.itea.entity.Employrr;
import ua.itea.service.EmployrrService;

/**
 *
 * @author makst
 */
public class MainAppEmpl {
    
    public static void main(String[] args) {
        
        EmployrrService es = new EmployrrService();
        
        Employrr employrr1 = new Employrr();
        employrr1.setId(1L);
        employrr1.setFirst_name("Maks");
        employrr1.setLast_name("Nedilko");
        Date date1 = Date.valueOf("1998-09-18");
        employrr1.setBirthday(date1);
        employrr1.setAddress(1L);
        es.update(employrr1);
        
        Employrr employrr2 = new Employrr();
        employrr2.setId(2L);
        es.delete(employrr2);
        
        Employrr employrr3 = new Employrr();
        employrr3.setId(2L);
        employrr3.setFirst_name("Igor");
        employrr3.setLast_name("Aniskov");
        Date date2 = Date.valueOf("1999-08-03");
        employrr3.setBirthday(date2);
        employrr3.setAddress(2L);
        es.add(employrr3);
        
        Employrr employrr4 = new Employrr();
        employrr4.setId(3L);
        employrr4.setFirst_name("Maks");
        employrr4.setLast_name("Volovnik");
        Date date4 = Date.valueOf("2000-04-04");
        employrr4.setBirthday(date4);
        employrr4.setAddress(3L);
        es.add(employrr4);
        
        List<Employrr> list = es.getAll();
        if (list != null) {
            for (Employrr ad : list) {
                System.out.println(ad);
            }
        }
        
        Employrr employrr5 = es.getById(1);
        System.out.println(employrr5);
        
    }
    
    
    
    
}
