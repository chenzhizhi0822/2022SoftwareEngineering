package Main;

import javax.swing.*;
import java.awt.*;

public class LuggageVoucherPanel extends JPanel{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon ii=new ImageIcon("src/res/LuggageVoucher.png");
        ii.setImage(ii.getImage().getScaledInstance(810,264,Image.SCALE_SMOOTH));
        g.drawImage(ii.getImage(),0,0,this);
    }
}
