package Main;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * 这是一个示例类
 */
public class ManageView extends JPanel
{
	// Model : 负责数据
	DefaultTableModel tableModel = new DefaultTableModel();

	// View : 负责显示， 创建JTable的时候指定一个Model
	JTable table = new JTable(tableModel);

	public ManageView()
	{
		// 添加到主界面
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true); // 整行选择
		
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);

		// 初始化设置：添加5列
		tableModel.addColumn("food");
		tableModel.addColumn("text");
		tableModel.addColumn("category");
		tableModel.addColumn("date");
		tableModel.addColumn("type");

		// 添加数据行
		addTableRow();
	}

	private void addTableRow()
	{
		// java.util.Vector 是个范型 ，表示数组
		Vector<Object> rowData = new Vector<>();
		rowData.add("food1");
		rowData.add("syl");
		rowData.add("little cute");
		rowData.add("today");
		rowData.add("111");
		tableModel.addRow(rowData); // 添加一行

		// Object[] rowData = new Object[5];
		// rowData[0] = item.id;
		// rowData[1] = item.name;
		// rowData[2] = item.sex;
		// rowData[3] = item.birthday;
		// rowData[4] = item.cellphone;
		// tableModel.addRow( rowData );
	}
}
