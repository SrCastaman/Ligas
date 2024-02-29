package controller;

import database.HibernateUtil;
import model.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DAOPartido {
    private SessionFactory sessionFactory;

    public DAOPartido(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void insertarPartido(Partido partido){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(partido);
        session.getTransaction().commit();
        session.close();


    }

    public String getPartidos(int id_liga){
        StringBuilder resultado = new StringBuilder();
        DAOEquipo operacionesEquipo = new DAOEquipo();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Partido> query = session.createQuery("select a from Partido a WHERE id_liga = " + id_liga, Partido.class);
        List<Partido> listado = query.list();
        resultado.append("PARTIDOS DE LA LIGA CON ID " + id_liga + " : \n");
        for(Partido item : listado){
            resultado.append("Fecha de partido: ").append(item.getFecha_partido()).append(". Marcador: ").append(item.getGoles_equipo_local()).append("-").append
                    (item.getGoles_equipo_visitante()).append(" . Equipo local: ").
                    append(operacionesEquipo.getNombreEquipoById(item.getId_equipo_local())).append(". Equipo visitante: ").
                    append(operacionesEquipo.getNombreEquipoById(item.getId_equipo_visitante())).append("\n");
        }
        session.getTransaction().commit();
        session.close();
        return resultado.toString();

    }
}
