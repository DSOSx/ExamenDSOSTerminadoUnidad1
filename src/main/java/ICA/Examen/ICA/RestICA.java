package ICA.Examen.ICA;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestICA {
	@Autowired
    ServicioICA sica = new ServicioICA();
    
    @GetMapping("/")
    public String IniciarServicio() {
    	return "Servidor Iniciado";
    }
    
    @PostMapping("/CalcularICA")
    public Datos CalcularICA(@RequestBody Datos datos) {
    	return sica.CalcularICAR(datos);
    }
    
    @GetMapping("/CalcularICA/{Numerodecontrol}")
    public Map<String, String> VerICA(@PathVariable("Numerodecontrol") int Numerodecontrol) {
 	   return sica.ObtenerICA(Numerodecontrol);
    }
    

}
