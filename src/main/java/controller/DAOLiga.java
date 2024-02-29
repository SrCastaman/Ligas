package controller;

import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOLiga {
    private SessionFactory sessionFactory;

    public DAOLiga(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void insertarLiga(Liga liga){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(liga);
        session.getTransaction().commit();
        session.close();
    }
    public void insertarEquipoALiga(Equipo equipo){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.beginTransaction().commit();
        session.close();
    }
}
