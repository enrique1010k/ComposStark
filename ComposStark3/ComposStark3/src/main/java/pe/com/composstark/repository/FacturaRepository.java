package pe.com.composstark.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.composstark.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("select f from Factura f where f.estado = '1'")
    List<Factura> findAllCustom();
}