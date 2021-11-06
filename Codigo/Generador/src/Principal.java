import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal extends JFrame {
	PanelMaterias mat;
	PanelHorario hr;
	PanelDatosMateria Ex;
	public Principal() {
		setBounds(0,0,1000,750);
		setLayout(null);
		setTitle("Generador de Horario");
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		mat = new PanelMaterias(this);
		hr=new PanelHorario( this );
		Ex = new PanelDatosMateria( this );
		CargarDatos();
		mat.matl.materias.setListData( mat.matl.mater.listamaterias.toArray( )) ;
		add(mat);
		add(hr);
		add(Ex);
		
	}
	public static void main(String[] args) {
		Principal p=new Principal();
		p.setVisible(true);
	}
	 public void GuardarLista( ){
			try{
				ObjectOutputStream 	escritura = new ObjectOutputStream( new FileOutputStream( new File("./data/Materias.dat") ) );
					escritura.writeObject( mat.matl.mater );
				JOptionPane.showMessageDialog( this, "Base de Datos Actualizada", "Guardar", JOptionPane.INFORMATION_MESSAGE );
				escritura.close();
		    }catch ( IOException e) {
		    	JOptionPane.showMessageDialog( this, "Error al guardar datos", "ERROR", JOptionPane.ERROR_MESSAGE );
		    }
	    }
	
	    
	    public void CargarDatos(){
			try{
		    	ObjectInputStream lectura = new ObjectInputStream( new FileInputStream( new File("./data/Materias.dat") ) );
		    	mat.matl.mater = ( Materias ) lectura.readObject ( );
				lectura.close();
			}
			catch ( IOException e ) {
				System.out.println ( "Error al cargar base de datos");
			}
			catch ( ClassNotFoundException e) {
				System.out.println ( "Error al cargar base de datos(Clase)");
			}
		}
}
