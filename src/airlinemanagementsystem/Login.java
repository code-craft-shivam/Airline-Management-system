package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton reset,submit,close;
    JTextField textfield_username;
    JPasswordField textfield_password;


    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel label_username=new JLabel("Username");
        label_username.setBounds(20,20,100,20);
        add(label_username);

        textfield_username=new JTextField("Username");
        textfield_username.setBounds(130,20,200,20);
        textfield_username.setText("");
        add(textfield_username);

        JLabel label_password=new JLabel("Password");
        label_password.setBounds(20,50,100,20);
        add(label_password);

        textfield_password=new JPasswordField("password");
        textfield_password.setBounds(130,50,200,20);
        textfield_password.setText("");
        add(textfield_password);

        reset=new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);

        submit=new JButton("Submit");
        submit.setBounds(200,120,120,20);
        submit.addActionListener(this);
        add(submit);

        close=new JButton("Close");
        close.setBounds(100,160,120,20);
        close.addActionListener(this);
        add(close);


        setSize(400,250);
        setVisible(true);
        setLocation(600,250);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String username=textfield_username.getText();
            String password=textfield_password.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username ='"+username+"' and password='"+password+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    new Home();

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==reset){
            textfield_username.setText("");
            textfield_password.setText("");

        }
        else if(ae.getSource()==close){
            setVisible(false);
        }

    }



    public static void main(String[] args){
        new Login();
    }


}

