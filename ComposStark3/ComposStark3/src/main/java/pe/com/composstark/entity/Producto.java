package pe.com.composstark.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Producto")
@Table(name = "T_Producto")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idpro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nompro")
    private String nombre;

    @Column(name = "prepro")
    private double precio;

    @Column(name = "estpro")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idcat", nullable = false)
    private Categoria categoria;
}
