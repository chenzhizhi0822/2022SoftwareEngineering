package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ManageRevise_Seat extends JPanel{
    public MyFrame mainpanel;
    public ManageRevise_Seat(MyFrame mainpanel){//无参数构造器 （添加）
        this.mainpanel=mainpanel;
        this.setBounds(198,82,989,582);
	    this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setLayout(new BorderLayout());

        JLabel titleJLabel = new JLabel("Revise Page(seat)", JLabel.CENTER);//Let the JLabel be in the center.
        Font fnt = new Font("Arial", Font.BOLD, 38);
        titleJLabel.setFont(fnt);//Set the font in the JLabel.
        titleJLabel.setPreferredSize(new Dimension(989, 100));
        this.add(titleJLabel, BorderLayout.NORTH);

        JPanel panel_ReviseSeat_1 = new JPanel(null);
        //冗余，封装成函数
        ImageIcon seatStateIcon = new ImageIcon("SoftwareEgineering_manage/src/res/a-icon_chooseseat.png");
        seatStateIcon.setImage(seatStateIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel seatStateIconLabel = new JLabel(seatStateIcon);
        seatStateIconLabel.setBounds(170, 0, 50, 50);
        panel_ReviseSeat_1.add(seatStateIconLabel);
        JLabel seatStateJTextLabel = new JLabel("Seat state:");
        seatStateJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseSeat_1.add(seatStateJTextLabel);
        JTextArea seatStateJTextArea = new JTextArea(1,30);
        seatStateJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseSeat_1.add(seatStateJTextArea);
        JLabel starJLabel1 = new JLabel("*");
        starJLabel1.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel1.setForeground(Color.RED);
        panel_ReviseSeat_1.add(starJLabel1);
        seatStateJTextLabel.setBounds(270,0,200,40);
        seatStateJTextArea.setBounds(450,0,200,30);
        starJLabel1.setBounds(650,0,40,40);

        ImageIcon passengerNameIcon = new ImageIcon("SoftwareEgineering_manage/src/res/peoplelist.png");
        passengerNameIcon.setImage(passengerNameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel passengerNameIconLabel = new JLabel(passengerNameIcon);
        passengerNameIconLabel.setBounds(170, 90, 50, 50);
        panel_ReviseSeat_1.add(passengerNameIconLabel);
        JLabel passengerNameJTextLabel = new JLabel("Passenger name:");
        passengerNameJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseSeat_1.add(passengerNameJTextLabel);
        JTextArea passengerNameJTextArea = new JTextArea(1,30);
        passengerNameJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseSeat_1.add(passengerNameJTextArea);
        JLabel starJLabel2 = new JLabel("*");
        starJLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel2.setForeground(Color.RED);
        panel_ReviseSeat_1.add(starJLabel2);
        passengerNameJTextLabel.setBounds(230,95,250,40);
        passengerNameJTextArea.setBounds(450,100,200,30);
        starJLabel2.setBounds(650,100,40,40);

        ImageIcon passengerIdIcon = new ImageIcon("SoftwareEgineering_manage/src/res/user-fill.png");
        passengerIdIcon.setImage(passengerIdIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel passengerIdIconLabel = new JLabel(passengerIdIcon);
        passengerIdIconLabel.setBounds(170, 190, 50, 50);
        panel_ReviseSeat_1.add(passengerIdIconLabel);
        JLabel passengerIdJTextLabel = new JLabel("Passenger ID:");
        passengerIdJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseSeat_1.add(passengerIdJTextLabel);
        JTextArea passengerIdJTextArea = new JTextArea(1,30);
        passengerIdJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseSeat_1.add(passengerIdJTextArea);
        JLabel starJLabel3 = new JLabel("*");
        starJLabel3.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel3.setForeground(Color.RED);
        panel_ReviseSeat_1.add(starJLabel3);
        passengerIdJTextLabel.setBounds(250,200,200,40);
        passengerIdJTextArea.setBounds(450,200,200,30);
        starJLabel3.setBounds(650,200,40,40);

        ImageIcon luggageIdIcon = new ImageIcon("SoftwareEgineering_manage/src/res/flighticonluggagepsd.png");
        luggageIdIcon.setImage(luggageIdIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel luggageIdIconLabel = new JLabel(luggageIdIcon);
        luggageIdIconLabel.setBounds(170, 300, 50, 50);
        panel_ReviseSeat_1.add(luggageIdIconLabel);
        JLabel luggageStateJTextLabel = new JLabel("Luggage state:");
        luggageStateJTextLabel.setFont(new Font("Arial", Font.BOLD, 25));//Set the font in the JLabel.
        panel_ReviseSeat_1.add(luggageStateJTextLabel);
        JTextArea luggageStateJTextArea = new JTextArea(1,30);
        luggageStateJTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel_ReviseSeat_1.add(luggageStateJTextArea);
        JLabel starJLabel4 = new JLabel("*");
        starJLabel4.setFont(new Font("Arial", Font.BOLD, 40));
        starJLabel4.setForeground(Color.RED);
        panel_ReviseSeat_1.add(starJLabel4);
        luggageStateJTextLabel.setBounds(250,300,200,40);
        luggageStateJTextArea.setBounds(450,300,200,30);
        starJLabel4.setBounds(650,300,200,30);

        this.add(panel_ReviseSeat_1, BorderLayout.CENTER);

        //检测文本是否为空，空则提示！
        seatStateJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (seatStateJTextArea.getText().equals("")==false)
                    starJLabel1.setVisible(false);
                else 
                    starJLabel1.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (seatStateJTextArea.getText().equals("")==false)
                    starJLabel1.setVisible(false);
                else 
                    starJLabel1.setVisible(true);
            }
        });
        passengerNameJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (passengerNameJTextArea.getText().equals("")==false)
                    starJLabel2.setVisible(false);
                else 
                    starJLabel2.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (passengerNameJTextArea.getText().equals("")==false)
                    starJLabel2.setVisible(false);
                else 
                    starJLabel2.setVisible(true);
            }
        });
        passengerIdJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (passengerIdJTextArea.getText().equals("")==false)
                    starJLabel3.setVisible(false);
                else 
                    starJLabel3.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (passengerIdJTextArea.getText().equals("")==false)
                    starJLabel3.setVisible(false);
                else 
                    starJLabel3.setVisible(true);
            }
        });
        luggageStateJTextArea.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (luggageStateJTextArea.getText().equals("")==false)
                    starJLabel4.setVisible(false);
                else 
                    starJLabel4.setVisible(true);
            }
            public void focusLost(FocusEvent e){
                if (luggageStateJTextArea.getText().equals("")==false)
                    starJLabel4.setVisible(false);
                else 
                    starJLabel4.setVisible(true);
            }
        });

		final JPanel panel = new JPanel();
        this.add(panel,BorderLayout.SOUTH);
        final RButton clearButton = new RButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Clear all the text in the text box.
                seatStateJTextArea.setText("");
                passengerNameJTextArea.setText("");
                passengerIdJTextArea.setText("");
                luggageStateJTextArea.setText("");
                starJLabel1.setVisible(true);
                starJLabel2.setVisible(true);
                starJLabel3.setVisible(true);
                starJLabel4.setVisible(true);
            }
        });
        panel.add(clearButton);

        final RButton confirmButton = new RButton("Add new flight");
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //The input information is stored and passed through the arrylist.
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(seatStateJTextArea.getText());
                strings.add(passengerNameJTextArea.getText());
                strings.add(passengerIdJTextArea.getText());
                strings.add(luggageStateJTextArea.getText());
                if(seatStateJTextArea.getText().equals("")|| 
                passengerNameJTextArea.getText().equals("") ||
                passengerIdJTextArea.getText().equals("") || 
                luggageStateJTextArea.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please fill in the missing information", null, JOptionPane.WARNING_MESSAGE);
                // If no JTextArea is empty, then pass data to anothor frame.
                else{
                    int a = JOptionPane.showConfirmDialog(null, "Have you checked all the information is correct? You can't change the information once the information is submitted", "Confirm check in?", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        mainpanel.selectView(3);
                    }
                }
            }
        });
        panel.add(confirmButton);

    }
}
