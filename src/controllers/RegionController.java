/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Okala
 */
public class RegionController implements IRegionController {

    private IRegionDAO irdao;

    public RegionController(SessionFactory factory) {
        irdao = new RegionDAO(factory);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
        return irdao.getById(Integer.parseInt(id));
    }

    @Override
    public List<Region> search(String keyword) {
        return irdao.search(keyword);
    }

    @Override
    public String insert(String regionId, String regionName) {
        String result = "Data tidak berhasil disimpan";
        if (regionId.isEmpty() || regionName.isEmpty()) {
            result = "Data tidak boleh kosong";
        } else {
            if (irdao.insert(new Region(new BigDecimal(regionId), regionName))) {
                result = "true";
            }
        }
        return result;
    }

    @Override
    public String update(String regionId, String regionName) {
        String result = "Data tidak berhasil diupdate";
        if (regionId.isEmpty() || regionName.isEmpty()) {
            result = "Data tidak boleh kosong";
        } else {
            if (irdao.update(new Region(new BigDecimal(regionId), regionName))) {
                result = "true";
            }
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Data tidak berhasil dihapus";
        if (id.isEmpty()) {
            result = "Data tidak boleh kosong";
        } else {
            if (irdao.delete(Integer.parseInt(id))) {
                result = "true";
            }
        }
        return result;
    }

}
