package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.composstark.entity.Empleado;
import pe.com.composstark.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repositorio;

    @Override
    public List<Empleado> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Empleado> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Empleado> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Empleado add(Empleado e) {
        return repositorio.save(e);
    }

    @Override
    public Empleado update(Empleado e) {
        Empleado objempleado = repositorio.getById(e.getCodigo());
        BeanUtils.copyProperties(e, objempleado);
        return repositorio.save(objempleado);
    }

    @Override
    public Empleado delete(Empleado e) {
        Empleado objempleado = repositorio.getById(e.getCodigo());
        objempleado.setEstado(false);
        return repositorio.save(objempleado);
    }

}
