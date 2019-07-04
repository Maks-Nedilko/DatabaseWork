
package ua.itea.dao;

import java.util.List;
import ua.itea.entity.Project;





public interface ProjectDao {
    
   //create
    
    void add(Project project);
    
    //read
    
    Project getById(long id);
    List<Project> getAll();
    
    //update
    
    void update(Project project);
    
    //delete
    
    void delete(Project project);
    
}
