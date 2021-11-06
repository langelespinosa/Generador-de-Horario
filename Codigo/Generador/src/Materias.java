import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;
public class Materias implements Serializable {
	ArrayList<Materia> lista;
	ArrayList<String> listamaterias;
	
	public Materias() {
		lista = new ArrayList < Materia >();
		listamaterias = new ArrayList < String >();
	}
	
	public int Busca( String palabra ){
		ArrayList < Materia >lista1 = new ArrayList < Materia >();
		ArrayList < String >listaMate = new ArrayList < String >();
		palabra =palabra.toUpperCase();
		String name;
		Materia p = new Materia();
		boolean band = false;
		int i;
		for( i = 0; i< lista.size(); i++ ){
			p = lista.get( i );
			name = p.nombre;
			name = name.toUpperCase();
			if( name.equals( palabra ) ){
				band = true;
				lista1.add( p );
			}
			
		}
		for( int j = 0; j< lista1.size(); j++ ) {
			p = lista1.get( j );
			listaMate.add( " " + p.nombre);
		}
		if( band == true ) {
			lista = lista1;
			listamaterias = listaMate;
			return i;
		}
		else
			return -1;
	}
	
	
	}
	