/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author Okala
 */
public interface ILocationController {
    public List<Location> getAll();
    public Location getById(String id);
    public List<Location> search(String keyword);
    public String insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId);
    public String update(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId);
    public String delete(String locationId);
}
