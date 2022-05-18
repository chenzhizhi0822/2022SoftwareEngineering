package Main;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SwingTools.FrameContainer;
import SwingTools.YLayout;




public class MyFrame extends JFrame
{	
	    JPanel panel1 = new JPanel();//显示logo 时间 欢迎语
	    JPanel panel2_1 = new JPanel();//按钮导航模块

	    //logo 时间 欢迎语的组件
	    ImageIcon logo1 = new ImageIcon("src/res/logo.png");
	    JLabel logo = new JLabel(logo1);
	    JLabel time = new JLabel();
	    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    JLabel welcome = new JLabel("Welcome to Mr.Ding Airport");

	    //导航模块组件
	    //RButton使用和Jbutton一样，只不过换成圆角了
	    JLabel naBar = new JLabel("Navigation Bar");
	    JPanel cardArea = new JPanel();
	    
	    RButton nav_btn1 = new RButton("Flight Inquire");
	    RButton nav_btn2 = new RButton("Login");
	    RButton nav_btn3 = new RButton("Seat Select");
	    RButton nav_btn4 = new RButton("Meal Select");
	    RButton nav_btn5 = new RButton("Luggage Manage");
	    RButton nav_btn6 = new RButton("Information Check");
	    RButton nav_btn7 = new RButton("Information OK");
	    RButton nav_btn8 = new RButton("Bording Pass");
	    /*
	     * this msg list is used to save user's input
	     * msg[0] == "bookingID"
	     * msg[1] == "name"
	     * msg[2] == "ID"
	     * msg[3] == "seat"
	     * msg[4] == "food"
	     * msg[5] == "taskID"
	     * msg[6] == "carry_luggage"
	     * msg[7] == "regi_luggage"
	     */
	    String msg[] = new String[8];
	    
	public MyFrame()
	{
		super("AIR COMPANY");
		this.setUndecorated(true);
		this.setSize(1200, 850);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Content Pane
		FrameContainer container = new FrameContainer();
		this.setContentPane(container);
		
		// 客户区设置
		JPanel clientArea = new JPanel();
		container.setContentPane( clientArea);
		clientArea.setLayout(new BorderLayout());
		clientArea.setOpaque(true);
		clientArea.setBackground(Color.WHITE);
		
		panel1(clientArea);
        panel2(clientArea);
        
        
        cardArea.setPreferredSize(new Dimension(950, 609));
        clientArea.add(cardArea,BorderLayout.EAST);
        
		JPanel[] panelList = new JPanel[8];
		
		panelList[0]=new Welcome();
		
		panelList[1]=new Login();
		
		panelList[2]=new SeatReserv();
		
		panelList[3]=new MealService();
		panelList[4]=new luggage();
		
		panelList[5]=new confirm(); //information
		panelList[6]=new confirm2();
		panelList[7]=new TicketPanel2("201920029");
		
		
		
		
		initContainer(cardArea,panelList);
		
		nav_btn1.addActionListener( (e)->{
			selectView(0,cardArea);
		});
		
		nav_btn2.addActionListener( (e)->{
	    	selectView(1,cardArea);
		});
	    
		nav_btn3.addActionListener( (e)->{
	    	selectView(2,cardArea);
		});
	    
		nav_btn4.addActionListener( (e)->{
	    	selectView(3,cardArea);
		});
	    
		nav_btn5.addActionListener( (e)->{
	    	selectView(4,cardArea);
		});
		
		nav_btn6.addActionListener( (e)->{
	    	selectView(5,cardArea);
		});
		
		nav_btn7.addActionListener( (e)->{
	    	selectView(6,cardArea);
		});
		
		nav_btn8.addActionListener( (e)->{
	    	selectView(7,cardArea);
		});
		
		// 最小化按钮
		container.minButton.addActionListener( (e)->{
			 setExtendedState(JFrame.ICONIFIED);
		});
		// 关闭按钮
		container.closeButton.addActionListener( (e)->{
			this.dispose();
			System.exit(0);
		});
		
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
	
	// this method is for you to changeView of cards
	public void selectView (int index)
	{
		
		JPanel container = this.cardArea;
		String name = "view" + index; // 卡片的名称 view0, view1, ...
		
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, name); // 根据名字来显示相应的卡片
		
	}
	
	 public void panel1(JPanel clientArea){
		 	
		 	clientArea.add(panel1,BorderLayout.NORTH);
	        panel1.setBounds(0,0,1187,85);
//	        panel1.setLayout(null);
	        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        //logo设置
	        logo.setBounds(20,10,201,66);
	        logo1.setImage(logo1.getImage().getScaledInstance(201,66,Image.SCALE_SMOOTH));
	        panel1.add(logo);
	        //欢迎语设置
	        welcome.setFont(new Font("Times New Roman",Font.BOLD,40));
	        welcome.setForeground(new Color(30,54,99));
	        welcome.setBounds(320,20,600,50);
	        panel1.add(welcome);
	        //时间设置
	        time.setBounds(900,20,310,50);
	        time.setFont(new Font("Times New Roman",Font.BOLD,30));
	        new SysTime(time).start();//多线程
	        panel1.add(time);
	    }

	    //导航栏设置
	    public void panel2(JPanel clientArea){
	    	clientArea.add(panel2_1,BorderLayout.WEST);
	        //标语设置

	        panel2_1.setLayout(new YLayout(20));
	        //panel2_1.setBounds(0,82,200,510);
	        panel2_1.setPreferredSize(new Dimension(250, 300));
	        panel2_1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
	        
	        
	        naBar.setFont(new Font("Times New Roman",Font.BOLD,28));
	        naBar.setForeground(new Color(30,54,99));
	        naBar.setBorder(new EmptyBorder(20, 20, 20, 20));

	        nav_btn1.setBorder(new EmptyBorder(20, 20, 20, 20));
	        
	        nav_btn2.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn3.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn4.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn5.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn6.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn7.setBorder(new EmptyBorder(20, 20, 20, 20));
	        nav_btn8.setBorder(new EmptyBorder(20, 20, 20, 20));
	        
	        panel2_1.add(naBar);
	        panel2_1.add(nav_btn1);
	        panel2_1.add(nav_btn2);
	        panel2_1.add(nav_btn3);
	        panel2_1.add(nav_btn4);
	        panel2_1.add(nav_btn5);
	        panel2_1.add(nav_btn6);
	        panel2_1.add(nav_btn7);
	        panel2_1.add(nav_btn8);
	    }

	   


	//时间显示线程
	    public class SysTime extends Thread{
	        JLabel lb;
	        public SysTime(JLabel lb){
	            this.lb=lb;
	        }
	        public void run(){
	            try {
	                while(true){
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    lb.setText(sdf.format(new Date()));
	                    sleep(1000);
	                }
	            }
	            catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	



	
}
