package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatReserv extends JPanel {
	
	public SeatReserv() {
		
		this.setLayout(null);
        this.setBounds(198,82,989,582);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        RButton1 back = new RButton1("Back");
        back.setBounds(600, 550, 100, 50);
		RButton1 next = new RButton1("Next");
        next.setBounds(750, 550, 100, 50);
        
        JPanel cardArea =new JPanel();
        cardArea.setBounds(3, 3, 930, 482);
        
        JPanel panel1 = new JPanel();
        RPanel panel1_1=new RPanel(600,400);//选项模块
        JLabel step=new JLabel("Step2: Seat Reservation");
        JLabel tip=new JLabel("Please select your seat:");
        
        ImageIcon icon_green=new ImageIcon("src/res/chooseseat-green.png");//生成icon图片
        icon_green.setImage(icon_green.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon icon_red=new ImageIcon("src/res/chooseseat-red.png");//生成icon图片
        icon_red.setImage(icon_red.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        int count = 0;
        String seat=Sheet.getCell("../sheet/flight.xls", 1, 7);
        //System.out.println(seat);

        for (int i=0; i<400; i+=80){
            for(int j=200; j<=250; j+=50){
                if (seat.charAt(count)=='0') {
                    JButton jb=new JButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("Available");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    //jb.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(1,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    JButton jb=new JButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("Unavailable");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(2,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
            }
        }
        for (int i=0; i<400; i+=80){
            for(int j=325; j<=575; j+=50){
                if (seat.charAt(count)=='0') {
                    JButton jb=new JButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("Available");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(1,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    JButton jb=new JButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("Unavailable");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(2,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
            }
        }
        for (int i=0; i<400; i+=80){
            for(int j=650; j<=700; j+=50){
                if (seat.charAt(count)=='0') {
                    JButton jb=new JButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("Available");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(1,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    JButton jb=new JButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("Unavailable");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    // jb.setForeground(Color.GREEN);
                    // jb.setBackground(Color.GREEN);
            		jb.addActionListener( (e)->{
            	    	selectView(2,cardArea);
            		});
                    panel1_1.add(jb);
                    count++;
                }
            }
        }

        this.add(panel1_1, BorderLayout.CENTER);
        
        
        panel1.setPreferredSize(new Dimension(930, 482));
        panel1.setLayout(null);
        panel1_1.setLayout(null);
        
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 400, 50);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(380, 40, 400, 50);
        //按钮设置        
        panel1_1.setBounds(10, 100,900,400);
    
        
        //组装
        panel1.add(tip);
        panel1.add(step);
        panel1.add(panel1_1);
        //panel1_1.add(next);
        
        this.add(cardArea);
        this.add(back);
        this.add(next);
        
        JPanel[] panelList = new JPanel[11];
		
		panelList[0]=panel1;
		panelList[1]=panel1();
		panelList[2]=panel2();
		panelList[3]=panel3();
		panelList[4]=panel4();
		panelList[5]=panel5();
		panelList[6]=panel6();
		panelList[7]=panel7();
		panelList[8]=panel8();
		panelList[9]=panel9();
		panelList[10]=panel10();
		
		
		initContainer(cardArea,panelList);
		
		selectView(0,cardArea);
		

		back.addActionListener( (e)->{
	    	selectView(0,cardArea);
		});
		//next.addActionListener( (e)->{
	    	//selectView(10,cardArea);
		//});

				
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
	
	public JPanel panel1() {
		
		JPanel panel2 = new JPanel();
        
		JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Success!");
        JLabel choice = new JLabel("Your choice has been saved!");
        //JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel2.setLayout(null);
        panel2.setBounds(198,82,989,682);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(360, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(270,200,500,100);
        //tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        //tip.setBounds(210,300,1000,100);

        //组装       
        panel2.add(step);
        panel2.add(confirm);
        panel2.add(choice);
        //panel2.add(tip);
        
    	return panel2;
	}
	public JPanel panel2() {
		
		JPanel panel3 = new JPanel();
		
        JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Fail!");
        JLabel choice = new JLabel("Please choose again!");
        //JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel3.setLayout(null);
        panel3.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(400, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(320,200,500,100);
        //tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        //tip.setBounds(210,300,1000,100);

        //组装       
        panel3.add(step);
        panel3.add(confirm);
        panel3.add(choice);
        //panel3.add(tip);
                	
    	return panel3;
	}
	public JPanel panel3() {
	
		JPanel panel4 = new JPanel();
	
		JLabel step= new JLabel("Step2: Seat Reservation");
		JLabel confirm = new JLabel("Confirm!");
		JLabel choice = new JLabel("Your choice: Row 1, Column 3");
		JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
    
	
		panel4.setLayout(null);	
		panel4.setBounds(198,82,989,582);
    
       	
		//标语设置
		step.setFont(new Font("Times New Roman",Font.BOLD,20));
		step.setBounds(30, 10, 250, 50);
		confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
		confirm.setBounds(360, 80, 500, 100);
		choice.setFont(new Font("Times New Roman",Font.BOLD,30));
		choice.setBounds(270,200,500,100);
		tip.setFont(new Font("Times New Roman",Font.BOLD,20));
		tip.setBounds(210,300,1000,100);

		//组装       
		panel4.add(step);
		panel4.add(confirm);
		panel4.add(choice);
		panel4.add(tip);
            	
		return panel4;
	}
	public JPanel panel4() {
		
		JPanel panel5 = new JPanel();
	
		JLabel step= new JLabel("Step2: Seat Reservation");
		JLabel confirm = new JLabel("Confirm!");
		JLabel choice = new JLabel("Your choice: Row 2, Column 1");
		JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
    
	
		panel5.setLayout(null);	
		panel5.setBounds(198,82,989,582);
    
       	
		//标语设置
		step.setFont(new Font("Times New Roman",Font.BOLD,20));
		step.setBounds(30, 10, 250, 50);
		confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
		confirm.setBounds(360, 80, 500, 100);
		choice.setFont(new Font("Times New Roman",Font.BOLD,30));
		choice.setBounds(270,200,500,100);
		tip.setFont(new Font("Times New Roman",Font.BOLD,20));
		tip.setBounds(210,300,1000,100);

		//组装       
		panel5.add(step);
		panel5.add(confirm);
		panel5.add(choice);
		panel5.add(tip);
           	
		return panel5;
	}
	public JPanel panel5() {
		
		JPanel panel6 = new JPanel();
	
		JLabel step= new JLabel("Step2: Seat Reservation");
		JLabel fail = new JLabel("Fail!");
		JLabel choice = new JLabel("Your choice is invalid, please choose again!");
    
	
		panel6.setLayout(null);	
		panel6.setBounds(198,82,989,582);
    
       	
		//标语设置
		step.setFont(new Font("Times New Roman",Font.BOLD,20));
		step.setBounds(30, 10, 250, 50);
		fail.setFont(new Font("Times New Roman",Font.BOLD,50));
		fail.setBounds(400, 80, 500, 100);
		choice.setFont(new Font("Times New Roman",Font.BOLD,30));
		choice.setBounds(200,200,1000,100);

		//组装       
		panel6.add(step);
		panel6.add(fail);
		panel6.add(choice);
		
            	
		return panel6;
	}
	public JPanel panel6() {
		
		JPanel panel7 = new JPanel();
		
        JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Confirm!");
        JLabel choice = new JLabel("Your choice: Row 2, Column 3");
        JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel7.setLayout(null);
        panel7.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(360, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(270,200,500,100);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(210,300,1000,100);

        //组装       
        panel7.add(step);
        panel7.add(confirm);
        panel7.add(choice);
        panel7.add(tip);
                	
    	return panel7;
	}
	public JPanel panel7() {
		
		JPanel panel8 = new JPanel();
		
        JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Confirm!");
        JLabel choice = new JLabel("Your choice: Row 3, Column 1");
        JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel8.setLayout(null);
        panel8.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(360, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(270,200,500,100);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(210,300,1000,100);

        //组装       
        panel8.add(step);
        panel8.add(confirm);
        panel8.add(choice);
        panel8.add(tip);
                	
    	return panel8;
	}
	public JPanel panel8() {
		
		JPanel panel9 = new JPanel();
		
        JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Confirm!");
        JLabel choice = new JLabel("Your choice: Row 3, Column 2");
        JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel9.setLayout(null);
        panel9.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(360, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(270,200,500,100);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(210,300,1000,100);

        //组装       
        panel9.add(step);
        panel9.add(confirm);
        panel9.add(choice);
        panel9.add(tip);
                	
    	return panel9;
	}
	public JPanel panel9() {
		
		JPanel panel10 = new JPanel();
		
        JLabel step= new JLabel("Step2: Seat Reservation");
        JLabel confirm = new JLabel("Confirm!");
        JLabel choice = new JLabel("Your choice: Row 3, Column 3");
        JLabel tip = new JLabel("Click 'Next' to confirm your choice, if not, please click 'Back'.");
        
    	
        panel10.setLayout(null);
        panel10.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 250, 50);
        confirm.setFont(new Font("Times New Roman",Font.BOLD,50));
        confirm.setBounds(360, 80, 500, 100);
        choice.setFont(new Font("Times New Roman",Font.BOLD,30));
        choice.setBounds(270,200,500,100);
        tip.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setBounds(210,300,1000,100);

        //组装       
        panel10.add(step);
        panel10.add(confirm);
        panel10.add(choice);
        panel10.add(tip);
                	
    	return panel10;
	}
	public JPanel panel10() {
		
		JPanel panel11 = new JPanel();
		
		JLabel step= new JLabel("Step2: Seat Reservation");
		JLabel success = new JLabel("Success!");
		JLabel choice = new JLabel("Your choice is saved!");
    
	
		panel11.setLayout(null);	
		panel11.setBounds(198,82,989,582);
    
       	
		//标语设置
		step.setFont(new Font("Times New Roman",Font.BOLD,20));
		step.setBounds(30, 10, 250, 50);
		success.setFont(new Font("Times New Roman",Font.BOLD,50));
		success.setBounds(400, 80, 500, 100);
		choice.setFont(new Font("Times New Roman",Font.BOLD,30));
		choice.setBounds(200,200,1000,100);

		//组装       
		panel11.add(step);
		panel11.add(success);
		panel11.add(choice);
		
            	
		return panel11;
	}
}
