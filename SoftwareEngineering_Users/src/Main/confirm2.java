package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//添加监听
import java.util.Vector;

import javax.swing.*;

public class confirm2 extends JPanel
{
	
	String booknum= "201920029";
	public confirm2()
	{
		this.setBounds(198,82,989,582);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        //this.setBackground(new Color(50,50,205));
	        this.setPreferredSize(new Dimension(989,600));
	        this.setLayout(null);//设置空布局

	        //增加子面板
	        JPanel panel1 = new JPanel();
	        JPanel panel2 = new JPanel();
	        JPanel panel3 = new JPanel();
	        JPanel panel4 = new JPanel();

	        //设置面板大小、颜色及布局
	        panel1.setBounds(60,150,540,360);
	        panel1.setBackground(new Color(96,62,151));
	        panel1.setLayout(null);//设置空布局
	        this.add(panel1);

	        //设置面板大小、颜色及布局
	        panel2.setBounds(610,150,330,360);
	        panel2.setBackground(new Color(96,62,151));
	        panel2.setLayout(null);//设置空布局
	        this.add(panel2);

	        //设置面板大小、颜色及布局
	        panel3.setBounds(0,50,600,280);
	        panel3.setBackground(new Color(255,255,255));
	        panel3.setLayout(null);//设置空布局
	        panel1.add(panel3);

	        //设置面板大小、颜色及布局
	        panel4.setBounds(0,50,350,280);
	        panel4.setBackground(new Color(255,255,255));
	        panel4.setLayout(null);//设置空布局
	        panel2.add(panel4);



	        JLabel label1 = new JLabel("PLEASE CLICK CONTINUE TO PRINT YOUR BOARDING PASS ");
	        JLabel label2 = new JLabel("ACCORDING TO THE FIGURE BELOW ");
	        JLabel label3 = new JLabel("BOARDING PASS");
	        JLabel label4 = new JLabel("BOARDING PASS ");
	        JLabel label5 = new JLabel("HAVE A NICE TRIP");
	        JLabel label11 = new JLabel("NAME OF PASSENGER");
	        JLabel label12 = new JLabel("FROM");
	        JLabel label13 = new JLabel("TO");
	        JLabel label14 = new JLabel("SEAT");
	        JLabel label15 = new JLabel("PORT");
	        JLabel label16 = new JLabel("BOARDING TIME");
	        JLabel label17 = new JLabel();
	        try {
	   	        label17.setText(Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),1));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        JLabel label18 = new JLabel();
	        try {
	        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
	        		String src=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),4);	
	        	 label18.setText(src);
	        	} catch (Exception e) {
					e.printStackTrace();
				}
	        JLabel label19 = new JLabel();
	        try {
        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
        		String des=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),5);	
        	 label19.setText(des);
        	} catch (Exception e) {
				e.printStackTrace();
			}
	        JLabel label110 = new JLabel();
	        try {
	   	        label110.setText(Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),3));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        JLabel label111 = new JLabel();
	        try {
        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
        		String port=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),3);	
        	 label111.setText(port);
        	} catch (Exception e) {
				e.printStackTrace();
			}
	        JLabel label112 = new JLabel("1f");
	        try {
        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
        		String time=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),2);	
        	 label112.setText(time);
        	} catch (Exception e) {
				e.printStackTrace();
			}

	        JLabel label21 = new JLabel("SEAT");
	        JLabel label22 = new JLabel("PORT");
	        JLabel label23 = new JLabel("BOARDING TIME");
	        JLabel label24 = new JLabel();
	        try {
	   	        label24.setText(Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),3));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        JLabel label25 = new JLabel();
	        try {
        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
        		String port=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),3);	
        	 label25.setText(port);
        	} catch (Exception e) {
				e.printStackTrace();
			}
	        JLabel label26 = new JLabel();
	        try {
        	    String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
        		String time=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),2);	
        	 label26.setText(time);
        	} catch (Exception e) {
				e.printStackTrace();
			}

	        
	        ImageIcon image1 = new ImageIcon("src/res/barcode1-.png");//实例化ImageIcon 对象
	        image1.setImage(image1.getImage().getScaledInstance(120, 260,Image.SCALE_DEFAULT ));
	        JLabel icon1 = new JLabel(image1);
	        //icon1.setIcon(image1);
	        icon1.setBounds(10,10,120,260);
	        panel3.add(icon1);

	        JLabel icon2 = new JLabel();
	        ImageIcon image2 = new ImageIcon("src/res/barcode2.png");//实例化ImageIcon 对象
	        image2.setImage(image2.getImage().getScaledInstance(180, 40,Image.SCALE_DEFAULT ));
	        icon2.setIcon(image2);
	        icon2.setBounds(50,150,200,200);
	        panel4.add(icon2);

	        label1.setFont(new Font(Font.DIALOG,Font.PLAIN,33));//设置文字字体
	        label1.setForeground(Color.black);//设置文字的颜色
	        label2.setFont(new Font(Font.DIALOG,Font.PLAIN,33));//设置文字字体
	        label2.setForeground(Color.black);//设置文字的颜色
	        label3.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label3.setForeground(Color.white);//设置文字的颜色
	        label4.setFont(new Font(Font.DIALOG,Font.BOLD,25));//设置文字字体
	        label4.setForeground(Color.white);//设置文字的颜色
	        label5.setFont(new Font(Font.DIALOG,Font.BOLD,16));//设置文字字体
	        label5.setForeground(Color.white);//设置文字的颜色


	        label11.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label11.setForeground(Color.black);//设置文字的颜色
	        label12.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label12.setForeground(Color.black);//设置文字的颜色
	        label13.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label13.setForeground(Color.black);//设置文字的颜色
	        label14.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label14.setForeground(Color.black);//设置文字的颜色
	        label15.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label15.setForeground(Color.black);//设置文字的颜色
	        label16.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label16.setForeground(Color.black);//设置文字的颜色


	        label17.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label17.setForeground(Color.black);//设置文字的颜色
	        label18.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label18.setForeground(Color.black);//设置文字的颜色
	        label19.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label19.setForeground(Color.black);//设置文字的颜色
	        label110.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label110.setForeground(Color.black);//设置文字的颜色
	        label111.setFont(new Font(Font.DIALOG,Font.BOLD,30));//设置文字字体
	        label111.setForeground(Color.black);//设置文字的颜色
	        label112.setFont(new Font(Font.DIALOG,Font.BOLD,20));//设置文字字体
	        label112.setForeground(Color.black);//设置文字的颜色


	        label21.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label21.setForeground(Color.black);//设置文字的颜色
	        label22.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label22.setForeground(Color.black);//设置文字的颜色
	        label23.setFont(new Font(Font.DIALOG,Font.BOLD,17));//设置文字字体
	        label23.setForeground(Color.black);//设置文字的颜色
	        label24.setFont(new Font(Font.DIALOG,Font.BOLD,36));//设置文字字体
	        label24.setForeground(Color.black);//设置文字的颜色
	        label25.setFont(new Font(Font.DIALOG,Font.BOLD,36));//设置文字字体
	        label25.setForeground(Color.black);//设置文字的颜色
	        label26.setFont(new Font(Font.DIALOG,Font.BOLD,24));//设置文字字体
	        label26.setForeground(Color.black);//设置文字的颜色


	        //设置标签大小位置并添加标签
	        label1.setBounds(80,0,1000,100);
	        this.add(label1);
	        label2.setBounds(80,50,1000,100);
	        this.add(label2);
	        label3.setBounds(30,-20,1000,100);
	        panel1.add(label3);
	        label4.setBounds(70,-20,1000,100);
	        panel2.add(label4);
	        label5.setBounds(100,295,1000,100);
	        panel2.add(label5);

	        label11.setBounds(130,-20,1000,100);
	        panel3.add(label11);
	        label12.setBounds(130,60,1000,100);
	        panel3.add(label12);
	        label13.setBounds(130,140,1000,100);
	        panel3.add(label13);
	        label14.setBounds(400,-20,1000,100);
	        panel3.add(label14);
	        label15.setBounds(400,60,1000,100);
	        panel3.add(label15);
	        label16.setBounds(400,140,1000,100);
	        panel3.add(label16);

	        label17.setBounds(140,20,1000,100);
	        panel3.add(label17);
	        label18.setBounds(140,100,1000,100);
	        panel3.add(label18);
	        label19.setBounds(140,180,1000,100);
	        panel3.add(label19);
	        label110.setBounds(410,20,1000,100);
	        panel3.add(label110);
	        label111.setBounds(410,100,1000,100);
	        panel3.add(label111);
	        label112.setBounds(410,180,1000,100);
	        panel3.add(label112);


	        label21.setBounds(20,-30,1000,100);
	        panel4.add(label21);
	        label22.setBounds(20,40,1000,100);
	        panel4.add(label22);
	        label23.setBounds(20,110,1000,100);
	        panel4.add(label23);
	        label24.setBounds(130,0,1000,100);
	        panel4.add(label24);
	        label25.setBounds(130,70,1000,100);
	        panel4.add(label25);
	        label26.setBounds(130,150,1000,100);
	        panel4.add(label26);

	}

		
}

