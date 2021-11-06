import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;

public class SeleccionarHorario extends JFrame implements ActionListener, KeyListener {

	Principal principal;
	JRadioButton tipo1, tipo2, tipo3;
	JButton continuar;
	ButtonGroup grupo;
	ArrayList<Materia> materias;
	ArrayList<Materia> ListaM;
	ArrayList<String> lista2;

	Materia m = null, m1;
	int x, y = 0;

	public SeleccionarHorario(Principal principal, ArrayList<Materia> list, ArrayList<String> list2) {
		materias = new ArrayList<Materia>();
		ListaM = list;
		lista2 = list2;
		this.principal = principal;
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(450, 300, 300, 150);
		setTitle("Selecciona Tipo de Horario");
		grupo = new ButtonGroup();
		tipo1 = new JRadioButton("Buenos Profes");
		tipo1.setBounds(15, 10, 250, 20);
		tipo1.addActionListener(this);
		tipo1.setActionCommand("tipo1");
		add(tipo1);
		grupo.add(tipo1);
		tipo2 = new JRadioButton("Horario tarde");
		tipo2.setBounds(15, 30, 250, 20);
		tipo2.addActionListener(this);
		tipo2.setActionCommand("tipo2");
		add(tipo2);
		grupo.add(tipo2);
		tipo3 = new JRadioButton("Horario temprano");
		tipo3.setBounds(15, 50, 250, 20);
		tipo3.addActionListener(this);
		tipo3.setActionCommand("tipo3");
		add(tipo3);
		grupo.add(tipo3);
		continuar = new JButton("Continuar");
		continuar.setActionCommand("continuar");
		continuar.setBounds(100, 80, 100, 20);
		continuar.addActionListener(this);
		continuar.addKeyListener( this );
		continuar.setBackground(Color.WHITE);
		add(continuar);
	}

	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		switch (c) {
		case "continuar":
			int opc = JOptionPane.showConfirmDialog(principal, "¿Generar Horario?", "Confirmar",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0) {
				
				if (tipo1.isSelected()) {
					LlenarMaterias(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = calificacionAlta( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				}
				if (tipo2.isSelected()) {
					LlenarMaterias2(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = horaTarde( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				
					
		
				}
				if (tipo3.isSelected()) {
					LlenarMaterias3(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = horaTem( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					 principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				}
				principal.hr.materias = materias;
				dispose();
				principal.mat.Activar();
			}
			break;
			
		}
	}
	
	

	public void LlenarMaterias(ArrayList<Materia> Lista) {
		materias = new ArrayList<Materia>();
		String s = "";
		int i;
		lista2 = new ArrayList<String>();
		for (i = 0; i < Lista.size(); i++) {
			m1 = Lista.get(i);
			if (!s.equals( m1.nombre ) ) {
				m = calificacionAlta( m1.nombre, Lista );
				materias.add( m );
				lista2.add(m.nombre + " / " + m.profesor + " / " + String.valueOf(m.NRC));
				s = m.nombre;
			}
		}
		for(i=0;i<materias.size();i++) {
			m1=materias.get(i);
			ListaM.remove(m1);
		}
		principal.mat.matl.mater.lista = materias;
		principal.mat.matl.ActualizarLista(lista2);
	}

	public void LlenarMaterias2(ArrayList<Materia> Lista) {
		materias = new ArrayList<Materia>();
		String s = "";
		int i;
		lista2 = new ArrayList<String>();
		for (i = 0; i < Lista.size(); i++) {
			m1 = Lista.get(i);
			if (!s.equals( m1.nombre ) ) {
				m = horaTarde( m1.nombre, Lista );
				materias.add( m );
				lista2.add(m.nombre + " / " + m.profesor + " / " + String.valueOf(m.NRC));
				s = m.nombre;
			}
		}
		for(i=0;i<materias.size();i++) {
			m1=materias.get(i);
			ListaM.remove(m1);
		}
		principal.mat.matl.mater.lista = materias;
		principal.mat.matl.ActualizarLista(lista2);
	}
	public void LlenarMaterias3(ArrayList<Materia> Lista) {
		materias = new ArrayList<Materia>();
		String s = "";
		int i;
		lista2 = new ArrayList<String>();
		for (i = 0; i < Lista.size(); i++) {
			m1 = Lista.get(i);
			if (!s.equals( m1.nombre ) ) {
				m = horaTem( m1.nombre, Lista );
				materias.add( m );
				lista2.add(m.nombre + " / " + m.profesor + " / " + String.valueOf(m.NRC));
				s = m.nombre;
			}
		}
		for(i=0;i<materias.size();i++) {
			m1=materias.get(i);
			ListaM.remove(m1);
		}
		principal.mat.matl.mater.lista = materias;
		principal.mat.matl.ActualizarLista(lista2);
	}
	

	public Materia calificacionAlta(String nmat, ArrayList<Materia> mat) {
		Materia m = new Materia();
		double max = -1;
		int i, index = 0;
		for (i = 0; i < mat.size(); i++) {
			m = mat.get(i);
			if (m.cal > max && m.nombre.equals(nmat)) {
				max = m.cal;
				index = i;
			}
		}
		m = mat.get(index);
		return m;
	}
	public Materia horaTarde(String nmat, ArrayList<Materia> mat) {
		Materia m = new Materia();
		Dia d=new Dia();
		double max = 0;
		int i, index = 0;
		for (i = 0; i < mat.size(); i++) {
			m = mat.get(i);
			d=m.dias.get(0);
			if (max<d.HRinicio&&m.nombre.equals(nmat)) {
				max = d.HRinicio;
				index = i;
			}
		}
		m = mat.get(index);
		return m;
	}
	public Materia horaTem(String nmat, ArrayList<Materia> mat) {
		Materia m = new Materia();
		Dia d=new Dia();
		double max = 20;
		int i, index = 0;
		for (i = 0; i < mat.size(); i++) {
			m = mat.get(i);
			d=m.dias.get(0);
			if (max>d.HRinicio&&m.nombre.equals(nmat)) {
				max = d.HRinicio;
				index = i;
			}
		}
		m = mat.get(index);
		return m;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_ENTER ) {
			int opc = JOptionPane.showConfirmDialog(principal, "¿Generar Horario?", "Confirmar",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0) {
				
				if (tipo1.isSelected()) {
					LlenarMaterias(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = calificacionAlta( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				}
				if (tipo2.isSelected()) {
					LlenarMaterias2(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = horaTarde( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				
					
		
				}
				if (tipo3.isSelected()) {
					LlenarMaterias3(ListaM);
					Dia d = null;
					for(int i=0;i<materias.size();i++) {
						m=materias.get(i);
						for(int j=0;j<m.dias.size();j++) {
							d=m.dias.get(j);
							switch (d.nombre) {
							case "lunes":
								y = 1;
								break;
							case "martes":
								y = 2;
								break;
							case "miercoles":
								y = 3;
								break;
							case "jueves":
								y = 4;
								break;
							case "viernes":
								y = 5;
								break;
	
							case "sabado":
								y = 6;
								break;
							}
							x = d.HRinicio - 7;
							String cell = (String)principal.hr.modelo.getValueAt(x, y);
							if( !cell.equals("") ) {
								m1 = horaTem( m.nombre, ListaM );
								materias.add( m1 );
								System.out.println("Un error tratado");
								break;
							}
							else {
									switch(d.duracion) {
									case 2:
										principal.hr.modelo.setValueAt(m.nombre, x+1, y);
									case 1:
										principal.hr.modelo.setValueAt(m.nombre, x, y);
									}
								}
							}
					}
					lista2.clear();
					for( int k = 0; k< materias.size(); k ++ ) {
						m1 = materias.get( k );
						lista2.add( m1.nombre + " / "+m1.profesor+" / "+m1.NRC );
					}
					 principal.mat.matl.mater.lista = materias;
					principal.mat.matl.ActualizarLista(lista2);
				}
				principal.hr.materias = materias;
				dispose();
				principal.mat.Activar();
			}
		}
	}

	
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	public void keyTyped(KeyEvent arg0) {
	}	
}