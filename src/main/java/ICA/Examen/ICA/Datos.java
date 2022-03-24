package ICA.Examen.ICA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Datos") 
public class Datos {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   int id;
   @Column (name="Numerodecontrol")
   int Numerodecontrol;
   @Column (name="Genero")
   String Genero;
   @Column (name="Medidadelacintura")
   double Medidadelacintura;
   @Column (name="Medidadelaaltura")
   double Medidadelaaltura;
public Datos() {}
public Datos(int numerodecontrol, String genero, double medidadelacintura, double medidadelaaltura) {
	Numerodecontrol = numerodecontrol;
	Genero = genero;
	Medidadelacintura = medidadelacintura;
	Medidadelaaltura = medidadelaaltura;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNumerodecontrol() {
	return Numerodecontrol;
}
public void setNumerodecontrol(int numerodecontrol) {
	Numerodecontrol = numerodecontrol;
}
public String getGenero() {
	return Genero;
}
public void setGenero(String genero) {
	Genero = genero;
}
public double getMedidadelacintura() {
	return Medidadelacintura;
}
public void setMedidadelacintura(double medidadelacintura) {
	Medidadelacintura = medidadelacintura;
}
public double getMedidadelaaltura() {
	return Medidadelaaltura;
}
public void setMedidadelaaltura(double medidadelaaltura) {
	Medidadelaaltura = medidadelaaltura;
}
public String toString() {
	return this.getId()+this.getNumerodecontrol()+this.getGenero()+this.getMedidadelaaltura()+this.getMedidadelacintura();
}
}
