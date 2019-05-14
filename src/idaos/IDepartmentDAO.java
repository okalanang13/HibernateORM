/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Department;

/**
 *
 * @author Okala
 */
public interface IDepartmentDAO {
    public List<Department> getAll();

    public Department getById(int id);

    public List<Department> search(Object keyword);

    public boolean insert(Department d);

    public boolean update(Department d);

    public boolean delete(int id);
}
