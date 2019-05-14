/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author Okala
 */
public interface IRegionController {
    public List<Region> getAll();

    public Region getById(String id);
    
    public List<Region> search(String keyword);

    public String insert(String regionId, String regionName);

    public String update(String regionId, String regionName);

    public String delete(String id);
    
}
