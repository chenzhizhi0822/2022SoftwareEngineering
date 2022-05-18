package Main;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class Welcome extends JPanel{
	
	public Welcome() {
    	
        this.setBounds(198,82,989,582);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        //add airport image
        ImageIcon airport1 =new ImageIcon("src/res/airport.png");
        JLabel airport = new JLabel(airport1);
        airport1.setImage(airport1.getImage().getScaledInstance(930, 568, Image.SCALE_SMOOTH));
        this.add(airport);
        
	}
	

	

}
