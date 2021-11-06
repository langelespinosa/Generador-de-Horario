import javax.swing.table.DefaultTableModel;
public class Modelo extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column )	{
		
	
		return false;
	}

}
