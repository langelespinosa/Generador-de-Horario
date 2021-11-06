import javax.swing.border.CompoundBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelDatosMateria extends JPanel implements ActionListener {

	JComboBox<String> dias;
	JTextField nombre, NRC, clave, salon, seccion, profesor, calif, horainit, duracion;
	JButton admin, addmat, rmvmat, modif;
	Principal principal;
	Materia materia;

	public PanelDatosMateria(Principal principal) {
		this.principal = principal;
		setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Información De la Materia")));
		setBounds(315, 0, 670, 170);
		setVisible(true);
		setLayout(null);

		JLabel nom = new JLabel("Nombre:");
		nom.setBounds(20, 30, 100, 20);
		add(nom);
		nombre = new JTextField();
		nombre.setBounds(110, 30, 230, 20);
		nombre.setEditable(false);
		add(nombre);

		JLabel nr = new JLabel("NRC:");
		nr.setBounds(355, 30, 50, 20);
		add(nr);
		NRC = new JTextField();
		NRC.setBounds(415, 30, 100, 20);
		NRC.setEditable(false);
		add(NRC);

		JLabel num = new JLabel("Clave:");
		num.setBounds(20, 80, 100, 20);
		add(num);
		clave = new JTextField();
		clave.setBounds(110, 80, 100, 20);
		clave.setEditable(false);
		add(clave);

		JLabel prof = new JLabel("Profesor");
		prof.setBounds(20, 55, 100, 20);
		add(prof);
		profesor = new JTextField();
		profesor.setBounds(110, 55, 230, 20);
		profesor.setEditable(false);
		add(profesor);

		JLabel sec = new JLabel("Seccion");
		sec.setBounds(355, 55, 100, 20);
		add(sec);
		seccion = new JTextField();
		seccion.setBounds(415, 55, 100, 20);
		seccion.setEditable(false);
		add(seccion);

		JLabel cali = new JLabel("Calificacion");
		cali.setBounds(235, 80, 100, 20);
		add(cali);
		calif = new JTextField();
		calif.setBounds(315, 80, 100, 20);
		calif.setEditable(false);
		add(calif);

		JLabel C1 = new JLabel("Seleccionar días");
		C1.setBounds(20, 105, 150, 20);
		add(C1);

		dias = new JComboBox<String>();
		dias.setBounds(30, 130, 100, 20);
		dias.addActionListener(this);
		dias.setActionCommand("dias");
		add(dias);

		JLabel j = new JLabel("Hora de inicio");
		j.setBounds(170, 130, 100, 20);
		add(j);
		horainit = new JTextField();
		horainit.setBounds(260, 130, 80, 20);
		horainit.setEditable(false);
		add(horainit);

		JLabel j1 = new JLabel("Duración de la clase");
		j1.setBounds(370, 130, 150, 20);
		add(j1);
		duracion = new JTextField();
		duracion.setBounds(500, 130, 70, 20);
		duracion.setEditable(false);
		add(duracion);

		admin = new JButton("Acceder");
		admin.setBounds(575, 15, 85, 20);
		admin.setActionCommand("admin");
		admin.addActionListener(this);
		add(admin);
	}

	public void MostrarDatos(Materia m) {
		materia = m;
		this.nombre.setText(m.nombre);
		this.profesor.setText(m.profesor);
		this.clave.setText(m.clave);
		this.seccion.setText(String.valueOf(m.seccion));
		this.NRC.setText(String.valueOf(m.NRC));
		this.calif.setText(String.valueOf(m.cal));
		this.Llenar(m.dias);
		if (m.dias.size() != 0) {
			Dia d = materia.dias.get(0);
			this.horainit.setText(String.valueOf(d.HRinicio) + ":00");
			this.duracion.setText(String.valueOf(d.duracion) + " h");
		}
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {

		case "dias":
			int index = dias.getSelectedIndex();
			if (index == -1)
				index = 0;
			if (materia.dias.size() != 0) {
				Dia d = materia.dias.get(index);
				this.horainit.setText(String.valueOf(d.HRinicio) + ":00");
				this.duracion.setText(String.valueOf(d.duracion) + " h");
			}
			break;
		case "addmat":
			new AgregarMateria(principal);
			break;
		case "admin":
			new InicioSesion(principal);
			break;
		case "salir":
			int opc = JOptionPane.showConfirmDialog(principal, "¿Desea Cerrar Sesión?", "Confirmar Salida",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0) {
				int opc1 = JOptionPane.showConfirmDialog(principal, "¿Actualizar Base de Datos?", "Guardar Cambios",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc1 == 0) {
					principal.GuardarLista();
				}
				admin.setText("Acceder");
				admin.setActionCommand("admin");
				this.remove(addmat);
				this.remove(rmvmat);
				this.remove(modif);
				this.repaint();
				JOptionPane.showMessageDialog(principal, "Sesión Cerrada", "Salir", JOptionPane.INFORMATION_MESSAGE);
			}

			break;
		case "rmvmat":
			Materia m;
			int n = principal.mat.matl.materias.getSelectedIndex();
			if (n == -1) {
				JOptionPane.showMessageDialog(principal, "Seleccione la Materia", "Error al eliminar",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				m = principal.mat.matl.mater.lista.get( n );
				opc = JOptionPane.showConfirmDialog(principal, "¿Desea Eliminar la materia?\n-"+m.nombre+"\n-NRC: "+m.NRC, "Confirmar Eliminación",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opc == 0) {
					principal.mat.matl.mater.lista.remove(n);
					principal.mat.matl.mater.listamaterias.remove(n);
					principal.mat.matl.ActualizarLista(principal.mat.matl.mater.listamaterias);
				}
			}

			break;
		case "modif":
			n = principal.mat.matl.materias.getSelectedIndex();
			if (n == -1) {
				JOptionPane.showMessageDialog(principal, "Seleccione la Materia", "Error al actualizar",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				m = principal.mat.matl.mater.lista.get(n);
				new AgregarMateria(principal, m, n);
				principal.mat.matl.ActualizarLista(principal.mat.matl.mater.listamaterias);
			}

			break;

		}

	}

	public void Iniciar() {
		addmat = new JButton("");
		addmat.setBounds(570, 40, 40, 40);
		addmat.setActionCommand("addmat");
		addmat.addActionListener(this);
		addmat.setFocusPainted(false);
		addmat.setBackground(Color.WHITE);
		addmat.setIcon(new ImageIcon("./img/addmat.png"));
		add(addmat);
		rmvmat = new JButton("Eliminar Materia");
		rmvmat.setBounds(613, 40, 40, 40);
		rmvmat.setActionCommand("rmvmat");
		rmvmat.addActionListener(this);
		rmvmat.setFocusPainted(false);
		rmvmat.setBackground(Color.WHITE);
		rmvmat.setIcon(new ImageIcon("./img/delete.png"));
		add(rmvmat);
		modif = new JButton("Modificar Materia");
		modif.setBounds(520, 100, 140, 20);
		modif.setActionCommand("modif");
		modif.addActionListener(this);
		add(modif);
		this.repaint();
		admin.setText("Salir");
		admin.setActionCommand("salir");
	}

	public void Llenar(ArrayList<Dia> lista) {
		String s = "";
		dias.removeAllItems();
		Dia d;
		for (int i = 0; i < lista.size(); i++) {
			d = lista.get(i);
			dias.addItem(d.nombre);
			System.out.println("Dia " + d.nombre + "\tInicio" + d.HRinicio);
			dias.addActionListener(this);
			add(dias);
		}
	}
}
