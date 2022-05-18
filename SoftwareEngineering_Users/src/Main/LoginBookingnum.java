package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.*;

public class LoginBookingnum extends JPanel implements ActionListener{
	String Bookingnum="";
	String Mode="BookingNumber";
	//输入Booking Number模块
    JLabel step=new JLabel("Step1: Flight Inquire");
    JLabel bookingnumber =new JLabel("Booking Number: ");
    JTextField input =new JTextField();
    public LoginBookingnum() {
    	this.setLayout(null);
        this.setBounds(198,82,989,582);
       
        
        RButton1 back = new RButton1("Back");
        RButton1 next = new RButton1("Next");
        back.setBounds(600, 500, 100, 50);
        next.setBounds(750, 500, 100, 50);
        back.addActionListener(this);
        next.addActionListener(this);
    	
    	this.setLayout(null);
        this.setBounds(198,82,989,582);
        
           	
        //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        step.setBounds(30, 10, 200, 50);
        bookingnumber.setFont(new Font("Times New Roman",Font.BOLD,30));
        bookingnumber.setBounds(80,200,300,50);

        //输入框设置
    	input.setFont(new Font("Times New Roman",Font.BOLD,30));
        input.setBounds(350, 200, 400, 50);
        
       
        
        //组装       
        this.add(step);
        this.add(bookingnumber);
        this.add(input);
        this.add(back);
        this.add(next);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonname=e.getActionCommand();
		if(buttonname.equals("Back")) {
			new Login();
			this.setVisible(false);
		}
		if(buttonname.equals("Next")) {
			Bookingnum=input.getText();
			if(check()==1) {
				int choice=1;//the user's choice after reading the confirm dialog.
				choice=JOptionPane.showConfirmDialog(null,"Have you checked all the information is correct? You can't change the information once the information is submitted.","Confirm check in",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					storeinfo(Bookingnum);
					//new page
				}
			}
			else if(check()==0){
				JOptionPane.showMessageDialog(null, "Please fill in the missing information", "Missing information",JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please input correctly", "Input wrong",JOptionPane.WARNING_MESSAGE);
				Bookingnum="";
				input.setText(Bookingnum);
			}
		}
		
	}
	//input user input in login.xls
    private void storeinfo(String Bookingnum) {
	
    	int row=Sheet.getRowNum("..\\sheet\\login.xls");
    	Sheet.changeCell("..\\sheet\\login.xls", Bookingnum, 0, row);
        
    }
    // check user input
	private int check() {
		int empty=1;
		if(Bookingnum.equals("")) {
			empty=0;
		}
		if(Bookingnum.length()!=9) {
			empty=-1;
		}
		return empty;
	}
	
}
