package Main;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/*
 * author KunyuanDing
 * example to test:
 * 		you can just run current file to test if the environment is run Correctly
 * to get total columns num:
 * 		System.out.println(Sheet.getColNum("..\\sheet\\user.xls"));
 * to get total row num:
 * 		System.out.println(Sheet.getRowNum("..\\sheet\\user.xls"));
 * to get sheetCell content:
 *  	System.out.println(Sheet.getCell("..\\sheet\\user.xls",3,1)); 
 * to change sheetCell:
 * 		Sheet.changeCell("..\\sheet\\test.xls", "exampleContent", 3, 6);
 */
public class Sheet {
	public static void main(String[] args) throws Exception {
		//Excel办公，以表格形式存在
		//如何实现：1.fastExcel 2.jxl解析（第三方） 3.poi方式（第三方）
		//通过jxl方式解析Excel步骤如下：
		//1. 导入jxl的jar包
		//2. 获取到Excel文件
		File file = new File("sheet/user.xls");
		Workbook wb =  Workbook.getWorkbook(file);
		//3. 获取指定的sheet页码   通过指定的Sheet页的名字获取指定的Sheet页，也可以通过索引获取Sheet
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		//4. 获取指定的单元格的数据  通过getCell方法获取指定单元格对象，参数是column,row,索引从0开始
//		Cell cell = sheet.getCell(0,0);
//		System.out.println(cell.getContents());
		
		//4.1 循环获取指定的行和列的单元格的值     外循环控制行，内循环控制列
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell = sheet.getCell(j,i);
				System.out.print(cell.getContents()+"\t");      //\t代表tab键的字符
			}
			System.out.println();               //设置每查询完一行就换行
		}
		wb.close();    //将工作簿的资源关闭
		Sheet a = new Sheet("");
	}

	private Workbook wb;
	private String path;
	public Sheet(String path) {
		File file = new File(path);
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("load workbook fail:"+path);
		}
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		this.wb = wb;
		this.path = path;
	}
	
	public String getCell(int column, int row) {
		jxl.Sheet sheet = this.wb.getSheet("Sheet1");
		
		Cell cell = sheet.getCell(column,row);
		String rtn = cell.getContents();
		
		wb.close();    //将工作簿的资源关闭
		return rtn;
		
	}
	
	public int getRowNum() {
		Workbook wb = this.wb;
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getRows();
		wb.close();    //将工作簿的资源关闭
		return row;
	}
	
	public int getColNum() {
		Workbook wb = this.wb;
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		int columns = sheet.getColumns();
		wb.close();    //将工作簿的资源关闭
		return columns;
	}
	
	public void changeCell(String content, int column,int row) {
		String path = this.path;
		try {
			//获得Excel文件
			Workbook wb = Workbook.getWorkbook(new File(path));
			//打开一个文件副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook(new File(path), wb);
			//添加一个工作表
			WritableSheet sheet = book.getSheet(0);
			sheet.addCell(new Label(column, row, content));
			book.write();
			book.close();
		}
		  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//静态方法
	public static String getCell(String path,int row,int column){
		//使用示例 
		//System.out.println( getCell("..\\sheet\\user.xls",3,1)); 
		
		File file = new File(path);
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("there were something wrong when open sheet: "+path);
		}
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		
		Cell cell = sheet.getCell(column,row);
		String rtn = cell.getContents();
		
		wb.close();    //将工作簿的资源关闭
		return rtn;
		
	}
	
	public static int getColNum(String path) {
		int columns=0;
		File file = new File(path);
		Workbook wb;
		try {
			wb = Workbook.getWorkbook(file);
			jxl.Sheet sheet = wb.getSheet("Sheet1");
			columns = sheet.getColumns();
			wb.close();    //将工作簿的资源关闭
		} catch (Exception e) {
			System.out.println("there were something wrong when getting column num");
		}
		return columns;
	}
	
	public static int getRowNum(String path) {
		int row=0;
		File file = new File(path);
		Workbook wb;
		try {
			wb = Workbook.getWorkbook(file);
			jxl.Sheet sheet = wb.getSheet("Sheet1");
			row = sheet.getRows();
			wb.close();    //将工作簿的资源关闭
		} catch (Exception e) {
			System.out.println("there were something wrong when getting row num");
		}
		return row;
	}
	
	//更换cell中的数据
	//example:
	//Sheet.changeCell("..\\sheet\\test.xls", "exampleContent", 3, 6);
	public static void changeCell(String path,String content, int column,int row) {
		try {
			//获得Excel文件
			Workbook wb = Workbook.getWorkbook(new File(path));
			//打开一个文件副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook(new File(path), wb);
			//添加一个工作表
			WritableSheet sheet = book.getSheet(0);
			sheet.addCell(new Label(column, row, content));

			book.write();
			book.close();
			wb.close();
		}
		  catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	// example:
	// System.out.println(Sheet.searchRow("..\\sheet\\user.xls",3,"seat")); 
	// 返回-1代表没找到
	// 返回值为匹配的行号
	public static int searchRow(String path, int column,String key) {
		int row=-1;
		File file = new File(path);
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			System.out.println("there were something wrong when searching row");
		}
		jxl.Sheet sheet = wb.getSheet("Sheet1");
		
		for(int i=0;i< sheet.getRows();i++) {
			Cell cell = sheet.getCell(column,i);
			String content = cell.getContents();
			if(content.equals(key)) {
				row = i;
			}
		}
		return row;
	}
	
	//example
	//Sheet.getImage("..\\sheet\\test.xls", 0, 6);
	public static Image getImage(String path,int column,int row){
		String img_path=getCell(path, row, column);
		BufferedImage bufImage = null;
		try {
			bufImage = ImageIO.read(new File(img_path));
		} catch (IOException e) {
			System.out.print("there are something wrong when getting img");
			e.printStackTrace();
		}
		return bufImage;
	}
	
	// example
    // Icon icon = Sheet.getIcon("..\\sheet\\test.xls", 0, 6);
	public static Icon getIcon(String path,int row,int column){
		String img_path=getCell(path, row, column);
		Icon icon = new ImageIcon(img_path);
		return icon;
	}
}
