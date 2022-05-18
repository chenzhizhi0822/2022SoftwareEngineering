package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{
	
	String name="";
	String Bookingnum="";
	String IDnum="";
	String loginWay="";
	
		

	
    public Login() {
    	this.setLayout(null);
        this.setBounds(198,82,989,582);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        
        RButton1 back = new RButton1("Back");
        RButton1 next = new RButton1("Next");
        back.setBounds(600, 500, 100, 50);
        next.setBounds(750, 500, 100, 50);
        
        JPanel cardArea =new JPanel();
        //cardArea.setBounds(3, 3, 930, 482);
        cardArea.setBounds(0, 0, 980, 580);
        
        
        //Choice Panel
        JPanel panel1 = new JPanel();
        RPanel panel1_1=new RPanel(600,400);//选项模块
        JLabel step=new JLabel("Step1: Flight Inquire");
        JLabel tip=new JLabel("Please select a query mode:");
        RButton1 bookingnumber = new RButton1("Booking Number");
        RButton1 IDnumber = new RButton1("ID Number");
        RButton1 scanID = new RButton1("Scan ID");
        
        //panel1.setPreferredSize(new Dimension(930, 482));
        panel1.setPreferredSize(new Dimension(989, 582));
        panel1.setLayout(null);
        panel1_1.setLayout(null);
        
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 200, 50);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(180, 20, 400, 50);
        //按钮设置        
        panel1_1.setBounds(200, 70,600,400);
        bookingnumber.setBounds(200,100,200,50);
        IDnumber.setBounds(200, 200, 200, 50);
        scanID.setBounds(200, 300, 200, 50);
        
        //组装
        panel1_1.add(tip);
        panel1_1.add(bookingnumber);
        panel1_1.add(IDnumber);
        panel1_1.add(scanID);
        panel1.add(step);
        panel1.add(panel1_1);
        
        this.add(cardArea);
        //this.add(back);
        //this.add(next);
        
        JPanel[] panelList = new JPanel[4];
		
		panelList[0]=panel1;
		
		panelList[1]=new LoginBookingnum();
		
		panelList[2]=new LoginIDnum();
		
		panelList[3]=new LoginScanID();
		
		initContainer(cardArea,panelList);
		
		selectView(0,cardArea);
				
		bookingnumber.addActionListener( (e)->{
			loginWay="bookingnumber";
			selectView(1,cardArea);
		});
		
		IDnumber.addActionListener( (e)->{
			loginWay="IDnumber";
	    	selectView(2,cardArea);
		});
	    
		scanID.addActionListener( (e)->{
			loginWay="scanID";
	    	selectView(3,cardArea);
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
    
	/*
    //Booking Number Panel
    public JPanel panel1(){
    	
    	JPanel panel1=new JPanel();
    	
    	//输入Booking Number模块
        JLabel step=new JLabel("Step1: Flight Inquire");
        JLabel bookingnumber =new JLabel("Booking Number: ");
        JTextField input =new JTextField();
        
    	
        panel1.setLayout(null);
        panel1.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 200, 50);
        bookingnumber.setFont(new Font("Times New Roman",Font.BOLD,30));
        bookingnumber.setBounds(80,200,300,50);

        //输入框设置
		input.setFont(new Font("Times New Roman",Font.BOLD,30));
        input.setBounds(350, 200, 400, 50);
        
        //store user input
        Bookingnum=input.getText();
       
        
        //组装       
        panel1.add(step);
        panel1.add(bookingnumber);
        panel1.add(input);
              

    	
    	return panel1;
    }
    */
	
	/*
    //ID Number Panel
    public JPanel panel2(){
    	
    	JPanel panel2=new JPanel();
        	
    	JLabel step=new JLabel("Step1: Flight Inquire");
        JLabel Surname =new JLabel("Surname: ");
        JLabel ID  = new JLabel("ID Number: ");
        JTextField inputSn =new JTextField();
        JTextField inputID =new JTextField();
        panel2.setLayout(null);
        panel2.setBounds(198,82,989,582);
        
    	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        Surname.setFont(new Font("Times New Roman",Font.BOLD,20));
        ID.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 200, 50);
        Surname.setBounds(100,150,200,50);
        ID.setBounds(350,150,200,50);

        //输入框设置
		inputSn.setFont(new Font("Times New Roman",Font.BOLD,20));
		inputID.setFont(new Font("Times New Roman",Font.BOLD,20));
        inputSn.setBounds(100, 200, 200, 50);
        inputID.setBounds(350, 200, 500, 50);
        
        // store user input
        name=inputSn.getText();
        IDnum=inputID.getText();
               
        //组装       
        panel2.add(step);
        panel2.add(Surname);
        panel2.add(ID);
        panel2.add(inputSn);
        panel2.add(inputID);
        
    	return panel2;
    }
    */
	
	/*
    //Scan IDcard Panel
    public JPanel panel3(){
    	
    	JPanel panel3=new JPanel();	
        JLabel step=new JLabel("Step1: Flight Inquire");
        JLabel tip=new JLabel("Please put your ID Card on the device");
        panel3.setLayout(null);
        panel3.setBounds(198,82,989,582);
        
      //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setFont(new Font("Times New Roman",Font.BOLD,40));
        step.setBounds(30, 10, 200, 50);
        tip.setBounds(130, 200, 700, 50);
        
      //组装       
        panel3.add(step);
        panel3.add(tip);

    	return panel3;
    }
    */
	
    // get user name
	public String getName() {
		  return name;
	}
	
	//get user booking number
	public int getBookingnum() {		
		return  Integer.parseInt(Bookingnum);
	}
	
	// get user ID number
	public int getIDnum() {
		return Integer.parseInt(IDnum);
	}

	// check input
	public int checkEmpty(String way) {
		int empty=0;
		if(way.equals("bookingnumber")&&Bookingnum=="") {
			empty=1;
		}
		else if((way.equals("IDnumber"))&&(name==""||IDnum=="")) {
			empty=1;
		}
		else {}
		return empty;
	}
	
}
