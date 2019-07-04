/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.business;

import java.util.List;
import ua.itea.entity.Project;
import ua.itea.service.ProjectService;

/**
 *
 * @author makst
 */
public class MainAppProj {

    public static void main(String[] args) {

        ProjectService ps = new ProjectService();
        
        Project project1 = new Project();
        project1.setTitle("First_Project");
        project1.setId(1);
        ps.update(project1);
        
        Project project2 = new Project();
        project2.setId(2L);
        ps.delete(project2);

        Project project3 = new Project();
        project3.setId(2L);
        project3.setTitle("Second_Project");
        ps.add(project3);
        
        Project project4 = new Project();
        project4.setId(3L);
        project4.setTitle("Third_Project");
        ps.add(project4);
        
        
        
        List<Project> list = ps.getAll();
        if(list!=null){
            for(Project pj : list){
                System.out.println(pj);
            }
        }
        
        Project project5 = ps.getById(1);
        System.out.println(project5);
        

    }

}
