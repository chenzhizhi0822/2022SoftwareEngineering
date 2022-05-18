package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//添加监听
import java.util.Vector;

import javax.swing.*;



public class luggage extends JPanel
{
	

	public luggage()
	{

	        this.setBounds(198,82,989,582);
	        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        this.setLayout(new GridLayout(5, 1,20,10));
	      

	        // 第一行
	        JPanel panel_1=new JPanel();
	        JLabel label1=new JLabel("Please select the number of your luggage: ");
	        Font font = new Font("宋体", Font.PLAIN, 30);//创建字体实例
	        label1.setFont(font);//设置JLabel的字体
	        label1.setForeground(Color.blue);//设置文字的颜色
	        panel_1.add(label1); 
	        this.add(panel_1);

	         // 第二行
	         JPanel panel_2=new JPanel();
	         Font font2 = new Font("宋体", Font.PLAIN, 18);//创建1个字体实例
	         JLabel label2=new JLabel("Carry-on luggage:  ");
	         label2.setFont(font);//设置JLabel的字体
	         panel_2.add(label2);
	         JComboBox jComboBox1 = new JComboBox();
	         jComboBox1.addItem(null); //设置默认选项
	         jComboBox1.addItem("0");
	         jComboBox1.addItem("1");
	         jComboBox1.addItem("2");
	         panel_2.add(jComboBox1);
	         jComboBox1.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
	         this.add(panel_2);

	         // 第三行
	         JPanel panel_3=new JPanel();
	         JLabel label3=new JLabel("Check-in luggage:  ");
	         label3.setFont(font);//设置JLabel的字体
	         panel_3.add(label3);
	         JComboBox jComboBox2 = new JComboBox();
	         jComboBox2.addItem(null); //设置默认选项
	         jComboBox2.addItem("0");
	         jComboBox2.addItem("1");
	         jComboBox2.addItem("2");
	         panel_3.add(jComboBox2);
	         jComboBox2.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
	         this.add(panel_3);

	         //第四行
	         JPanel panel_4=new JPanel();
	         RButton button1=new RButton("tips");
	         button1.setFont(font);
	         Dimension preferredSize = new Dimension(100,50);
	         button1.setPreferredSize(preferredSize );
	         button1.addActionListener(new LoginOKAction());  
	         panel_4.add(button1);
	         this.add(panel_4);

	         //第五行
	         JPanel panel_5=new JPanel();
	         RButton button2=new RButton("Back");
	         RButton button3=new RButton("Next");
	         button2.setFont(font);
	         button3.setFont(font);
	         button2.setPreferredSize(preferredSize );
	         button3.setPreferredSize(preferredSize );
	         button2.setBounds(200,200,100,50);
	         panel_5.add(button2);
	         panel_5.add(button3);
	         this.add(panel_5);
	   
	         

	}
	class LoginOKAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        JOptionPane.showMessageDialog(null, "随便写一点提示"); 
		}
	}
}
