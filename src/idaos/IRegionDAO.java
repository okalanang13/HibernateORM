/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author Okala
 */
public interface IRegionDAO {

    public List<Region> getAll();

    public Region getById(int id);
    
    public List<Region> search(Object keyword);

    public boolean insert(Region r);

    public boolean update(Region r);

    public boolean delete(int id);
    
}
