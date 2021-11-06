import java.io.Serializable;

public class Dia implements Serializable{
	
	String  nombre;
	int HRinicio, duracion;
	String salon;
	
	public Dia() {
		HRinicio = 0;
		duracion = 0;
		nombre = "";
		salon = "";
	}
	public Dia( String dia, int hora, int dur, String sal) {
		HRinicio = hora;
		duracion = dur;
		nombre = dia;
		salon = sal;
	}
}
