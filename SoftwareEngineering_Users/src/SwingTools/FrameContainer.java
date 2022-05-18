package SwingTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import af.swing.AfButton;
import af.swing.AfPanel;
import af.swing.frame.AfFrameSupport;
import af.swing.image.AfImageButton;
import af.swing.layout.AfRowLayout;

public class FrameContainer extends JPanel
{
	public JLabel titleLabel = new JLabel();
	public AfImageButton minButton = createWindowButton();
	public AfImageButton closeButton = createWindowButton();
	
	private Component content;
	
	
	public FrameContainer()
	{
		this.setBorder(BorderFactory.createLineBorder(new Color(0x019AE8), 1));
		this.setLayout( new BorderLayout());
		
		Component titleBar = initTitleBar();
		this.add(titleBar , BorderLayout.PAGE_START);

		// 整体可以改变大小
		new AfFrameSupport(this, false, true);	
		
		// 把titleBar区域作为可以拖动的区域
		new AfFrameSupport(titleBar, true, false);
	}
	
	private Component initTitleBar()
	{
		AfPanel panel = new AfPanel();
		panel.setLayout(new AfRowLayout(1));
		panel.preferredHeight(30);
		panel.setOpaque(true);
		panel.setBackground(new Color(0x019AE8));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xB0b0b0)));
		panel.padding(2);
		
		panel.add(titleLabel, "1w");
		panel.add(minButton, "30px");
		panel.add(closeButton, "30px");	
		titleLabel.setForeground(Color.WHITE);
		
		minButton.normal.image = Util.loadIcon("/res/win_min.png");
		closeButton.normal.image = Util.loadIcon("/res/xx.png");		
		return panel;
	}

	// 指定右上角小按钮的参数
	public AfImageButton createWindowButton()
	{
		AfImageButton btn = new AfImageButton();
		btn.radius = 0;
		btn.padding = 1;
		btn.normal.bgColor = new Color(0x30FFFFFF,true);
		btn.hover.bgColor = new Color(0xE0FFD700,true);
		
		return btn;
	}
	
	// 设置中央区
	public void setContentPane(Component comp)
	{
		this.content = comp;
		this.add( comp, BorderLayout.CENTER);
	}
	
	public Component getContentPane()
	{
		return this.content;
	}
	
	
}
