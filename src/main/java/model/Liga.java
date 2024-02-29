package model;

//POJO -> serializabale, getter/setter, atributos private, constructor default

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "ligas")
public class Liga implements Serializable {
    @Column
    @Id
    private int id_liga;
    @Column
    private String nombre_liga;
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_liga")
    private List<Equipo> losEquipos;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_liga")
    private List<Partido> losPartidos;

    public Liga(String nombre_liga, String fecha_inicio, String fecha_fin) {
        this.nombre_liga = nombre_liga;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
