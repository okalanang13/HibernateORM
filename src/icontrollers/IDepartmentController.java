/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Department;

/**
 *
 * @author Okala
 */
public interface IDepartmentController {
    public List<Department> getAll();

    public Department getById(String id);

    public List<Department> search(Object keyword);

    public boolean insert(String departmentId, String departmentName, String managerId, String locationId);

    public boolean update(String departmentId, String departmentName, String managerId, String locationId);

    public boolean delete(String id);
}
