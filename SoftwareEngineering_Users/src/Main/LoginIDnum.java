package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginIDnum extends JPanel implements ActionListener {
	
	String IDnum="";
	String name="";
	String Mode="IDnum";
	
	JLabel step=new JLabel("Step1: Flight Inquire");
    JLabel Surname =new JLabel("Surname: ");
    JLabel ID  = new JLabel("ID Number: ");
    JTextField inputSn =new JTextField();
    JTextField inputID =new JTextField();
    
    public LoginIDnum(){
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
        
               
        //组装       
        this.add(step);
        this.add(Surname);
        this.add(ID);
        this.add(inputSn);
        this.add(inputID);
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
			name=inputSn.getText();
	    	IDnum=inputID.getText();
			if(check()==1) {
				int choice=1;//the user's choice after reading the confirm dialog.
				choice=JOptionPane.showConfirmDialog(null,"Have you checked all the information is correct? You can't change the information once the information is submitted.","Confirm check in",JOptionPane.YES_NO_OPTION);
				if(choice==0) {
					storeinfo(name,IDnum);
					//new page

				}
			}
			else if(check()==0) {
				JOptionPane.showMessageDialog(null, "Please fill in the missing information", "Missing information",JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please input correctly", "Input wrong",JOptionPane.WARNING_MESSAGE);
				name="";
				IDnum="";
				inputSn.setText(name);
				inputID.setText(IDnum);
			}
		}
	}
	//input user input in login.xls
	 private void storeinfo(String name,String IDnum) {

	    	int row=Sheet.getRowNum("..\\sheet\\login.xls");
	    	Sheet.changeCell("..\\sheet\\login.xls", name, 1, row);
	    	Sheet.changeCell("..\\sheet\\login.xls", IDnum, 2, row);
	        
	    }
	// check user input
	private int check() {
		int empty=1;
		if(name.equals("")||IDnum.equals("")) {
			empty=0;
		}
		if(IDnum.length()!=13) {
			empty=-1;
		}
		return empty;
	}
}
