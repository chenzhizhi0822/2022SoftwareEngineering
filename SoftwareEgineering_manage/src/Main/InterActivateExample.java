package Main;

public class InterActivateExample {

	public MyFrame mainPanel;
	public InterActivateExample(MyFrame mainPanel) {
		this.mainPanel=mainPanel;
		
	}
	
	//for change view
	public void changeViewMethod() {
		
		mainPanel.selectView(1);
		
	}
	
	//for change msg
	public void changeMsg() {
		mainPanel.msg[0]= "some message";
		mainPanel.msg[1]="other message";
	}
	

}
