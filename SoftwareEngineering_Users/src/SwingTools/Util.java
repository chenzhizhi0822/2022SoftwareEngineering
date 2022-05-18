package SwingTools;

import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Util
{
	public static Image loadIcon(String path)
	{
		try {
			URL url = Util.class.getResource(path);
			return ImageIO.read(url);
		}catch(Exception e)
		{
			System.out.println("** 无法加载图片 : " + path);
			e.printStackTrace();
			return null;
		}
	}
}
