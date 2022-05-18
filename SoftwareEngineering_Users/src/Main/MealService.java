package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.*;




public class MealService extends JPanel{
	
	// Model : 负责数据
	DefaultTableModel tableModel = new DefaultTableModel();

	// View : 负责显示， 创建JTable的时候指定一个Model
	JTable table = new JTable(tableModel);
	
	public MealService() {
		this.setLayout(null);
        this.setBounds(198,82,989,582);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        RButton1 back = new RButton1("Back");
        back.setBounds(600, 500, 100, 50);
		RButton1 cart_bill = new RButton1("Cart & Bill");
		cart_bill.setBounds(750, 500, 180, 50);
        
        JPanel cardArea =new JPanel();
        cardArea.setBounds(3, 3, 930, 482);
        
        JPanel panel1 = new JPanel();
        RPanel1 panel1_1 = new RPanel1(600,400);//选项模块
        JLabel step = new JLabel("Step3: Meal Service");
        JLabel menu = new JLabel("Main Menu");
        
        panel1.setPreferredSize(new Dimension(930, 482));
        panel1.setLayout(null);
        panel1_1.setLayout(null);
      
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 400, 50);
        menu.setFont(new Font("Times New Roman",Font.BOLD,33));
        menu.setBounds(215,20,400,50);
        
        //按钮设置
        panel1_1.setBounds(200, 70,600,400);
        
        panel1.add(step);
        panel1_1.add(menu);
        panel1.add(panel1_1);
        
        this.add(cardArea);
        this.add(back);
        this.add(cart_bill);
        
        JPanel[] panelList = new JPanel[1];
		
		panelList[0]=panel1;
		
		initContainer(cardArea,panelList);
		
		selectView(0,cardArea);
		
		// 添加到主界面
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 70, 580, 300);
		table.setRowSelectionAllowed(true); // 整行选择
		panel1_1.add(scrollPane);
		
		this.setLayout(new BorderLayout());
		//this.add(scrollPane, BorderLayout.CENTER);

		// 初始化设置：添加5列
		tableModel.addColumn("ID");
		tableModel.addColumn("Name"); 
		tableModel.addColumn("Price");
		tableModel.addColumn("Extra Pay");
		tableModel.addColumn("Pic");
		tableModel.addColumn("State");
		
		JCheckBox[] jcb = new JCheckBox[10];
		for(int i=0;i<10;i++) {
			jcb[i]=new JCheckBox();
		}
		// 添加数据行
		addTableRow(jcb);
	}
	private void initContainer(JPanel container,JPanel[] panelList)
	{		
		// 设置为卡片布局
		CardLayout cardLayout = new CardLayout();
		container.setLayout(cardLayout);		
		container.setOpaque(true);
		container.setBackground(new Color(0xF4F4F4));
		container.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, new Color(0xCCCCCC)));

		// 添加多个卡片
		int index = 0;
		for(JPanel i : panelList) {
			container.add(i, "view"+index);
			index++;
		}
		// 默认显示第一张卡片	
		selectView(0,container);		
	}
	// 切换卡片 
	public void selectView (int index, JPanel container)
	{
		String name = "view" + index; // 卡片的名称 view0, view1, ...
		
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, name); // 根据名字来显示相应的卡片
		
	}
	private void addTableRow(JCheckBox[] jcb)
	{
		
		for(int i=1;i<10;i++) {
			String ID = Sheet.getCell("../sheet/food.xls",i,0);
			String Name = Sheet.getCell("../sheet/food.xls",i,1);
			String Price = Sheet.getCell("../sheet/food.xls",i,2);
			Icon Pic = Sheet.getIcon("..\\sheet\\food.xls",i,3);  // get icon pic and correct the row and col
			String Extra_Pay = Sheet.getCell("../sheet/food.xls",i,4);
			// java.util.Vector 是个范型 ，表示数组
			Vector<Object> rowData = new Vector<>();
			rowData.add(ID);
			rowData.add(Name);
			rowData.add(Price);
			rowData.add(Extra_Pay);
			rowData.add(new JLabel(Pic));// add JLabel to row data
			rowData.add(jcb[i]);
			
			table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer(){
				@Override
				public Component getTableCellRendererComponent(JTable table,

				Object value, boolean isSelected, boolean hasFocus,

				int row, int column) {
					return (JLabel)value;// paint the component with the JLabel just load in
				}});
			
			table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer(){
				@Override
				public Component getTableCellRendererComponent(JTable table,

				Object value, boolean isSelected, boolean hasFocus,

				int row, int column) {
				// 创建用于返回的渲染组件

				JCheckBox statebox = (JCheckBox)value;

				// 使具有焦点的行对应的复选框选中

				statebox.setSelected(isSelected);

				//statebox.setSelected(hasFocus);

				// 使复选框在单元格内居中显示

				statebox.setHorizontalAlignment((int) 0.5f);

				return statebox;

				}});


			tableModel.addRow(rowData); // 添加一行
		}

		// Object[] rowData = new Object[5];
		// rowData[0] = item.id;
		// rowData[1] = item.name;
		// rowData[2] = item.sex;
		// rowData[3] = item.birthday;
		// rowData[4] = item.cellphone;
		// tableModel.addRow( rowData );
	}

}
