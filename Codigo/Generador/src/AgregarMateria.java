
//Objetivo: Leer la información del Materia y Guardarlo en el archivo

import java.util.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.*;

public class AgregarMateria extends JFrame implements ActionListener {
	Principal principal;
	JTextField nombre, NRC, clave, salon, seccion, profesor, calif;
	JRadioButton lunes, martes, miercoles, jueves, viernes, sabado;
	JButton Guardar;
	ArrayList<Dia> lista;
	int index;

	public AgregarMateria(Principal principal) {
		this.principal = principal;
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Agregar Materia");
		this.setBounds(700, 200, 500, 350);

		lista = new ArrayList<Dia>();

		JLabel nom = new JLabel("Nombre:");
		nom.setBounds(10, 10, 100, 20);
		add(nom);
		nombre = new JTextField();
		nombre.setBounds(100, 10, 100, 20);
		add(nombre);

		JLabel nr = new JLabel("NRC:");
		nr.setBounds(10, 35, 100, 20);
		add(nr);
		NRC = new JTextField();
		NRC.setBounds(100, 35, 100, 20);
		add(NRC);

		JLabel num = new JLabel("Clave:");
		num.setBounds(10, 60, 100, 20);
		add(num);
		clave = new JTextField();
		clave.setBounds(100, 60, 100, 20);
		add(clave);

		JLabel prof = new JLabel("Profesor");
		prof.setBounds(205, 10, 100, 20);
		add(prof);
		profesor = new JTextField();
		profesor.setBounds(305, 10, 120, 20);
		add(profesor);

		JLabel sec = new JLabel("Seccion");
		sec.setBounds(205, 35, 100, 20);
		add(sec);
		seccion = new JTextField();
		seccion.setBounds(305, 35, 100, 20);
		add(seccion);

		JLabel cali = new JLabel("Calificacion");
		cali.setBounds(205, 60, 100, 20);
		add(cali);
		calif = new JTextField();
		calif.setBounds(305, 60, 100, 20);
		add(calif);

		JLabel C1 = new JLabel("Seleccionar días");
		C1.setBounds(10, 85, 150, 20);
		add(C1);

		lunes = new JRadioButton("Lunes", false);
		lunes.setBounds(5, 110, 100, 20);
		lunes.addActionListener(this);
		lunes.setActionCommand("lunes");
		add(lunes);

		martes = new JRadioButton("Martes", false);
		martes.setBounds(5, 130, 100, 20);
		martes.addActionListener(this);
		martes.setActionCommand("martes");
		add(martes);

		miercoles = new JRadioButton("Miercoles", false);
		miercoles.setBounds(5, 150, 100, 20);
		miercoles.addActionListener(this);
		miercoles.setActionCommand("miercoles");
		add(miercoles);

		jueves = new JRadioButton("Jueves", false);
		jueves.setBounds(5, 170, 100, 20);
		jueves.addActionListener(this);
		jueves.setActionCommand("jueves");
		add(jueves);

		viernes = new JRadioButton("Viernes", false);
		viernes.setBounds(5, 190, 100, 20);
		viernes.addActionListener(this);
		viernes.setActionCommand("viernes");
		add(viernes);

		sabado = new JRadioButton("Sábado", false);
		sabado.setBounds(5, 210, 100, 20);
		sabado.addActionListener(this);
		sabado.setActionCommand("sabado");
		add(sabado);

		Guardar = new JButton("Guardar");
		Guardar.setBounds(120, 240, 100, 30);
		Guardar.addActionListener(this);
		Guardar.setActionCommand("save");
		add(Guardar);

	}

