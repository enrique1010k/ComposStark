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
import pe.com.composstark.entity.Detallefactura;
import pe.com.composstark.service.DetallefacturaService;

@RestController
@RequestMapping("/detallefactura")
public class DetallefacturaRestController {

    @Autowired
    private DetallefacturaService servicio;

    @GetMapping
    public List<Detallefactura> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Detallefactura> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Detallefactura> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Detallefactura add(@RequestBody Detallefactura d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public Detallefactura update(@PathVariable long id, @RequestBody Detallefactura d) {
        d.setCodigo(id);
        return servicio.update(d);
    }

    @DeleteMapping("/{id}")
    public Detallefactura delete(@PathVariable long id) {
        Detallefactura objdetallefactura = new Detallefactura();
        objdetallefactura.setEstado(false);
        return servicio.delete(Detallefactura.builder().codigo(id).build());
    }
}
