package Main;


import java.awt.event.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import SwingTools.FrameContainer;
import SwingTools.YLayout;




public class MyFrame extends JFrame
{	
		boolean iflogin = false;//控制管理员没登陆不显示其他页面
		boolean ifchooseflight = false;//控制不能直接进修改界面
		boolean ifchooseseat = false;//控制不能直接进修改界面

	    JPanel panel1 = new JPanel();//显示logo 时间 欢迎语
	    JPanel panel2_1 = new JPanel();//按钮导航模块
	    JPanel cardArea = new JPanel();
	    
	    //logo 时间 欢迎语的组件
	    ImageIcon logo1 = new ImageIcon("SoftwareEgineering_manage/src/res/logo.png");
	    JLabel logo = new JLabel(logo1);
	    JLabel time = new JLabel();
	    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    JLabel welcome = new JLabel("Welcome to Mr.Ding Airport");

	    
	    //导航模块组件
	    //RButton使用和Jbutton一样，只不过换成圆角了
	    JLabel naBar = new JLabel("Navigation Bar");
	    RButton LogIn = new RButton("Log in");
	    RButton fliTable = new RButton("Flight Timetable");
	    RButton reFli = new RButton("Revise Flight");
	    RButton reSeat = new RButton("Flight Seat");
	    RButton logOut = new RButton("Revise Seat");
	    
	    /*
	     * this msg list is used to save user's input
	     * msg[0] == "ID"
	     * msg[1] == "password"
	     * msg[2] == "rank"
	     */
	    String msg[] = new String[3];
	    
