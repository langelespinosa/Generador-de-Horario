import java.io.*;
import java.util.*;
public class Materia implements Serializable {
	
	int NRC, seccion;
	String profesor;
	double cal;
	String nombre, clave;
	ArrayList <Dia> dias;
	public Materia() {
		NRC=0;
		seccion=0;
		nombre="";
		clave="";
		dias= new ArrayList < Dia >();
		profesor="";
	}
	public Materia(int NR, int sec, String name, String key, String prof, ArrayList < Dia >dias, double calf ) {
		NRC=NR;
		seccion=sec;
		nombre=name;
		clave=key;
		this.dias = dias;
		profesor=prof;
		cal=calf;
	}
}
