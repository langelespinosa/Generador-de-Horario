import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;



public class PanelHorario extends JPanel implements MouseListener {
	
	ArrayList < Materia >materias;
	Object[][] datos;
	JTable tabla;
	DefaultTableModel modelo;
	JScrollPane scroll;
	Principal principal;

	public PanelHorario(Principal principal) {
		this.principal = principal;
		setVisible(true);
		setLayout(new BorderLayout());
		setBounds(315, 170, 650, 500);
		setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Horario")));
		Iniciar();
	}
	public void GuardarHorario( String Nombre ) {
		
		FileWriter fichero = null;		
        PrintWriter inicio = null;
        try{
            fichero = new FileWriter("./horarios/Horario Alumno "+Nombre+".txt");
            inicio = new PrintWriter(fichero);

            inicio.println("\t\tBenemérita Universidad Autónoma de Puebla");
            inicio.println("");
            inicio.println("\tHorario de Clases");
            inicio.println("-Nombre del Alumno: "+Nombre);
            Materia m;
            Dia d;
            inicio.println("\nMaterias ");
            for( int i = 0; i< materias.size(); i++ ) {
            	m = materias.get( i );
            	inicio.println("");
	            inicio.println("\t"+m.nombre);
	            inicio.print("\t\t-NRC: "+m.NRC);
	            inicio.println("\t\t-Clave: "+m.clave);
	            inicio.print("\t\t-Sección: "+m.seccion);
	            inicio.println("\t\t-Profesor: "+m.profesor);
	            inicio.println("\tDías");
	            
	            for( int j = 0; j< m.dias.size(); j++ ) {
	            	d = m.dias.get( j);
		            inicio.println("\t  "+d.nombre);
		            inicio.println("\t\t-Hora de Inicio: "+d.HRinicio+":00");
		            inicio.println("\t\t-Duración: "+d.duracion+" hr");
		            inicio.println("\t\t-Salón: "+d.salon);
	            }
	            inicio.println("\t--------------------------------------------------------------");
            }

            inicio.println("\n\n");
            inicio.println("\n\n\t\t\t|||Generador de Horarios|||");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
}
	public void Vaciar() {
		for( int i = 0;i < tabla.getRowCount(); i++) {
			for( int j = 1; j < tabla.getColumnCount(); j++) {
				tabla.setValueAt( "", i, j);
			}
		}
	}

	public void Iniciar() {
		tabla = new JTable();
		modelo = new Modelo();
		tabla.setModel(modelo);
		tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 20));

		Object[] columnas = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
		modelo.setColumnIdentifiers(columnas);
		tabla.setRowHeight(33);
		modelo.addRow(new Object[] { "07:00-08:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "08:00-09:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "09:00-10:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "10:00-11:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "11:00-12:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "12:00-13:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "13:00-14:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "14:00-15:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "15:00-16:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "16:00-17:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "17:00-18:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "18:00-19:00", "", "", "", "", "", "" });
		modelo.addRow(new Object[] { "19:00-20:00", "", "", "", "", "", "" });

		tabla.getAutoscrolls();
		tabla.addMouseListener(this);
		scroll = new JScrollPane(tabla);
		add(scroll, BorderLayout.CENTER);
	}

	public void mouseClicked(MouseEvent arg0) {
		int x = tabla.getSelectedRow();
		int y = tabla.getSelectedColumn();
		String mat;
		if (x > 0 && y > 0) {
			mat = (String) tabla.getValueAt(x, y);
			if (!mat.equals("")) {
				mat = mat.toUpperCase();
				Materia m;

				for (int i = 0; i < principal.mat.matl.mater.lista.size(); i++) {
					m = principal.mat.matl.mater.lista.get(i);
					if (m.nombre.equals(mat)) {
						principal.Ex.MostrarDatos(m);
						System.out.println("\n " + m.nombre);
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
