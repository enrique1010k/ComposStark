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
@Entity(name = "Cliente")
@Table(name = "T_Cliente")

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomcli")
    private String nombre;
    
    @Column(name = "apecli")
    private String apellido;

    @Column(name = "dnicli")
    private int dni;

    @Column(name = "dircli")
    private String direccion;
    
    @Column(name = "estcli")
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "iddis", nullable = false)
    private Distrito distrito;
}