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
import pe.com.composstark.entity.Factura;
import pe.com.composstark.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaRestController {

    @Autowired
    private FacturaService servicio;

    @GetMapping
    public List<Factura> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Factura> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Factura> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Factura add(@RequestBody Factura f) {
        return servicio.add(f);
    }

    @PutMapping("/{id}")
    public Factura update(@PathVariable long id, @RequestBody Factura f) {
        f.setCodigo(id);
        return servicio.update(f);
    }

    @DeleteMapping("/{id}")
    public Factura delete(@PathVariable long id) {
        Factura objfactura = new Factura();
        objfactura.setEstado(false);
        return servicio.delete(Factura.builder().codigo(id).build());
    }
}
