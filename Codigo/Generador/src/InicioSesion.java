import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class InicioSesion extends JFrame implements ActionListener, KeyListener {

	JTextField user;
	JPasswordField password;
	JButton Inicio, Salir;
	JLabel US, PSW;
	Principal principal;

	public InicioSesion(Principal principal) {
		this.principal = principal;
		setLayout(null);
		setVisible(true);
		setBounds(400, 200, 250, 170);
		setTitle("Inicio de Sesión");

		US = new JLabel("Usuario");
		US.setBounds(40, 20, 70, 20);
		add(US);
		user = new JTextField();
		user.setBounds(115, 20, 70, 20);
		add(user);
		PSW = new JLabel("Contraseña");
		PSW.setBounds(40, 50, 70, 20);
		add(PSW);
		password = new JPasswordField();
		password.setBounds(115, 50, 70, 20);
		password.setEchoChar('*');
		add(password);
		Inicio = new JButton("Entrar");
		Inicio.setActionCommand("entrar");
		Inicio.setBounds(60, 80, 70, 20);
		Inicio.addActionListener(this);
		Inicio.addKeyListener(this);
		add(Inicio);
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "entrar":
			String us = user.getText();
			String ps = password.getText();
			if (ValidaDatos(us, ps)) {
				if (us.equals("user")) {
					if (ps.equals("123")) {
						String s1 = " Iniciaste como administrador \n   Usuario:  " + us;
						JOptionPane.showMessageDialog(this, s1, "Inicio Exitoso", JOptionPane.INFORMATION_MESSAGE);
						principal.Ex.Iniciar();
						dispose();
					} else
						JOptionPane.showMessageDialog(this, "Contraseñas incorrecta", "Error",
								JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(this, "Usuario: " + us + " no existe", "Error",
							JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Datos Obligatorios", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
			}
			break;
		}

	}

	public boolean ValidaDatos(String us, String ps) {
		if (!us.equals("") && !ps.equals(""))
			return true;
		else
			return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER ) {
			String us = user.getText();
			String ps = password.getText();
			if (ValidaDatos(us, ps)) {
				if (us.equals("user")) {
					if (ps.equals("123")) {
						String s1 = " Iniciaste como administrador \n   Usuario:  " + us;
						JOptionPane.showMessageDialog(this, s1, "Inicio Exitoso", JOptionPane.INFORMATION_MESSAGE);
						principal.Ex.Iniciar();
						dispose();
					} else
						JOptionPane.showMessageDialog(this, "Contraseñas incorrecta", "Error",
								JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(this, "Usuario: " + us + " no existe", "Error",
							JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Datos Obligatorios", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
