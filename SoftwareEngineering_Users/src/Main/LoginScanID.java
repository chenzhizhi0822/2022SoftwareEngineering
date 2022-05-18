package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginScanID extends JPanel implements ActionListener {
	
	
    JLabel step=new JLabel("Step1: Flight Inquire");
    JLabel tip=new JLabel("Please put your ID Card on the device");
    JTextField inputSn =new JTextField();
    JTextField inputID =new JTextField();
    
    public LoginScanID(){
    	this.setLayout(null);
        this.setBounds(198,82,989,582);
       
        
        
        RButton1 back = new RButton1("Back");
        RButton1 next = new RButton1("Next");
        back.setBounds(600, 500, 100, 50);
        next.setBounds(750, 500, 100, 50);
        back.addActionListener(this);
        next.addActionListener(this);
    	
      //标语设置
        step.setFont(new Font("Times New Roman",Font.BOLD,20));
        tip.setFont(new Font("Times New Roman",Font.BOLD,40));
        step.setBounds(30, 10, 200, 50);
        tip.setBounds(130, 200, 700, 50);
        
      //组装       
        this.add(step);
        this.add(tip);
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
			//Seat Reservation
		}
	}

}