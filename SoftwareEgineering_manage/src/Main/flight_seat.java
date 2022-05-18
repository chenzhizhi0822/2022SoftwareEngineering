package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class flight_seat extends JPanel{

    public MyFrame mainpanel;
    public flight_seat(MyFrame mainpanel){
        this.mainpanel=mainpanel;
        this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setLayout(new BorderLayout());

        JLabel titleJLabel = new JLabel("Flight Seat", JLabel.CENTER);//Let the JLabel be in the center.
        Font fnt = new Font("Arial", Font.BOLD, 38);
        titleJLabel.setFont(fnt);//Set the font in the JLabel.
        titleJLabel.setPreferredSize(new Dimension(989, 100));
        this.add(titleJLabel, BorderLayout.NORTH);

        // JPanel cardArea =new JPanel();
        // cardArea.setBounds(3, 3, 930, 482);

        JPanel flight_seat_1 = new JPanel(null);
        //获取图片地址
        ImageIcon icon_green=new ImageIcon("SoftwareEgineering_manage/src/res/chooseseat-green.png");//生成icon图片
        icon_green.setImage(icon_green.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon icon_red=new ImageIcon("SoftwareEgineering_manage/src/res/chooseseat-red.png");//生成icon图片
        icon_red.setImage(icon_red.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        int count = 0;
        String seat=Sheet.getCell("sheet/flight.xls", 1, 7);
        System.out.println(seat);

        for (int i=0; i<=600; i+=100){
            for(int j=200; j<=250; j+=50){
                if (seat.charAt(count)=='0') {
                    newJButton jb=new newJButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("无人，可选");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    //
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='1';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    newJButton jb=new newJButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("有人了捏");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    //
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='0';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
            }
        }
        for (int i=0; i<=600; i+=100){
            for(int j=325; j<=575; j+=50){
                if (seat.charAt(count)=='0') {
                    newJButton jb=new newJButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("无人，可选");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='1';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    newJButton jb=new newJButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("有人了捏");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='0';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
            }
        }
        for (int i=0; i<=600; i+=100){
            for(int j=650; j<=700; j+=50){
                if (seat.charAt(count)=='0') {
                    newJButton jb=new newJButton(icon_green);
                    //设置按钮的提示信息
                    jb.setToolTipText("无人，可选");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='1';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
                else if(seat.charAt(count)=='1'){
                    newJButton jb=new newJButton(icon_red);
                    //设置按钮的提示信息
                    jb.setToolTipText("有人了捏");
                    //添加按钮
                    jb.setBounds(j, i, 45, 50);
                    jb.seatnumber = count;
            		jb.addActionListener( (e)->{
                        int a = jb.seatnumber;
                        JOptionPane.showMessageDialog(null, "Are you sure you wang to change the seat status?", null, JOptionPane.DEFAULT_OPTION);
                        char[] seat1 = seat.toCharArray();
                        seat1[a]='0';
                        String seatrevise = Arrays.toString(seat1).replaceAll("[\\[\\]\\s,]", "");
                        Sheet.changeCell("sheet/flight.xls", seatrevise, 7, 1);
            	    	mainpanel.selectView(4);
            		});
                    flight_seat_1.add(jb);
                    count++;
                }
            }
        }

        this.add(flight_seat_1, BorderLayout.CENTER);
        //this.add(cardArea);

        // JPanel[] panelList = new JPanel[3];
		
		// panelList[0]=flight_seat_1;
		// panelList[1]=new ManageRevise_Seat(mainpanel);
		// panelList[2]=new ManageRevise_Seat(mainpanel);
		
		// initContainer(cardArea,panelList);
		
		// selectView(0,cardArea);
    }
    //继承一下，让座位可以找到号，对应修改
    public class newJButton extends JButton {
        public int seatnumber;
        public newJButton(ImageIcon icon){
            super(icon);            
        }
    }
    // private void initContainer(JPanel container,JPanel[] panelList)
	// {		
	// 	// 设置为卡片布局
	// 	CardLayout cardLayout = new CardLayout();
	// 	container.setLayout(cardLayout);		
	// 	container.setOpaque(true);
	// 	container.setBackground(new Color(0xF4F4F4));
	// 	container.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, new Color(0xCCCCCC)));

	// 	// 添加多个卡片
	// 	int index = 0;
	// 	for(JPanel i : panelList) {
	// 		container.add(i, "view"+index);
	// 		index++;
	// 	}
	// 	// 默认显示第一张卡片	
	// 	selectView(0,container);		
	// }
	// // 切换卡片 
	// public void selectView (int index, JPanel container)
	// {
	// 	String name = "view" + index; // 卡片的名称 view0, view1, ...
		
	// 	CardLayout cardLayout = (CardLayout)container.getLayout();
	// 	cardLayout.show(container, name); // 根据名字来显示相应的卡片
		
	// }

}
