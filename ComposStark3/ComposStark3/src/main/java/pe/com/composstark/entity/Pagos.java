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
@Entity(name = "Pagos")
@Table(name = "T_Pagos")

public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idpag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "sumppag")
    private double sumaprecios;

    @Column(name = "igvpag")
    private double igv;
    
    @Column(name = "totppag")
    private double totalapagar;
    
    @Column(name = "estpag")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idfac", nullable = false)
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name = "idpro", nullable = false)
    private Producto producto; 
}