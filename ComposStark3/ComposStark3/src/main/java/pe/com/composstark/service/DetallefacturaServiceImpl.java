package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.composstark.entity.Detallefactura;
import pe.com.composstark.repository.DetallefacturaRepository;

@Service
public class DetallefacturaServiceImpl implements DetallefacturaService {

    @Autowired
    private DetallefacturaRepository repositorio;

    @Override
    public List<Detallefactura> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Detallefactura> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Detallefactura> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Detallefactura add(Detallefactura d) {
        return repositorio.save(d);
    }

    @Override
    public Detallefactura update(Detallefactura d) {
        Detallefactura objdetallefactura = repositorio.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objdetallefactura);
        return repositorio.save(objdetallefactura);
    }

    @Override
    public Detallefactura delete(Detallefactura d) {
        Detallefactura objdetallefactura = repositorio.getById(d.getCodigo());
        objdetallefactura.setEstado(false);
        return repositorio.save(objdetallefactura);
    }

}