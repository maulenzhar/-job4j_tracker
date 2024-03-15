package ru.job4j.tracker.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.Item;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                            "UPDATE Item SET name = :fName, created = : fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Item order by id");
            session.getTransaction().commit();
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return List.of();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Item as i where i.name like :fKey")
                    .setParameter("fKey", "%" + key + "%");
            session.getTransaction().commit();
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return List.of();
    }

    @Override
    public Item findById(int id) {
        Session session = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "from Item as i where i.id = :fId", Item.class);
            query.setParameter("fId", id);
            return query.uniqueResult();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return new Item();
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

}