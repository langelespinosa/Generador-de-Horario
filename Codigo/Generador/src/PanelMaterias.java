import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;

public class PanelMaterias extends JPanel implements ActionListener {
	ListaMaterias matl;
	JButton seleccionar, imprimir;
	Principal principal;

	public PanelMaterias(Principal principal) {
		this.principal = principal;
		setLayout(null);
		setVisible(true);
		setBounds(10, 0, 300, 710);
		setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Materias")));
		matl = new ListaMaterias(principal);
		add(matl);
		seleccionar = new JButton("Generar Horario");
		seleccionar.addActionListener(this);
		seleccionar.setToolTipText("Generar Horario");
		seleccionar.setActionCommand("seleccionar");
		seleccionar.setBounds(50, 670, 200, 30);
		seleccionar.setFocusPainted(false);
		add(seleccionar);
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "seleccionar":
			new SeleccionarMaterias(principal);
			seleccionar.setEnabled(false);
			break;
		case "print":
			JScrollPane p = principal.hr.scroll ;
	        JTable t = principal.hr.tabla; 
	        
			JFrame f = new JFrame("Horario");
			f.setTitle("Horario Generado");
			f.setBounds(200,100, 800, 600);
	        f.setContentPane(p);
	        f.pack();

	        JTableHeader h = t.getTableHeader();
	        Dimension dH = h.getSize();
	        Dimension dT = t.getSize();
	        int x = (int)dH.getWidth();
	        int y = (int)dH.getHeight() + (int)dT.getHeight();

	        p.setDoubleBuffered(false);

	        BufferedImage bi = new BufferedImage(
	            (int)x,
	            (int)y,
	            BufferedImage.TYPE_INT_RGB
	            );

	        Graphics g = bi.createGraphics();
	        h.paint(g);
	        g.translate(0,h.getHeight());
	        t.paint(g);
	        g.dispose();
	        String name = JOptionPane.showInputDialog(null,"Ingresa tu Nombre", "Alumno", JOptionPane.INFORMATION_MESSAGE );
	        JOptionPane.showMessageDialog(principal, new JLabel(new ImageIcon(bi)),"Horario Generado", JOptionPane.INFORMATION_MESSAGE);
	        name = name.toUpperCase();
	        principal.hr.GuardarHorario(name);
	        try {
				ImageIO.write(bi,"png",new File("./horarios/Horario Alumno "+name+".png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        principal.remove( principal.hr );
	        principal.hr = new PanelHorario( principal );
	        principal.add( principal.hr );
			break;
		case "resset":
			remove(seleccionar);
			principal.CargarDatos();
			principal.mat.matl.materias.setListData(matl.mater.listamaterias.toArray());
			seleccionar = new JButton("Generar Horario");
			seleccionar.addActionListener(this);
			seleccionar.setToolTipText("Generar Horario");
			seleccionar.setActionCommand("seleccionar");
			seleccionar.setBounds(50, 670, 200, 30);
			seleccionar.setFocusPainted(false);
			add(seleccionar);
			remove(imprimir);
			principal.hr.Vaciar();
			repaint();
		}
	}

	public void Activar() {
		seleccionar.setToolTipText("reiniciar");
		seleccionar.setBounds(80, 650, 40, 40);
		seleccionar.setActionCommand("resset");
		seleccionar.setBackground(Color.WHITE);
		seleccionar.addActionListener(principal.mat);
		seleccionar.setEnabled(true);
		seleccionar.setIcon(new ImageIcon("./img/refresh.png"));
		imprimir = new JButton();
		imprimir.setToolTipText("Imprimir Horario");
		imprimir.addActionListener(principal.mat);
		imprimir.setBounds(130, 650, 40, 40);
		imprimir.setActionCommand("print");
		imprimir.setBackground(Color.WHITE);
		imprimir.setIcon(new ImageIcon("./img/print.png"));
		add(imprimir);
	}

}
