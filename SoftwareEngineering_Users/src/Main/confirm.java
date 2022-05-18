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

//import Main.confirm2.confirmAction;
import Main.luggage.LoginOKAction;
import jxl.Cell;


public class confirm extends JPanel
{


	public confirm()
	{
		    String booknum= "201920029";
		    this.setLayout(null);
	        this.setBounds(198,82,989,582);
	        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        //this.setLayout(new GridLayout(6, 2,20,10));


	        JLabel label1=new JLabel("Please confirm your information: ");
	        Font font = new Font("宋体", Font.PLAIN, 20);//创建字体实例
	        label1.setFont(font);//设置JLabel的字体
	        label1.setForeground(Color.blue);//设置文字的颜色
	        label1.setBounds(10,10,400,80);
	        this.add(label1);//1.1

	        JLabel label2=new JLabel("Extra fee:");
	        label2.setFont(font);
	        label2.setBounds(700,10,200,80);
	        this.add(label2);//1.2
	        JLabel label3=new JLabel("Flight information:");
	        label3.setBounds(10,90,200,80);
	        JLabel label5=new JLabel();
	        try {
	        label5.setText(Sheet.getCell("..\\sheet\\flight.xls",2,1));
			} catch (Exception e) {
				e.printStackTrace();
			}
	        label3.setFont(font);
	        label5.setFont(font);
	        label5.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label5.setBounds(220,90,450,80);
	        this.add(label3);
	        this.add(label5);
	        //2.1

	      
	        JLabel label4=new JLabel("null");
	        label4.setFont(font);
	        label4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label4.setBounds(700,90,200,80);
	        this.add(label4);//2.2

	        JLabel label6=new JLabel("Seat:");
	        JLabel label7=new JLabel();
	        
	        try {
	   	        label7.setText(Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),3));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        label6.setFont(font);
	        label7.setFont(font);
	        label7.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label6.setBounds(10,190,200,80);
	        label7.setBounds(220,190,450,80);
	        this.add(label6);
	        this.add(label7);//3.1


	        JLabel label8=new JLabel();
	        int seatfee=0;
	        try {
	        	String seatprice="0";
	        	String seat=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),3);
	        	if(seat.charAt(0)=='T') {
	        		String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
	        		seatprice=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),8);	
	        		seatfee= Integer.valueOf(seatprice).intValue();
	        	}
	        	 label8.setText(seatprice);
	        	} catch (Exception e) {
					e.printStackTrace();
				}
	        label8.setFont(font);
	        label8.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label8.setBounds(700,190,200,80);
	        this.add(label8);//3.2

	        JLabel label9=new JLabel("Food:");
	        JLabel label10=new JLabel();
	        try {
		        label10.setText(Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),4));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        label9.setFont(font);
	        label10.setFont(font);
	        label10.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label9.setBounds(10,290,200,80);
	        label10.setBounds(220,290,450,80);
	        this.add(label9);
	        this.add(label10);//4.1

	        JLabel label11=new JLabel();
        	int foodprice=0;
	        try {
		        String s=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),4);
		        String[] foodidarray=s.split(",");
		        String[] foodpriceeach =new String[foodidarray.length];
		        for (int i=0;i<foodidarray.length;i++) {	        	
		        	foodpriceeach[i]=Sheet.getCell("..\\sheet\\food.xls",Sheet.searchRow("..\\sheet\\food.xls",0,foodidarray[i]),2);
		        }
		        for (int i=0;i<foodpriceeach.length;i++) {
		        	foodprice=foodprice+Integer.parseInt(foodpriceeach[i]);;
		        }
		        label11.setText(String.valueOf(foodprice));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        label11.setFont(font);
	        label11.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label11.setBounds(700,290,200,80);
	        this.add(label11);//4.2


	        JLabel label12=new JLabel("Luggage:");
	        JLabel label13=new JLabel("luggageinfromation");
	        try {
		        label13.setText("carry_luggage :"+Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),6)+" regi_luggage:"+Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),7));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        label12.setFont(font);
	        label13.setFont(font);
	        label13.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label12.setBounds(10,390,200,80);
	        label13.setBounds(220,390,450,80);
	        this.add(label12);
	        this.add(label13);//5.1

	        JLabel label14=new JLabel();
	        int luggagefee=0;
	        try {
	        	String taskid=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),5);
	        	String carryprice=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),8);	
	        	String carry=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),6);
	        	String regiprice=Sheet.getCell("..\\sheet\\flight.xls",Sheet.searchRow("..\\sheet\\flight.xls",0,taskid),10);	
	        	String regi=Sheet.getCell("..\\sheet\\user.xls",Sheet.searchRow("..\\sheet\\user.xls",0,booknum),7);
	        	luggagefee = Integer.valueOf(carryprice).intValue()*Integer.valueOf(carry).intValue()+Integer.valueOf(regiprice).intValue()*Integer.valueOf(regi).intValue();
	        	label14.setText(String.valueOf(luggagefee)); 
	        } catch (Exception e) {
					e.printStackTrace();
				}
	        label14.setFont(font);
	        label14.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label14.setBounds(700,390,200,80);
	        this.add(label14);//5.2


	        RButton button1=new RButton("Back");
	        RButton button2=new RButton("Next");
	        Dimension preferredSize = new Dimension(100,50);
	        button1.setPreferredSize(preferredSize );
	        button2.setPreferredSize(preferredSize );
	        button1.setBounds(250,520,100,60);
	        button2.setBounds(500,520,100,60);
	        button2.addActionListener( (e)->{
	        	this.setVisible(false);
		    	new confirm2().setVisible(true);
			});
	        this.add(button1);
	        this.add(button2);//6.1
	        

	        JLabel label15=new JLabel();
	        int totalfee=seatfee+foodprice+luggagefee;
	        try {
		        label15.setText("Total fee:"+String.valueOf(totalfee));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        label15.setFont(font);
	        label15.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        label15.setBounds(700,490,200,80);
	        this.add(label15);//6.2	    

	}
	
	
}

