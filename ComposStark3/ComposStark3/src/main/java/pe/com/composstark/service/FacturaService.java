package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Factura;

public interface FacturaService {

    // MOSTRAR TODA LA LISTA
    public List<Factura> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Factura> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Factura> findById(long id);

    // REGISTRAR
    public Factura add(Factura f);

    // ACTUALIZAR
    public Factura update(Factura f);

    // BORRAR
    public Factura delete(Factura f);
}