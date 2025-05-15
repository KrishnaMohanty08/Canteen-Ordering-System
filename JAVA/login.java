
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login implements ActionListener 
{
    JFrame jf;
    JLabel jl1,jl2,jl3;
    JTextField jt1;
    JButton b1;
    JPasswordField ps1;
    public login()
    {
        jf=new JFrame("LOGIN PAGE");

        jl1=new JLabel("WELCOME , PLEASE ENTER YOUR CREDITIALS");
        jl1.setBounds(50, 50, 150, 75);
        jf.add(jl1);

        jl2=new JLabel("USERNAME");
        jl2.setBounds(50, 100, 100, 30);
        jf.add(jl2);
        
        jl3=new JLabel("PASSWORD");
        jl3.setBounds(50,150,100,30);
        jf.add(jl3);
        
        jt1=new JTextField();
        jt1.setBounds(200, 100, 100, 30);
        jt1.addActionListener(this);
        jf.add(jt1);
        
        ps1=new JPasswordField();
        ps1.setBounds(200, 150, 100, 30);
        ps1.addActionListener(this);
        jf.add(ps1);
        
        b1=new JButton("SUBMIT");
        b1.setBounds(200, 200, 100, 30);
        b1.addActionListener(this);
        jf.add(b1);
        
        jf.setSize(300, 300);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) 
    {
        String un=jt1.getText();
        char pss[]=ps1.getPassword();
        String pass=String.valueOf(pss);
        
    }
}
