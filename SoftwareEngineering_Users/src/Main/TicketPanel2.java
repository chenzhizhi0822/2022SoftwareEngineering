package Main;

import javax.swing.*;
import java.awt.*;

public class TicketPanel2 extends JPanel{
    public TicketPanel2(String bookingID){
        int i = 0;
        while ( i < Sheet.getRowNum("../sheet/user.xls")-1 && !Sheet.getCell("../sheet/user.xls",i,0).equals(bookingID) ){
            i++;
        }
        String name1 = Sheet.getCell("../sheet/user.xls",i,1);
        String seat1 = Sheet.getCell("../sheet/user.xls",i,3);
        String taskID = Sheet.getCell("../sheet/user.xls",i,5);
        String carry1 = Sheet.getCell("../sheet/user.xls",i,6);
        String register1 = Sheet.getCell("../sheet/user.xls",i,7);

        int j = 0;
        while ( j < Sheet.getRowNum("../sheet/flight.xls")-1 && !Sheet.getCell("../sheet/flight.xls",j,0).equals(taskID) ){
            j++;
        }
        String from1 = Sheet.getCell("../sheet/flight.xls",j,4);
        String to1 = Sheet.getCell("../sheet/flight.xls",j,5);
        String flight1 = Sheet.getCell("../sheet/flight.xls",j,1);
        String date1 = Sheet.getCell("../sheet/flight.xls",j,2);

        JPanel panel3_1 = new LuggageVoucherPanel();
        JLabel name = new JLabel(name1);
        JLabel from = new JLabel(from1);
        JLabel to = new JLabel(to1);
        JLabel date = new JLabel(date1);
        JLabel flight = new JLabel(flight1);
        JLabel seat = new JLabel(seat1);
        JLabel numCarry = new JLabel(carry1);
        JLabel numReg = new JLabel(register1);
        RButton fin = new RButton("Finish");
        JLabel fron = new JLabel("Printing luggage voucher, please wait……");

        numCarry.setFont(new Font("Times New Roman",Font.BOLD,30));
        numReg.setFont(new Font("Times New Roman",Font.BOLD,30));
        fron.setFont(new Font("Times New Roman",Font.BOLD,30));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        panel3_1.setLayout(null);
        panel3_1.setPreferredSize(new Dimension(830,300));
        fin.setPreferredSize(new Dimension(300,50));

        name.setBounds(80,50,100,100);
        from.setBounds(80,110,100,100);
        to.setBounds(340,110,100,100);
        flight.setBounds(340,50,100,100);
        date.setBounds(80,165,100,100);
        seat.setBounds(340,165,100,100);
        numCarry.setBounds(630,75,100,100);
        numReg.setBounds(630,150,100,100);

        panel3_1.add(name);
        panel3_1.add(from);
        panel3_1.add(to);
        panel3_1.add(date);
        panel3_1.add(seat);
        panel3_1.add(flight);
        panel3_1.add(numCarry);
        panel3_1.add(numReg);

        this.add(fron);
        this.add(panel3_1);
        this.add(fin);
    }
}
