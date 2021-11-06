import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListaMaterias extends JPanel implements ListSelectionListener {
	
		JList materias;	
		JScrollPane scroll;
		Materias mater;
	    Principal principal;
	    public ListaMaterias( Principal principal) {
	    	this.principal = principal;
	    	String []mat= {""};
	        materias= new JList(mat);
	    	mater=new Materias();
	    	setLayout(null);
	        setVisible( true );
	        setBounds( 10,50, 280, 600 );
	        materias.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
	        materias.addListSelectionListener( this );
	        scroll = new JScrollPane( materias );
	        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
	        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
	        scroll.setBounds( 0,0, 280, 600 );
	        add( scroll );
	        
	    }

		public void valueChanged(ListSelectionEvent e) {
			if(materias.getSelectedValue()!=null) {
				  int n = materias.getSelectedIndex();
		            Materia p = mater.lista.get( n );
		            principal.Ex.MostrarDatos( p );
		}
}
		
		public void ActualizarLista( ArrayList < String > lista ) {
			//principal.mat.matl.materias.setListData( this.mater.listamaterias.toArray());
			principal.mat.matl.materias.setListData(lista.toArray());
			
		}
		
}