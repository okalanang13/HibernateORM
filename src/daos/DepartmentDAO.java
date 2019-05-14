/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Okala
 */
public class DepartmentDAO implements IDepartmentDAO{
    
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public DepartmentDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }
    
    @Override
    public List<Department> getAll() {
        List<Department> locations = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            locations = session.createQuery("FROM Department").list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return locations;
    }

    @Override
    public Department getById(int id) {
        Department department = new Department();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Department WHERE departmentId=:1 ORDER BY 1");
            query.setParameter(1, id);
            department = (Department) query.uniqueResult();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return department;
    }

    @Override
    public List<Department> search(Object keyword) {
        List<Department> departments = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Department.class.getSimpleName() + " WHERE ";
            for (Field field : Department.class.getDeclaredFields()) {
                hql += field.getName() + " LIKE '%" + keyword + "%' OR ";
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            departments = session.createQuery(hql).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return departments;
    }

    @Override
    public boolean insert(Department d) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(d);
            transaction.commit();
            result = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(d);
            transaction.commit();
            result = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(id);
            transaction.commit();
            result = true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
