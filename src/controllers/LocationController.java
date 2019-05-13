/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author Okala
 */
public class LocationController implements ILocationController {

    private ILocationDAO ildao;

    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }

    @Override
    public List<Location> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Location> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        String result = "Maaf data tidak berhasil disimpan.";
        Location location = new Location(Short.valueOf(locationId), streetAddress, postalCode, city, stateProvince, new Country(countryId));
        if (locationId.isEmpty() || city.isEmpty()) {
            result = "Data location id atau city wajib diisi";
        } else {
            if(ildao.insert(location)){
                result = "true";
            }
        }
        return result;
    }

    @Override
    public String update(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
