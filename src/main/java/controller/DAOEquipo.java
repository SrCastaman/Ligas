package controller;

import database.HibernateUtil;
import model.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DAOEquipo {
    private SessionFactory sessionFactory;

    public DAOEquipo(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void insertarEquipo(Equipo equipo){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();
    }
    public String getEquipos(){
        StringBuffer resultado = new StringBuffer();
        resultado.append("EQUIPOS:\n");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Equipo> query = session.createQuery("select a from Equipo a", Equipo.class);
        List<Equipo> listado = query.list();
        for(Equipo item: listado){
            resultado.append("Nombre: ").append(item.getNombre_equipo()).append(". Ciudad: ").append(item.getCiudad()).append("\n");
        }
        session.getTransaction().commit();
        session.close();
        return resultado.toString();
    }

    public void getEquipo(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Equipo> query = session.createQuery("select a from Equipo a WHERE id_equipo =" + id, Equipo.class);
        Equipo equipo = query.getSingleResult();
        System.out.println("Nombre: " + equipo.getNombre_equipo());
        session.getTransaction().commit();
        session.close();
    }
    public String getNombreEquipoById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Equipo> query = session.createQuery("select a from Equipo a WHERE id_equipo =" + id, Equipo.class);
        Equipo equipo = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return equipo.getNombre_equipo();
    }
    public void eliminarEquipo(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Equipo a WHERE a.id_equipo=" + id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
