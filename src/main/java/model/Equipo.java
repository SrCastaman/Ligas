package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor


@Entity
@Table (name = "equipos")
public class Equipo implements Serializable {

    @Column
    @Id
    private int id_equipo;
    @Column
    private String nombre_equipo;
    @Column
    private String ciudad;
    @Column
    private int id_liga;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "equipos_partidos",
                joinColumns = @JoinColumn(name = "id_equipo"),
                inverseJoinColumns = @JoinColumn(name = "id_partido"))
    private List<Partido> partidos;

    public Equipo(String nombre_equipo, String ciudad,int id_liga) {
        this.nombre_equipo = nombre_equipo;
        this.ciudad = ciudad;
        this.id_liga = id_liga;
    }
}

