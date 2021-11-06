import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;

public class SeleccionarMaterias extends JFrame implements ActionListener, KeyListener{
	Principal principal;
	ButtonGroup primer, segundo, tercero, cuarto, quinto,sexto,sep;
	JRadioButton materia1,materia2,materia3,materia4,materia5,materia6,materia7,materia8,materia9,materia10,materia11,materia12,materia13,materia14,materia15,materia16,materia17;
	JButton continuar;
	ArrayList <Materia> ListaM;
	ArrayList <String> lista2;
	public SeleccionarMaterias( Principal principal ) {
		primer=new ButtonGroup();
		segundo=new ButtonGroup();
		tercero=new ButtonGroup();
		cuarto=new ButtonGroup();
		quinto=new ButtonGroup();
		sexto=new ButtonGroup();
		sep=new ButtonGroup();
		
		this.principal = principal;
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(450,300,300,380);
		setTitle("Selecciona Materias");
		materia1 = new JRadioButton("M. de la Programación");
		materia1.setBounds( 15, 10, 250, 20);
		materia1.addActionListener(this);
		materia1.setActionCommand("materia1");
		add(materia1);
		primer.add(materia1);
		materia2 = new JRadioButton("Programación I", false);
		materia2.setBounds( 15, 30, 250, 20);
		materia2.addActionListener(this);
		materia2.setActionCommand("materia2");
		add(materia2);
		primer.add(materia2);
		materia3 = new JRadioButton("Álgebra Superior", false);
		materia3.setBounds( 15, 50, 250, 20);
		materia3.addActionListener(this);
		materia3.setActionCommand("materia3");
		add(materia3);
		segundo.add(materia3);
		materia4 = new JRadioButton("Ensamblador", false);
		materia4.setBounds( 15, 70, 250, 20);
		materia4.addActionListener(this);
		materia4.setActionCommand("materia4");
		add(materia4);
		tercero.add(materia4);
		
		
		materia5 = new JRadioButton("Cálculo Diferencial", false);
		materia5.setBounds( 15, 90, 250, 20);
		materia5.addActionListener(this);
		materia5.setActionCommand("materia5");
		add(materia5);
		segundo.add(materia5);
		
		materia6 = new JRadioButton("Cálculo Integral", false);
		materia6.setBounds( 15, 110, 250, 20);
		materia6.addActionListener(this);
		materia6.setActionCommand("materia6");
		add(materia6);
		segundo.add(materia6);
		
		materia7 = new JRadioButton("Programación II", false);
		materia7.setBounds( 15, 130, 250, 20);
		materia7.addActionListener(this);
		materia7.setActionCommand("materia7");
		add(materia7);
		primer.add(materia7);
		materia8 = new JRadioButton("Estructura de Datos", false);
		materia8.setBounds( 15, 150, 250, 20);
		materia8.addActionListener(this);
		materia8.setActionCommand("materia8");
		add(materia8);
		primer.add(materia8);
		
		materia9 = new JRadioButton("Probabilidad y Estadística", false);
		materia9.setBounds( 15, 170, 250, 20);
		materia9.addActionListener(this);
		materia9.setActionCommand("materia9");
		add(materia9);
		segundo.add(materia9);
		
		materia10 = new JRadioButton("Sistemas Operativos I", false);
		materia10.setBounds( 15, 190, 250, 20);
		materia10.addActionListener(this);
		materia10.setActionCommand("materia10");
		add(materia10);
		primer.add(materia10);
		
		materia11 = new JRadioButton("Graficación", false);
		materia11.setBounds( 15, 210, 250, 20);
		materia11.addActionListener(this);
		materia11.setActionCommand("materia11");
		add(materia11);
		
		primer.add(materia11);
		sep.add(materia11);
		
		materia12 = new JRadioButton("Física I", false);
		materia12.setBounds( 15, 230, 250, 20);
		materia12.addActionListener(this);
		materia12.setActionCommand("materia12");
		add(materia12);
		quinto.add(materia12);
		
		materia13 = new JRadioButton("Algebra Lineal", false);
		materia13.setBounds( 15, 250, 250, 20);
		materia13.addActionListener(this);
		materia13.setActionCommand("materia13");
		add(materia13);
		sexto.add(materia13);
		sep.add(materia13);
		
		materia14 = new JRadioButton("Física II", false);
		materia14.setBounds( 15, 270, 250, 20);
		materia14.addActionListener(this);
		materia14.setActionCommand("materia14");
		add(materia14);
		quinto.add(materia14);
		
		materia15 = new JRadioButton("Matemáticas Discretas", false);
		materia15.setBounds( 15, 290, 250, 20);
		materia15.addActionListener(this);
		materia15.setActionCommand("materia15");
		add(materia15);
		sexto.add(materia15);
		continuar = new JButton( "Continuar" );
		continuar.setActionCommand( "continuar" );
		continuar.setBounds( 100,320,100,20);
		continuar.addActionListener( this );
		continuar.addKeyListener( this );
		continuar.setBackground( Color.WHITE );
		add( continuar );
		
		ListaM= new ArrayList <Materia>();
		lista2= new ArrayList <String>();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		Materia m;
		String comando=e.getActionCommand();
		switch(comando) {
		case "continuar":
			if(materia1.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("METODOLOGIA DE LA PROGRAMACION") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia2.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROGRAMACION I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia3.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ALGEBRA SUPERIOR") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia4.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ENSAMBLADOR") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia5.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("CALCULO DIFERENCIAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia6.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("CALCULO INTEGRAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia7.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROGRAMACION II") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia8.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ESTRUCTURA DE DATOS") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia9.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROBABILIDAD Y ESTADISTICA") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia10.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("SISTEMAS OPERATIVOS I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia11.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("GRAFICACION") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia12.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("FISICA I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia13.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ALGEBRA LINEAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia14.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("FISICA II") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia15.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("MATEMATICAS DISCRETAS") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			principal.mat.matl.ActualizarLista( lista2 );
			principal.mat.matl.mater.lista = ListaM;
			int opc = JOptionPane.showConfirmDialog(principal, "¿Desea Continuar?", "Confirmar Salida",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0) {
				new SeleccionarHorario( principal, ListaM, lista2 );
				dispose();
			}
			else {
				principal.CargarDatos();
				principal.mat.matl.materias.setListData( principal.mat.matl.mater.listamaterias.toArray() );
			}
		break;
		}
	}

	public void keyPressed(KeyEvent e) {
		Materia m;
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_ENTER ) {
			if(materia1.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("METODOLOGIA DE LA PROGRAMACION") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia2.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROGRAMACION I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia3.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ALGEBRA SUPERIOR") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia4.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ENSAMBLADOR") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia5.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("CALCULO DIFERENCIAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia6.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("CALCULO INTEGRAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia7.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROGRAMACION II") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia8.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ESTRUCTURA DE DATOS") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia9.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("PROBABILIDAD Y ESTADISTICA") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia10.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("SISTEMAS OPERATIVOS I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia11.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("GRAFICACION") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia12.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("FISICA I") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia13.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("ALGEBRA LINEAL") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			if(materia14.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("FISICA II") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}if(materia15.isSelected()) {
				for(int i=0;i<principal.mat.matl.mater.lista.size();i++) {
					m= principal.mat.matl.mater.lista.get(i);
					if(m.nombre.equals("MATEMATICAS DISCRETAS") ){
						ListaM.add(m);
						lista2.add( m.nombre+ " / "+m.profesor+ " / "+String.valueOf( m.NRC ) );
					}
				}
			}
			principal.mat.matl.ActualizarLista( lista2 );
			principal.mat.matl.mater.lista = ListaM;
			int opc = JOptionPane.showConfirmDialog(principal, "¿Desea Continuar?", "Confirmar Salida",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (opc == 0) {
				new SeleccionarHorario( principal, ListaM, lista2 );
				dispose();
			}
			else {
				principal.CargarDatos();
				principal.mat.matl.materias.setListData( principal.mat.matl.mater.listamaterias.toArray() );
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}

