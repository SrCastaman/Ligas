package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "partidos")
public class Partido {
    @Column
    @Id
    private int id_partido;
    @Column
    private String fecha_partido;
    @Column
    private int goles_equipo_local;
    @Column
    private int goles_equipo_visitante;
    @Column
    private int id_equipo_local;
    @Column
    private int id_equipo_visitante;
    @Column
    private int id_liga;
    @ManyToMany(mappedBy = "partidos")
    private List<Equipo> losEquipos;

    public Partido(String fecha_partido, int goles_equipo_local, int goles_equipo_visitante, int id_equipo_local, int id_equipo_visitante, int id_liga) {
        this.fecha_partido = fecha_partido;
        this.goles_equipo_local = goles_equipo_local;
        this.goles_equipo_visitante = goles_equipo_visitante;
        this.id_equipo_local = id_equipo_local;
        this.id_equipo_visitante = id_equipo_visitante;
        this.id_liga = id_liga;
    }
}
