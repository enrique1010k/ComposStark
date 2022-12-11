package pe.com.composstark.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.composstark.entity.Pagos;

public interface PagosRepository extends JpaRepository<Pagos, Long> {
    @Query("select p from Pagos p where p.estado = '1'")
    List<Pagos> findAllCustom();
}