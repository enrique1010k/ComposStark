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
@Entity(name = "Detallefactura")
@Table(name = "T_Detallefactura")

public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "iddet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "candet")
    private double cantidad;

    @Column(name = "pretdet")
    private double preciototal;

    @Column(name = "estdet")
    private boolean estado;
        
    @ManyToOne
    @JoinColumn(name = "idpro", nullable = false)
    private Producto producto;
    
}