import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Admin implements ActionListener
{
    JFrame jf;
    JButton b1,b2,b3;
    JLabel l1,l2;
    static public String name="";
    public Admin()
    {
        jf=new JFrame("ADMIN PAGE");
        jf.setSize(400,300);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1=new JLabel("Welcome "+name.toUpperCase());
        l1.setBounds(50, 30, 400, 30);
        jf.add(l1);

        l2=new JLabel("What's in your mind today");
        l2.setBounds(50, 70, 400, 30);
        jf.add(l2);

        b1=new JButton("View Total Stock");
        b1.setBounds(70, 110, 150, 30);
        b1.addActionListener(this);
        jf.add(b1);

        b2=new JButton("Add new Item to the menu");
        b2.setBounds(70, 150, 250, 30);
        b2.addActionListener(this);
        jf.add(b2);
    
        b3=new JButton("Update the stock of existing items");
        b3.setBounds(70, 190, 250, 30);
        b3.addActionListener(this);
        jf.add(b3);
    }
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==b1)
        {
           sql s1=new sql();
           try
           {
            s1.readAll();
           }
           catch(Exception ex)
           {
            System.out.println(ex);
           }
        }
        if(e.getSource()==b2)
        {
            
        }
    }
    public static void main(String[] args) 
    {
        new Admin();
    }    
}
