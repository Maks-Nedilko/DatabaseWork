
package ua.itea.business;

import ua.itea.entity.EmplProj;
import ua.itea.service.EmplProjService;


public class MainAppEmplProj {
    
    public static void main(String[] args) {
        
        EmplProjService eps = new EmplProjService();
        
        EmplProj emplproj1 = new EmplProj();
        emplproj1.setEmplId(2L);
        emplproj1.setProjId(3L);
        //emplproj1.setEmplId(1L);
        //emplproj1.setProjId(3L);
        
        eps.update(emplproj1);
        
    }
    
}
