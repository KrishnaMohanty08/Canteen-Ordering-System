import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login implements ActionListener 
{
    JFrame jf;
    JLabel jl1, jl2, jl3;
    JTextField jt1;
    JButton b1;
    JPasswordField ps1;

    public login()
    {
        jf = new JFrame("LOGIN PAGE");

        jl1 = new JLabel("WELCOME, PLEASE ENTER YOUR CREDENTIALS");
        jl1.setBounds(50, 30, 400, 30);
        jf.add(jl1);

        jl2 = new JLabel("USERNAME");
        jl2.setBounds(80, 90, 100, 30);
        jf.add(jl2);

        jt1 = new JTextField();
        jt1.setBounds(200, 90, 180, 30);
        jf.add(jt1);

        jl3 = new JLabel("PASSWORD");
        jl3.setBounds(80, 140, 100, 30);
        jf.add(jl3);

        ps1 = new JPasswordField();
        ps1.setBounds(200, 140, 180, 30);
        jf.add(ps1);

        b1 = new JButton("SUBMIT");
        b1.setBounds(180, 200, 120, 35);
        b1.addActionListener(this);
        jf.add(b1);

        jf.setSize(500, 350);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        String un = jt1.getText();
        char pss[] = ps1.getPassword();
        String pass = String.valueOf(pss);
        Check c1 = new Check();
        String adm = c1.check(un, pass);
        if (un.isEmpty() || pass.isEmpty()) 
        {
            JOptionPane.showMessageDialog(jf, "Please enter both username and password.");
            return;
        }
        if (adm.equals("false"))
        {
            JOptionPane.showMessageDialog(jf, "INVALID CREDENTIALS");
        }
        else
        {
            Admin.name=adm;
            Admin.main(null);
        }
    }

    public static void main(String[] args) 
    {
        new login();
    }
}