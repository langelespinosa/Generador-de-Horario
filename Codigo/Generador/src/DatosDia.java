import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class DatosDia extends JFrame implements ActionListener{
	
	JComboBox <String> horas;
	AgregarMateria materia;
	JButton mas,menos,save;
	JTextField duracion, salon;
	String diaN;
	Dia dia;
	int num;
	
	public DatosDia( String dia, AgregarMateria materia ) {
		this.materia = materia;
		this.diaN = dia;
		num = 1;
		setLayout( null );
		setVisible( true );
		setResizable( false );
		setTitle("Horas de Clase día "+ dia);
		setBounds( 500,300, 300, 150 );
		JLabel j = new JLabel("Selecione la hora de inicio");
		j.setBounds( 5,10,200,20);
		add( j );
		horas = new JComboBox < String >();
		horas.setBounds( 205, 10, 60,20 );
		Llenar();
		JLabel j1 = new JLabel("Duración de la clase");
		j1.setBounds( 5,35,150,20 );
		add( j1 );
		duracion = new JTextField();
		duracion.setText(String.valueOf( num ) );
		duracion.setBounds( 205, 35, 20,20);
		duracion.setEditable( false );
		add( duracion );
		mas = new JButton();
		mas.setBounds(225, 35, 20, 20);
		mas.addActionListener( this );
		mas.setActionCommand( "mas" );
		mas.setFocusPainted( false );
		mas.setBackground(Color.WHITE);
		mas.setIcon(new ImageIcon("./img/add.png"));
		add( mas );
		menos = new JButton();
		menos.setBounds(245, 35, 20, 20);
		menos.addActionListener( this );
		menos.setActionCommand( "menos" );
		menos.setFocusPainted( false );
		menos.setBackground(Color.WHITE);
		menos.setIcon(new ImageIcon("./img/menos.png"));
		add( menos );
		JLabel j2 = new JLabel("Salón");
		j2.setBounds( 10,60,80,20 );
		add( j2 );
		salon = new JTextField();
		salon.setText(String.valueOf( num ) );
		salon.setBounds( 90, 60, 80,20);
		add( salon );
		save = new JButton("Guardar");
		save.setBounds(100, 85, 80, 20);
		save.addActionListener( this );
		save.setActionCommand( "guardar" );
		save.setFocusPainted( false );
		save.setBackground(Color.WHITE);
		//save.setIcon(new ImageIcon("./save.png"));
		add( save );
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch( comando) {
			case "mas":
				if( num < 4 )
					num ++;
				else
					JOptionPane.showMessageDialog( this, "La duración máxima de una clase es 4 horas", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE );
				duracion.setText(String.valueOf( num ) );
				
			break;
			case "menos":
				if( num > 1 )
					num --;
				else
					JOptionPane.showMessageDialog( this, "La duración mínima de una clase es 1 hora", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE );
				duracion.setText(String.valueOf( num ) );
			break;
			case "guardar":
				dia = new Dia();
				dia.nombre = diaN;
				dia.HRinicio = horas.getSelectedIndex()+7;
				dia.duracion = Integer.parseInt( duracion.getText() );
				dia.salon =  salon.getText();
				materia.lista.add(dia);
				dispose();
			break;
		}
		
	}
	
	public void Llenar() {
		String s = "";
		horas.removeAllItems();
		for( int i = 0; i<13; i++ ) {
			s = String.valueOf( i +7 )+":00";
			horas.addItem( s );
			horas.addActionListener( this );
			add( horas );
		}
	}
	
}
