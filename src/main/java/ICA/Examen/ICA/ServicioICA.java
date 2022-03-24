package ICA.Examen.ICA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioICA {
	@Autowired
    RepositorioICA rica;
	
    public Datos CalcularICAR(Datos datos) {
      return rica.save(datos);	
    }
    
    public Map<String, String> ObtenerICA(int Numerodecontrol){
 	   List<Datos> c = new ArrayList<Datos>();
 	   HashMap<String, String> map = new HashMap<>();
 	   rica.findAll().forEach(c::add);
 	   for(int i=0;i<c.size();i=i+1) {
 		   if((c.get(i).getNumerodecontrol())==(Numerodecontrol)) {
 			   double ICA =((c.get(i).getMedidadelacintura())/(c.get(i).getMedidadelaaltura()));
 			   String Resultado="";
 			   if(ICA<0.34) {
 				   Resultado = "Delgadez severa";
 			   } 
 			  if(ICA>0.35&&ICA<0.42) {
 				   Resultado = "Delgadez leve";
 			   } 
 			 if(ICA>0.42&&ICA<0.53) {
				   Resultado = "Peso normal";
			   } 
 			if(ICA>0.53&&ICA<0.57) {
				   Resultado = "Sobrepeso";
			   } 
 			if(ICA>0.58&&ICA<0.62) {
				   Resultado = "Sobrepeso elevado";
			   } 
 			if(ICA>0.63) {
				   Resultado = "Obesidad mórbida";
			   } 
 			   map.put("ICA:",Double.toString(ICA));
 			   map.put("Nivel",(String)(Resultado));
 			   return map;
 		   }
 	   }
 	   return map;
    }
    
}