	public AgregarMateria(Principal principal, Materia m, int nu) {
		this.principal = principal;
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Agregar Materia");
		this.setBounds(700, 200, 500, 350);
		index = nu;
		lista = new ArrayList<Dia>();

		JLabel nom = new JLabel("Nombre:");
		nom.setBounds(10, 10, 100, 20);
		add(nom);
		nombre = new JTextField();
		nombre.setBounds(100, 10, 100, 20);
		nombre.setText(m.nombre);
		add(nombre);

		JLabel nr = new JLabel("NRC:");
		nr.setBounds(10, 35, 100, 20);
		add(nr);
		NRC = new JTextField();
		NRC.setText(String.valueOf(m.NRC));
		NRC.setBounds(100, 35, 100, 20);
		add(NRC);

		JLabel num = new JLabel("Clave:");
		num.setBounds(10, 60, 100, 20);
		add(num);
		clave = new JTextField();
		clave.setBounds(100, 60, 100, 20);
		clave.setText(m.clave);
		add(clave);

		JLabel prof = new JLabel("Profesor");
		prof.setBounds(205, 10, 100, 20);
		add(prof);
		profesor = new JTextField();
		profesor.setText(m.profesor);
		profesor.setBounds(305, 10, 120, 20);
		add(profesor);

		JLabel sec = new JLabel("Seccion");
		sec.setBounds(205, 35, 100, 20);
		add(sec);
		seccion = new JTextField();
		seccion.setText(String.valueOf(m.seccion));
		seccion.setBounds(305, 35, 100, 20);

		add(seccion);

		JLabel cali = new JLabel("Calificacion");
		cali.setBounds(205, 60, 100, 20);
		add(cali);
		calif = new JTextField();
		calif.setBounds(305, 60, 100, 20);
		calif.setText(String.valueOf(m.cal));
		add(calif);

		JLabel C1 = new JLabel("Seleccionar días");
		C1.setBounds(10, 85, 150, 20);
		add(C1);

		lunes = new JRadioButton("Lunes", false);
		lunes.setBounds(5, 110, 100, 20);
		lunes.addActionListener(this);
		lunes.setActionCommand("lunes");
		add(lunes);

		martes = new JRadioButton("Martes", false);
		martes.setBounds(5, 130, 100, 20);
		martes.addActionListener(this);
		martes.setActionCommand("martes");
		add(martes);

		miercoles = new JRadioButton("Miercoles", false);
		miercoles.setBounds(5, 150, 100, 20);
		miercoles.addActionListener(this);
		miercoles.setActionCommand("miercoles");
		add(miercoles);

		jueves = new JRadioButton("Jueves", false);
		jueves.setBounds(5, 170, 100, 20);
		jueves.addActionListener(this);
		jueves.setActionCommand("jueves");
		add(jueves);

		viernes = new JRadioButton("Viernes", false);
		viernes.setBounds(5, 190, 100, 20);
		viernes.addActionListener(this);
		viernes.setActionCommand("viernes");
		add(viernes);

		sabado = new JRadioButton("Sábado", false);
		sabado.setBounds(5, 210, 100, 20);
		sabado.addActionListener(this);
		sabado.setActionCommand("sabado");
		add(sabado);

		Guardar = new JButton("Actualizar");
		Guardar.setBounds(120, 240, 100, 30);
		Guardar.addActionListener(this);
		Guardar.setActionCommand("modif");
		add(Guardar);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			String comando = e.getActionCommand();
			switch (comando) {
			case "save":
				int opc = JOptionPane.showConfirmDialog(principal, "¿Guardar Materia?", "Confirmar datos",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc == 0) {
					String Na = nombre.getText();
					int nrc = Integer.parseInt(NRC.getText());
					int secc = Integer.parseInt(seccion.getText());
					double calf = Double.parseDouble(calif.getText());
					String clav = clave.getText();
					String pr = profesor.getText();
					if (ValidaDatos(Na, clav)) {
						System.out.println(lista.size());
						Materia mat1 = new Materia(nrc, secc, Na, clav, pr, lista, calf);
						principal.mat.matl.mater.listamaterias.add(mat1.nombre + "/ NRC: " + mat1.NRC + "/ "
								+ mat1.profesor + "/ " + "/ clave" + mat1.clave);
						principal.mat.matl.mater.lista.add(mat1);
						Materia m = principal.mat.matl.mater.lista.get(principal.mat.matl.mater.lista.size() - 1);
						principal.mat.matl.materias.setListData(principal.mat.matl.mater.listamaterias.toArray());
						Dia d = m.dias.get(0);
						System.out.println("\nDía: " + d.nombre);
						System.out.println(" " + d.HRinicio);
						System.out.println(" " + d.duracion);
						JOptionPane.showMessageDialog(null, "   Materia Agregada", "Guardado",
								JOptionPane.INFORMATION_MESSAGE);

						dispose();
					} else
						JOptionPane.showMessageDialog(null, "¡Campos vacíos!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "lunes":
				if (lunes.isSelected())
					new DatosDia("lunes", this);
				break;
			case "martes":
				if (martes.isSelected())
					new DatosDia("martes", this);
				break;
			case "miercoles":
				if (miercoles.isSelected())
					new DatosDia("miercoles", this);
				break;
			case "jueves":
				if (jueves.isSelected())
					new DatosDia("jueves", this);
				break;
			case "viernes":
				if (viernes.isSelected())
					new DatosDia("viernes", this);
				break;
			case "sabado":
				if (sabado.isSelected())
					new DatosDia("sabado", this);
				break;
			case "modif":
				opc = JOptionPane.showConfirmDialog(principal, "¿Actualizar Datos de Materia?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc == 0) {
					Materia m = principal.mat.matl.mater.lista.get(index);
					m.dias = lista;
					principal.mat.matl.mater.lista.set(index, m);
					JOptionPane.showMessageDialog(null, "   Materia Actualizada", "Guardado",
							JOptionPane.INFORMATION_MESSAGE);
					Dia d = m.dias.get(0);
					System.out.println("\nDía: " + d.nombre);
					System.out.println(" " + d.HRinicio);
					System.out.println(" " + d.duracion);
					dispose();
					break;
				}
			}

		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean ValidaDatos(String N, String A) {
		if (!N.equals("") && !A.equals(""))
			return true;
		else
			return false;
	}

}