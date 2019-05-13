/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.LocationController;
import daos.LocationDAO;
import icontrollers.ILocationController;
import models.Location;

/**
 *
 * @author Okala
 */
public class ManualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Manual Test LocationDAO Insert
//        LocationDAO ldao = new LocationDAO(HibernateUtil.getSessionFactory());       
//        Location location = new Location((short) 3300, "Kediri");
//        System.out.println(ldao.insert(location));
        
        //Manual Test LocationController Insert
//        ILocationController ilc = new LocationController(HibernateUtil.getSessionFactory());
//        String result = ilc.insert("3400", "", "", "Pare", "", "");
//        System.out.println(result);
    }
}