	public MyFrame()
	{
		super("AIR COMPANY");
		this.setUndecorated(true);
		this.setSize(1200, 700);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Content Panel
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
        
		JPanel[] panelList = new JPanel[5];
		
		panelList[0]=panel3();
		
		panelList[1]=new ManageView(this);
		
		panelList[2]=new ManageRevise_Flight(this);
		
		panelList[3]=new flight_seat(this);

		panelList[4]=new ManageRevise_Seat(this);
		
		initContainer(cardArea,panelList);
		
		LogIn.addActionListener( (e)->{
			selectView(0,cardArea);
		});
		
	    fliTable.addActionListener( (e)->{
			if(iflogin == true)
			selectView(1,cardArea);
			else 
			JOptionPane.showMessageDialog(null, "Please login first", null, JOptionPane.WARNING_MESSAGE);
		});
	    
	    reFli.addActionListener( (e)->{
			if(iflogin == true)
			selectView(2,cardArea);
			else 
			JOptionPane.showMessageDialog(null, "Please login first", null, JOptionPane.WARNING_MESSAGE);
		});
	    
	    reSeat.addActionListener( (e)->{
			if(iflogin == true)
			selectView(3,cardArea);
			else 
			JOptionPane.showMessageDialog(null, "Please login first", null, JOptionPane.WARNING_MESSAGE);
		});
	    
	    logOut.addActionListener( (e)->{
			if(iflogin == true)
			selectView(4,cardArea);
			else 
			JOptionPane.showMessageDialog(null, "Please login first", null, JOptionPane.WARNING_MESSAGE);
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
	
	
	public void initContainer(JPanel container,JPanel[] panelList)
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

	        LogIn.setBorder(new EmptyBorder(20, 20, 20, 20));
	        
	        fliTable.setBorder(new EmptyBorder(20, 20, 20, 20));
	        reFli.setBorder(new EmptyBorder(20, 20, 20, 20));
	        reSeat.setBorder(new EmptyBorder(20, 20, 20, 20));
	        logOut.setBorder(new EmptyBorder(20, 20, 20, 20));
	        
	        panel2_1.add(naBar);
	        panel2_1.add(LogIn);
	        panel2_1.add(fliTable);
	        panel2_1.add(reFli);
	        panel2_1.add(reSeat);
	        panel2_1.add(logOut);
	    }

	    public JPanel panel3(){
	    	JPanel panel3=new JPanel(new GridLayout(2,1));
	    	
	        panel3.setBounds(198,82,989,582);
	        panel3.setBorder(BorderFactory.createLineBorder(Color.black, 3));

	        //全部内容添加在此
			// JPanel panel3_1 = new JPanel(new GridLayout(1,2,20,0));
			// JPanel panel3_1_1 = new JPanel(null);
			// JPanel panel3_1_2 = new JPanel(null);

			//JLabel titleJLabel1 = new JLabel("W", JLabel.CENTER);//Let the JLabel be in the center.
			JLabel titleJLabel = new JLabel("Welcome to the flight management system: ", JLabel.CENTER);//Let the JLabel be in the center.
			// Font fnt1 = new Font("Arial", Font.BOLD, 50);
			// titleJLabel1.setFont(fnt1);//Set the font in the JLabel.
			Font fnt = new Font("Arial", Font.BOLD, 38);
			titleJLabel.setFont(fnt);

			JPanel panel3_2 = new JPanel(new GridLayout(1,2,20,0));
			JPanel panel3_2_1 = new JPanel(null);
			JPanel panel3_2_2 = new JPanel(null);

			ImageIcon ManageIdIcon = new ImageIcon("SoftwareEgineering_manage/src/res/user-fill.png");
			ManageIdIcon.setImage(ManageIdIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			JLabel ManageIdIconLabel = new JLabel(ManageIdIcon);
			ManageIdIconLabel.setBounds(70, 0, 30, 30);
			JTextArea ManageId = new  JTextArea("ID",1,20);
			ManageId.setBounds(120, 0, 300, 30);
			ManageId.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			JLabel starJLabel1 = new JLabel("*");
			starJLabel1.setFont(new Font("Arial", Font.BOLD, 30));
			starJLabel1.setForeground(Color.RED);
			starJLabel1.setBounds(430, 5, 30, 30);

			ImageIcon ManagepasswordIcon = new ImageIcon("SoftwareEgineering_manage/src/res/key.png");
			ManagepasswordIcon.setImage(ManagepasswordIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			JLabel ManagepasswordIconLabel = new JLabel(ManagepasswordIcon);
			ManagepasswordIconLabel.setBounds(70, 50, 30, 30);
			JTextArea Managepassword = new  JTextArea("Password",1,20);
			Managepassword.setBounds(120, 50, 300, 30);
			Managepassword.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			JLabel starJLabel2 = new JLabel("*");
			starJLabel2.setFont(new Font("Arial", Font.BOLD, 30));
			starJLabel2.setForeground(Color.RED);
			starJLabel2.setBounds(430, 55, 30, 30);

			RButton ManageLoginButton = new RButton("Login");
			ManageLoginButton.setBounds(150, 150, 200, 50);
			ManageLoginButton.setFont(fnt);
			ImageIcon ManageLoginImage = new ImageIcon("SoftwareEgineering_manage/src/res/logo.png");
			ManageLoginImage.setImage(ManageLoginImage.getImage().getScaledInstance(450, 150,Image.SCALE_DEFAULT));
			JLabel ManageLoginImageLabel = new JLabel(ManageLoginImage);
			ManageLoginImageLabel.setBounds(0,0,450,150);

			panel3_2_1.add(ManageId);
			panel3_2_1.add(ManageIdIconLabel);
			panel3_2_1.add(starJLabel1);
			panel3_2_1.add(Managepassword);
			panel3_2_1.add(ManageLoginButton);
			panel3_2_1.add(ManagepasswordIconLabel);
			panel3_2_1.add(starJLabel2);
			panel3_2_2.add(ManageLoginImageLabel);
			panel3_2.add(panel3_2_1);
			panel3_2.add(panel3_2_2);
			panel3.add(titleJLabel);
			//panel3_1_2.add(titleJLabel2);//Let the JLabel be in the center.
			// panel3_1.add(panel3_1_1);
			// panel3_1.add(panel3_1_2);
			//panel3.add(panel3_1);
			panel3.add(panel3_2);

			//检测文本是否为空，空则提示！
			ManageId.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					if (ManageId.getText().equals("")==false)
						starJLabel1.setVisible(false);
					else 
						starJLabel1.setVisible(true);
				}
				public void focusLost(FocusEvent e){
					if (ManageId.getText().equals("")==false)
						starJLabel1.setVisible(false);
					else 
						starJLabel1.setVisible(true);
				}
			});
			Managepassword.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					if (Managepassword.getText().equals("")==false)
						starJLabel2.setVisible(false);
					else 
						starJLabel2.setVisible(true);
				}
				public void focusLost(FocusEvent e){
					if (Managepassword.getText().equals("")==false)
						starJLabel2.setVisible(false);
					else 
						starJLabel2.setVisible(true);
				}
			});

			//Search input in the  manage sheet
			// String ID=Sheet.getCell("sheet/manage.xls", Sheet.searchRow("sheet/manage.xls", 0, ManageId.getText()), 0);
			// String Password=Sheet.getCell("sheet/manage.xls", Sheet.searchRow("sheet/manage.xls", 0, Managepassword.getText()), 1);



			//check
			ManageLoginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (ManageId.getText().equals("ID") && Managepassword.getText().equals("Password")) {
						JOptionPane.showMessageDialog(null, "You have successfully login!", null, JOptionPane.PLAIN_MESSAGE);

						iflogin = true;//已登陆，可以切换页面了.
						selectView(1);

					}
					else 
						JOptionPane.showMessageDialog(null, "Wrong ID or Password", null, JOptionPane.WARNING_MESSAGE);
				}
			});

	        return panel3;
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
