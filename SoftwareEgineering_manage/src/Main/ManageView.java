package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
import javax.swing.table.TableModel;

import jxl.write.WritableSheet;

/* 第1张卡片
 * 
 */
public class ManageView extends JPanel //implements TableModelListener
{
	// Model : 负责数据
	DefaultTableModel tableModel = new DefaultTableModel();

	// View : 负责显示， 创建JTable的时候指定一个Model
	JTable table = new JTable(tableModel){
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	public MyFrame mainpanel;

	public ManageView(MyFrame mainpanel)
	{
		this.mainpanel = mainpanel;


		this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		// 添加到主界面
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true); // 整行选择
		//对表属性进行设置
		table.isCellEditable(0,0);//列表不能修改
		table.setSelectionForeground(Color.DARK_GRAY);
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setGridColor(Color.GRAY);
		table.setRowHeight(50);
		table.setAutoCreateRowSorter(true);//排序？
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选

		JLabel titleJLabel = new JLabel("Flight Timetable ", JLabel.CENTER);//Let the JLabel be in the center.
		Font fntLabel = new Font("Arial", Font.BOLD, 38);
		titleJLabel.setFont(fntLabel);//Set the font in the JLabel.
		titleJLabel.setPreferredSize(new Dimension(989, 100));
		
		this.setLayout(new BorderLayout());
		this.add(titleJLabel, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		// 初始化设置：添加5列
		tableModel.addColumn("taskID");
		tableModel.addColumn("Flight number");
		tableModel.addColumn("Flight state");
		tableModel.addColumn("Take off time");
		tableModel.addColumn("Boarding port");
		tableModel.addColumn("Source");;
		tableModel.addColumn("Destination");


		Font fntTable = new Font("Arial", Font.BOLD, 18);
		table.setFont(fntTable);

		// 添加数据行
		addTableRow();

		//-----------------------------------以下为事件部分--------------------------------------------------

        // table.addMouseListener(new MouseAdapter(){    //鼠标事件
        //     public void mouseClicked(MouseEvent e){
        //         int selectedRow = table.getSelectedRow(); //获得选中行索引

        //     }
        // });
		final JPanel bottompanel = new JPanel();
        this.add(bottompanel,BorderLayout.SOUTH);
        final RButton addButton = new RButton("Add new");   //添加按钮
        addButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
				//ifchooseflight = true;
				mainpanel.selectView(2);
            }
        });
        bottompanel.add(addButton);  

        // final RButton updateButton = new RButton("Revise");   //修改按钮
        // updateButton.addActionListener(new ActionListener(){//添加事件
        //     public void actionPerformed(ActionEvent e){
        //         int selectedRow = table.getSelectedRow();//获得选中行的索引
		// 		Vector<Object> rowDataSelected = new Vector<>();
		// 		for (int i=0; i<5; i++){
		// 			rowDataSelected.add(table.getValueAt(selectedRow, i));
		// 		}
        //         if(selectedRow!= -1)   //是否存在选中行
        //         {
        //             //修改指定的行：
		// 			JPanel revise = new ManageRevise_Flight(rowDataSelected.elementAt(0), rowDataSelected.elementAt(1),rowDataSelected.elementAt(2)
		// 			,rowDataSelected.elementAt(3),rowDataSelected.elementAt(4));
					
		// 			mainpanel.selectView(2);
        //         }
		// 		else{
		// 			JOptionPane.showMessageDialog(null, "Please choose one flight you want to revise", null, JOptionPane.WARNING_MESSAGE);
		// 		}
        //     }
        // });
        // bottompanel.add(updateButton);

        final RButton delButton = new RButton("delete");
        delButton.addActionListener(new ActionListener(){//事件
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
					tableModel.removeRow(selectedRow);  //删除行
					Sheet sheet = new Sheet("sheet/flight.xls");
					sheet.removeRow(selectedRow+1);
					JOptionPane.showMessageDialog(null, "You have successfully delete a flight", null, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bottompanel.add(delButton);

	}
	


	private void addTableRow()
	{
		for (int i=1; i<Sheet.getRowNum("sheet/flight.xls"); i++){
			Vector<Object> rowData = new Vector<>();
			for (int j=0; j<Sheet.getColNum("sheet/flight.xls")-1; j++){
				try {
					rowData.add(Sheet.getCell("sheet/flight.xls",i,j));
				} catch (Exception e) {
					e.printStackTrace();
				};
			}
			tableModel.addRow(rowData);
		}
	}
}
