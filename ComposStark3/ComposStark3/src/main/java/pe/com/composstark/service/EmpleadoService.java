package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Empleado;

public interface EmpleadoService {

    // MOSTRAR TODA LA LISTA
    public List<Empleado> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Empleado> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Empleado> findById(long id);

    // REGISTRAR
    public Empleado add(Empleado e);

    // ACTUALIZAR
    public Empleado update(Empleado e);

    // BORRAR
    public Empleado delete(Empleado e);
}
