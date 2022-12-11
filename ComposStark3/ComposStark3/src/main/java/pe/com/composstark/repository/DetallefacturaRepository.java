package pe.com.composstark.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.composstark.entity.Detallefactura;

public interface DetallefacturaRepository extends JpaRepository<Detallefactura, Long> {

    @Query("select d from Detallefactura d where d.estado = '1'")
    List<Detallefactura> findAllCustom();
}
