package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Swing2
{
	private static void createGUI()
	{
		JFrame frame = new MyFrame();
		frame.setVisible(true);
		
		// 居中显示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int x = ( screenSize.width - frame.getWidth())/2;
		int y = ( screenSize.height - frame.getHeight())/2;
		frame.setLocation(x,  y);		
	}
	
	public static void main(String[] args)
	{
		
		// int row=Sheet.getRowNum("..\\sheet\\test.xls");
	    // Sheet.changeCell("..\\sheet\\test.xls", "yyyyyyyyy", 0, row);
	    
		// 创建GUI线程
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createGUI();
			}
		});
	}
}
