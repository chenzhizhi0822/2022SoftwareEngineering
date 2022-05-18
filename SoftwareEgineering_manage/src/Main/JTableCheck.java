package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *  使用复选框作为编辑器来编辑表格中的单元格
 * 
 * @author Kunyuan
 * 获取表中数值方法：
 * System.out.println(t.getValueAt(rowNum, colNum));
 */
public class JTableCheck extends JPanel{

	public JTableCheck(){
		this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	    
        CheckTable1 mt = new CheckTable1();
        
        JTable t = new JTable(mt);
        JCheckBox jc1 = new JCheckBox();
        t.getColumnModel().getColumn(4)
                .setCellEditor(new DefaultCellEditor(jc1));
        
        
        
        t.setPreferredScrollableViewportSize(new Dimension(550, 40));
        JScrollPane s = new JScrollPane(t);
        s.setPreferredSize(new Dimension(935,590));
        this.add(s, BorderLayout.CENTER);
        
	}

    public static void main(String[] args) {
        JFrame f = new JFrame();
        CheckTable1 mt = new CheckTable1();
        
        JTable t = new JTable(mt);
        JCheckBox jc1 = new JCheckBox();
        t.getColumnModel().getColumn(4)
                .setCellEditor(new DefaultCellEditor(jc1));
        
        
        t.setPreferredScrollableViewportSize(new Dimension(700, 60));
        JScrollPane s = new JScrollPane(t);
        f.getContentPane().add(s, BorderLayout.CENTER);
        f.setTitle("JCHECKtableDEMO");
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}


class CheckTable1 extends AbstractTableModel {

    Object[][] p = {
            { new Integer(0), "鱼香肉丝", "炒菜", new Integer(60), false },
            { new Integer(1), "可乐", "饮品", new Integer(10), true }, 
            { new Integer(2), "小笼包", "热菜", new Integer(30), true },};

    String[] n = { "序号", "菜名", "种类", "价格", "选择" };

    @Override
    public int getRowCount() {
        return p.length;
    }

    @Override
    public int getColumnCount() {
        return n.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return p[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return n[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        p[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}