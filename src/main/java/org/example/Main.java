package org.example;

import controller.DAOEquipo;
import controller.DAOLiga;
import controller.DAOPartido;
import database.HibernateUtil;
import model.Equipo;
import model.Liga;
import model.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {
        DAOEquipo operacionesEquipo = new DAOEquipo();
        DAOLiga operacionesLiga = new DAOLiga();
        DAOPartido operacionesPartido = new DAOPartido();
        operacionesLiga.insertarLiga(new Liga("Copa de España","10 de Septiembre","10 de Diciembre"));
        operacionesEquipo.insertarEquipo(new Equipo("Sevilla CF","Sevilla",1));
        operacionesEquipo.insertarEquipo(new Equipo("Madrid CF","Madrid",1));
        operacionesEquipo.insertarEquipo(new Equipo("Barcelona CF","Barcelona",1));
        operacionesEquipo.insertarEquipo(new Equipo("Valladolid CF","Valladolid",1));
        operacionesEquipo.insertarEquipo(new Equipo("Cádiz CF","Cádiz",1));
        operacionesEquipo.insertarEquipo(new Equipo("Ourense CF","Ourense",1));
        operacionesEquipo.insertarEquipo(new Equipo("Agoncillo CF","Agoncillo",1));
        operacionesEquipo.insertarEquipo(new Equipo("Mataró CF","Mataró",1));
        operacionesEquipo.insertarEquipo(new Equipo("Villaviciosa CF", "Villaviciosa", 1));
        operacionesEquipo.insertarEquipo(new Equipo("Tarragona CF", "Tarragona", 1));
        operacionesPartido.insertarPartido(new Partido("15 de Septiembre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                1,2,1));
        operacionesPartido.insertarPartido(new Partido("27 de Septiembre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                3,4,1));
        operacionesPartido.insertarPartido(new Partido("19 de Octubre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                5,6,1));
        operacionesPartido.insertarPartido(new Partido("23 de Octubre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                7,8,1));
        operacionesPartido.insertarPartido(new Partido("4 de Noviembre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                2,6,1));
        operacionesPartido.insertarPartido(new Partido("16 de Noviembre",(int)(Math.random()*5+0),(int)(Math.random()*5+0),
                1,8,1));
        operacionesEquipo.getEquipo(4);
        operacionesEquipo.eliminarEquipo(9);
        operacionesEquipo.eliminarEquipo(10);
        String equipos = operacionesEquipo.getEquipos();
        String partidos = operacionesPartido.getPartidos(1);
        System.out.println(equipos);
        System.out.println(partidos);
    }
}