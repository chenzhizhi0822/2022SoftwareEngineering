package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList; 

public class ManageRevise_Flight extends JPanel {

    boolean ifchooseflight = false;

    public MyFrame mainpanel;
    public ManageRevise_Flight(MyFrame mainpanel){//无参数构造器 （实现添加）
        this.mainpanel=mainpanel;
        this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setLayout(new BorderLayout());

        JLabel titleJLabel = new JLabel("Revise page(Flight)", JLabel.CENTER);//Let the JLabel be in the center.
        Font fnt = new Font("Arial", Font.BOLD, 38);
        titleJLabel.setFont(fnt);//Set the font in the JLabel.
        titleJLabel.setPreferredSize(new Dimension(989, 100));
        this.add(titleJLabel, BorderLayout.NORTH);

        JPanel panel_ReviseFlight_1 = new JPanel(null);
        //冗余，封装成函数
        ImageIcon flightNumberIcon = new ImageIcon("SoftwareEgineering_manage/src/res/flight.png");
        flightNumberIcon.setImage(flightNumberIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel flightNumberIconLabel = new JLabel(flightNumberIcon);
        flightNumberIconLabel.setBounds(200, 0, 50, 50);
        panel_ReviseFlight_1.add(flightNumberIconLabel);
        JLabel flightNumberJTextLabel = new JLabel("Flight number:", JLabel.CENTER);
        flightNumberJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseFlight_1.add(flightNumberJTextLabel);
        JTextArea flightNumberJTextArea = new JTextArea(1,30);
        flightNumberJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseFlight_1.add(flightNumberJTextArea);
        JLabel starJLabel1 = new JLabel("*");
        starJLabel1.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel1.setForeground(Color.RED);
        panel_ReviseFlight_1.add(starJLabel1);
        flightNumberJTextLabel.setBounds(250,0,200,40);
        flightNumberJTextArea.setBounds(450,0,200,30);
        starJLabel1.setBounds(650,0,40,40);

        ImageIcon flightStateIcon = new ImageIcon("SoftwareEgineering_manage/src/res/Flight_Status.png");
        flightStateIcon.setImage(flightStateIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel flightStateIconLabel = new JLabel(flightStateIcon);
        flightStateIconLabel.setBounds(200, 90, 50, 50);
        panel_ReviseFlight_1.add(flightStateIconLabel);
        JLabel flightStateJTextLabel = new JLabel("Flight state:", JLabel.CENTER);
        flightStateJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseFlight_1.add(flightStateJTextLabel);
        JTextArea flightStateJTextArea = new JTextArea(1,30);
        flightStateJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseFlight_1.add(flightStateJTextArea);
        JLabel starJLabel2 = new JLabel("*");
        starJLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel2.setForeground(Color.RED);
        panel_ReviseFlight_1.add(starJLabel2);
        flightStateJTextLabel.setBounds(250,95,200,40);
        flightStateJTextArea.setBounds(450,100,200,30);
        starJLabel2.setBounds(650,100,40,40);

        ImageIcon timeIcon = new ImageIcon("SoftwareEgineering_manage/src/res/flight-takeoff-line.png");
        timeIcon.setImage(timeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel timeIconLabel = new JLabel(timeIcon);
        timeIconLabel.setBounds(200, 190, 50, 50);
        panel_ReviseFlight_1.add(timeIconLabel);
        JLabel timeJTextLabel = new JLabel("Take off time:", JLabel.CENTER);
        timeJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseFlight_1.add(timeJTextLabel);
        JTextArea timeJTextArea = new JTextArea(1,20);
        timeJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseFlight_1.add(timeJTextArea);
        JLabel starJLabel3 = new JLabel("*");
        starJLabel3.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel3.setForeground(Color.RED);
        panel_ReviseFlight_1.add(starJLabel3);
        timeJTextLabel.setBounds(250,200,200,40);
        timeJTextArea.setBounds(450,200,200,30);
        starJLabel3.setBounds(650,200,40,40);

        ImageIcon destinationIcon = new ImageIcon("SoftwareEgineering_manage/src/res/flight-land-line.png");
        destinationIcon.setImage(destinationIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel destinationIconLabel = new JLabel(destinationIcon);
        destinationIconLabel.setBounds(200, 290, 50, 50);
        panel_ReviseFlight_1.add(destinationIconLabel);
        JLabel destinationJTextLabel = new JLabel("Destination:", JLabel.CENTER);
        destinationJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseFlight_1.add(destinationJTextLabel);
        JTextArea destinationJTextArea = new JTextArea(1,20);
        destinationJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseFlight_1.add(destinationJTextArea);
        JLabel starJLabel4 = new JLabel("*");
        starJLabel4.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel4.setForeground(Color.RED);
        panel_ReviseFlight_1.add(starJLabel4);
        destinationJTextLabel.setBounds(250,300,200,40);
        destinationJTextArea.setBounds(450,300,200,30);
        starJLabel4.setBounds(650,300,200,30);

        ImageIcon portIcon = new ImageIcon("SoftwareEgineering_manage/src/res/flightflag.png");
        portIcon.setImage(portIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel portIconLabel = new JLabel(portIcon);
        portIconLabel.setBounds(200, 400, 50, 50);
        panel_ReviseFlight_1.add(portIconLabel);
        JLabel portJTextLabel = new JLabel("Port number:", JLabel.CENTER);
        portJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseFlight_1.add(portJTextLabel);
        JTextArea portJTextArea = new JTextArea(1,20);
        portJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseFlight_1.add(portJTextArea);
        JLabel starJLabel5 = new JLabel("*");
        starJLabel5.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel5.setForeground(Color.RED);
        panel_ReviseFlight_1.add(starJLabel5);
        portJTextLabel.setBounds(250,400,200,40);
        portJTextArea.setBounds(450,400,200,30);
        starJLabel5.setBounds(650,400,200,30);

        this.add(panel_ReviseFlight_1, BorderLayout.CENTER);




        //检测文本是否为空，空则提示！
        flightNumberJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (flightNumberJTextArea.getText().equals("")==false)
                    starJLabel1.setVisible(false);
                else 
                    starJLabel1.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (flightNumberJTextArea.getText().equals("")==false)
                    starJLabel1.setVisible(false);
                else 
                    starJLabel1.setVisible(true);
            }
        });
        flightStateJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (flightStateJTextArea.getText().equals("")==false)
                    starJLabel2.setVisible(false);
                else 
                    starJLabel2.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (flightStateJTextArea.getText().equals("")==false)
                    starJLabel2.setVisible(false);
                else 
                    starJLabel2.setVisible(true);
            }
        });
        timeJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (timeJTextArea.getText().equals("")==false)
                    starJLabel3.setVisible(false);
                else 
                    starJLabel3.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (timeJTextArea.getText().equals("")==false)
                    starJLabel3.setVisible(false);
                else 
                    starJLabel3.setVisible(true);
            }
        });
        destinationJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (destinationJTextArea.getText().equals("")==false)
                    starJLabel4.setVisible(false);
                else 
                    starJLabel4.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (destinationJTextArea.getText().equals("")==false)
                    starJLabel4.setVisible(false);
                else 
                    starJLabel4.setVisible(true);
            }
        });
        portJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (portJTextArea.getText().equals("")==false)
                    starJLabel5.setVisible(false);
                else 
                    starJLabel5.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (portJTextArea.getText().equals("")==false)
                    starJLabel5.setVisible(false);
                else 
                    starJLabel5.setVisible(true);
            }
        });

		final JPanel panel = new JPanel();
        this.add(panel,BorderLayout.SOUTH);
        final RButton clearButton = new RButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Clear all the text in the text box.
                flightNumberJTextArea.setText("");
                flightStateJTextArea.setText("");
                timeJTextArea.setText("");
                destinationJTextArea.setText("");
                portJTextArea.setText("");
                starJLabel1.setVisible(true);
                starJLabel2.setVisible(true);
                starJLabel3.setVisible(true);
                starJLabel4.setVisible(true);
                starJLabel5.setVisible(true);
            }
        });
        panel.add(clearButton);

        final RButton confirmButton = new RButton("Add new flight");
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //The input information is stored and passed through the arrylist.
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(flightNumberJTextArea.getText());
                strings.add(flightStateJTextArea.getText());
                strings.add(timeJTextArea.getText());
                strings.add(destinationJTextArea.getText());
                strings.add(portJTextArea.getText());
                if(flightNumberJTextArea.getText().equals("")|| 
                    flightStateJTextArea.getText().equals("") ||
                    timeJTextArea.getText().equals("") || 
                    destinationJTextArea.getText().equals("") || 
                    portJTextArea.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please fill in the missing information", null, JOptionPane.WARNING_MESSAGE);
                // If no JTextArea is empty, then pass data to anothor frame.
                else{
                    int a = JOptionPane.showConfirmDialog(null, "Have you checked all the information is correct?", "Confirm check in?", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        Sheet sheet = new Sheet("sheet/flight.xls");
                        int row = Sheet.getRowNum("sheet/flight.xls");
                        //Write
                        sheet.changeCell(flightNumberJTextArea.getText(), 1,row);
                        sheet.changeCell(flightStateJTextArea.getText(), 2,row);
                        sheet.changeCell(timeJTextArea.getText(), 3,row);
                        sheet.changeCell("Beijing", 5, row);
                        sheet.changeCell(destinationJTextArea.getText(), 6,row);
                        sheet.changeCell(portJTextArea.getText(), 4,row);

                        JOptionPane.showMessageDialog(null, "You have successfully add a flight", null, JOptionPane.INFORMATION_MESSAGE);

                        mainpanel.selectView(1);
                    }
                }
            }
        });
        panel.add(confirmButton);


    }


















    public ManageRevise_Flight(Object flightnumber, Object flightstate,
     Object time, Object destination, Object port){//实际有参数构造器 （实现修改）
        this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setLayout(new BorderLayout());

        JLabel titleJLabel = new JLabel("Revise page(Flight)", JLabel.CENTER);//Let the JLabel be in the center.
        Font fnt = new Font("Arial", Font.BOLD, 28);
        titleJLabel.setFont(fnt);//Set the font in the JLabel.
        titleJLabel.setPreferredSize(new Dimension(989, 100));
        this.add(titleJLabel, BorderLayout.NORTH);

        JPanel panel_ReviseFlight_1 = new JPanel(new GridLayout(5,2,2,5));
        panel_ReviseFlight_1.add(new JLabel("Flight number:"), JLabel.CENTER);
        panel_ReviseFlight_1.add(new JTextArea(flightnumber.toString(),1,20));
        panel_ReviseFlight_1.add(new JLabel("Flight state:"));
        panel_ReviseFlight_1.add(new JTextArea(flightstate.toString(),1,20));
        panel_ReviseFlight_1.add(new JLabel("Flight number:"));
        panel_ReviseFlight_1.add(new JTextArea(time.toString(),1,20));
        panel_ReviseFlight_1.add(new JLabel("Flight number:"));
        panel_ReviseFlight_1.add(new JTextArea(destination.toString(),1,20));
        panel_ReviseFlight_1.add(new JLabel("Flight number:"));
        panel_ReviseFlight_1.add(new JTextArea(port.toString(),1,20));
        this.add(panel_ReviseFlight_1, BorderLayout.WEST);


		final JPanel panel = new JPanel();
        this.add(panel,BorderLayout.SOUTH);
        final RButton clearButton = new RButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Clear all the text in the text box.
            }
        });
        panel.add(clearButton);  

        final RButton confirmButton = new RButton("Confirm");
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //The input information is stored and passed through the arrylist.
            }
        });
        panel.add(confirmButton);

    }
}
