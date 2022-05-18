package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class RPanel1 extends JPanel {

//圆角边框
private static final long serialVersionUID = 1L;
 
	public RPanel1 (int width,int height) {
		super();
		setOpaque(true);
		setSize(width, height);
		setBackground(Color.WHITE);
	}
 
	@Override
	public void paint(Graphics g) {
		int fieldX = 0;
		int fieldY = 0;
		int fieldWeight = getSize().width;
		int fieldHeight = getSize().height;
		RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
		g.setClip(rect);
		super.paint(g);
	}
 
}