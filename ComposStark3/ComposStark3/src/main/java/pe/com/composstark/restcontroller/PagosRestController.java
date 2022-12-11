package pe.com.composstark.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.composstark.entity.Pagos;
import pe.com.composstark.service.PagosService;

@RestController
@RequestMapping("/pagos")
public class PagosRestController {

    @Autowired
    private PagosService servicio;

    @GetMapping
    public List<Pagos> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Pagos> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Pagos> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Pagos add(@RequestBody Pagos p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public Pagos update(@PathVariable long id, @RequestBody Pagos p) {
        p.setCodigo(id);
        return servicio.update(p);
    }

    @DeleteMapping("/{id}")
    public Pagos delete(@PathVariable long id) {
        Pagos objpagos = new Pagos();
        objpagos.setEstado(false);
        return servicio.delete(Pagos.builder().codigo(id).build());
    }
}
