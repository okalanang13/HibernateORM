/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Okala
 */
public class LocationDAO implements ILocationDAO {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public LocationDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            locations = session.createQuery("FROM Location").list();
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
    public Location getById(int id) {
        Location location = new Location();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Location WHERE locationId=:1 ORDER BY 1");
            query.setParameter(1, id);
            location = (Location) query.uniqueResult();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return location;
    }

    @Override
    public List<Location> search(Object keyword) {
        List<Location> locations = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Location.class.getSimpleName() + " WHERE ";
            for (Field field : Location.class.getDeclaredFields()) {
                hql += field.getName() + " LIKE '%" + keyword + "%' OR ";
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            locations = session.createQuery(hql).list();
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
    public boolean insert(Location r) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(r);
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
    public boolean update(Location r) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(r);
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
