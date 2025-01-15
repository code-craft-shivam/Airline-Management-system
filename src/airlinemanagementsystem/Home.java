package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Home extends JFrame implements ActionListener {
    JButton reset,submit,close;
    JTextField textfield_username;
    JPasswordField textfield_password;


    public Home(){

        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading=new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500,20,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);

        
        
        JMenuItem flightDeatils=new JMenuItem("Flight Details");
        flightDeatils.addActionListener(this);
        details.add(flightDeatils);
        
        JMenuItem customerDeatils=new JMenuItem("Add Customer Details");
        customerDeatils.addActionListener(this);
        details.add(customerDeatils);
        
        JMenuItem bookFlight=new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails=new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        
        JMenuItem ticketCancellation=new JMenuItem("Ticket Cancellation");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket=new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        


    }

    public void actionPerformed(ActionEvent ae) {
        String text=ae.getActionCommand();
        if(text.equals("Flight Details")){
            new FlightInfo();
        }else if(text.equals("Add Customer Details")){
            new AddCustomer();
        }else if(text.equals("Book Flight")){
            new BookFlight();
        }else if(text.equals("Journey Details")){
            new JourneyDetails();
        }else if(text.equals("Ticket Cancellation")){
            new Cancel();}
        else if(text.equals("Boarding Pass")){
            new BoardingPass();}
        
    }

    public static void main(String[] args){
        new Home();
    }


}

