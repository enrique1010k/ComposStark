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
@Entity(name = "Factura")
@Table(name = "T_Factura")

public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idfac")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "fecfac")
    private String fecha;
    
    @Column(name = "estfac")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idcli", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "idemp", nullable = false)
    private Empleado empleado;
}