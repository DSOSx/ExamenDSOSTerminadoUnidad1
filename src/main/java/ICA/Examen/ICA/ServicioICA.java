package ICA.Examen.ICA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioICA {
	@Autowired
    RepositorioICA rica;
	
    public Datos CalcularICAR(Datos datos) {
      return rica.save(datos);	
    }
    
    public String ObtenerICA(int Numerodecontrol){
 	   List<Datos> c = new ArrayList<Datos>();
 	   rica.findAll().forEach(c::add);
 	   for(int i=0;i<c.size();i=i+1) {
 		   if((c.get(i).getNumerodecontrol())==(Numerodecontrol)) {
 			   double ICA =((c.get(i).getMedidadelacintura())/(c.get(i).getMedidadelaaltura()));
 			   String Resultado="";
 			   if(ICA<0.34) {
 				   Resultado = "ica:"+ICA+",Nivel: Delgadez severa";
 			   } 
 			  if(ICA>0.35&&ICA<0.42) {
 				   Resultado = "ica:"+ICA+",Nivel: Delgadez leve";
 			   } 
 			 if(ICA>0.42&&ICA<0.53) {
				   Resultado = "ica:"+ICA+",Nivel: Peso normal";
			   } 
 			if(ICA>0.53&&ICA<0.57) {
				   Resultado = "ica:"+ICA+",Nivel: Sobrepeso";
			   } 
 			if(ICA>0.58&&ICA<0.62) {
				   Resultado = "ica:"+ICA+",Nivel: Sobrepeso elevado";
			   } 
 			if(ICA>0.63) {
				   Resultado = "ica:"+ICA+",Nivel: Obesidad mórbida";
			   } 
 			   return Resultado;
 		   }
 	   }
 	   return "No existe ese numero de control";
    }
    
}
