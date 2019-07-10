package tbmodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class BasicTableModel extends AbstractTableModel
{
	protected String columns[];
	protected ArrayList<Object> dados; // dados no JTable
	
	public BasicTableModel(ArrayList<Object> dados) 
	{
        this.dados = dados;
    }
	
	public abstract Object getValueAt(int rowIndex, int colIndex);
	
	public int getColumnCount() 
	{
		return columns.length;
	}
	
	public int getRowCount() 
	{
		return dados.size();
	}
	
	public String getColumnName(int col)
	{
		return columns[col];
	}
	
	public List<Object> getDados() 
	{
		return dados;
	}

	public Class<?> getColumnClass(int col)
	{
		return getValueAt(0,col).getClass();
	}
	
    public Object getValue(int rowIndex)
    {
        return dados.get(rowIndex);
    }
    
    public int indexOf(Object obj)
    {
        return dados.indexOf(obj);
    }

    public void onAdd(Object obj)
    {
        dados.add(obj);
        fireTableRowsInserted(indexOf(obj), indexOf(obj));
    }
 
    public void onAddAll(List<Object> dadosIn) 
    {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }

    public void onRemove(int rowIndex) 
    {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    public void onRemove(Object obj) 
    {
        int indexBefore = indexOf(obj);
        dados.remove(obj);  
        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    public void onRemoveAll() 
    {
        dados.clear();
        fireTableDataChanged();
    }
}
