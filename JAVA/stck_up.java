import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class stck_up implements ActionListener 
{
    JFrame jf;
    JLabel tf1,tf2,tf3,tf4;
    JButton b1,fin;
    JComboBox<String> jc1;
    int y = 150;
    ArrayList<JComboBox<String>> items;
    ArrayList<JTextField> quan=new ArrayList<>();
    ArrayList<JTextField> cost=new ArrayList<>();
    ArrayList<JTextField> prodID=new ArrayList<>();
    ArrayList<String> stck1=new ArrayList<>();
    

    public stck_up() 
    {
        jf = new JFrame("UPDATE EXISTING STOCK");

        stck1.add("B");
        stck1.add("C");
        stck1.add("F");
        stck1.add("N");

        b1 = new JButton("Add Item");
        b1.setBounds(100, 50, 150, 30);
        jf.add(b1);

        tf4=new JLabel("Name");
        tf4.setBounds(100, 100, 100, 30);
        jf.add(tf4);

        tf1=new JLabel("ProdID");
        tf1.setBounds(200, 100, 100, 30);
        jf.add(tf1);

        tf2=new JLabel("Cost");
        tf2.setBounds(300, 100, 100, 30);
        jf.add(tf2);

        tf3=new JLabel("Quantity");
        tf3.setBounds(400, 100, 100, 30);
        jf.add(tf3);

        items = new ArrayList<>();
        quan = new ArrayList<>();

        b1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                jc1 = new JComboBox<>(stck1.toArray(new String[0]));
                jc1.setBounds(40+35, y, 80, 30);
                jf.add(jc1);
                items.add(jc1);

                //For taking Prod ID input
                JTextField pid=new JTextField();
                pid.setBounds(170+20, y, 80, 30);
                jf.add(pid);
                prodID.add(pid);

                //For Taking Cost Input
                JTextField ct=new JTextField();
                ct.setBounds(270+20, y, 80, 30);
                jf.add(ct);
                cost.add(ct);

                //For Taking Quantity input
                JTextField quantityField = new JTextField();
                quantityField.setBounds(370+20, y, 80, 30);
                jf.add(quantityField);
                quan.add(quantityField);


                y += 50;
                jf.revalidate();
                jf.repaint();
            }
        });

        fin = new JButton("Update");
        fin.setBounds(100, 450, 150, 30);
        fin.addActionListener(this);
        jf.add(fin);

        jf.setSize(600, 600);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
     {
        sql s1=new sql();
        int sum = 0;
        for (int i = 0; i < items.size(); i++) 
        {
            int co = 0;
            String sl = (String) items.get(i).getSelectedItem();
            String proID=prodID.get(i).getText();
            String cot=cost.get(i).getText();
            String qnt=quan.get(i).getText();
            int q = 0,c=0,p=0;
            if(proID.isEmpty()||cot.isEmpty()||qnt.isEmpty())
            {
                JOptionPane.showMessageDialog(jf, "Please fill all the areas");
            }
            else
            {
                try
                {
                    p= Integer.parseInt(proID);
                }
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(jf, "Invalid PID at item " + (i + 1));
                    return;
                }
                try
                {
                    c= Integer.parseInt(cot);
                }
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(jf, "Invalid cost at item " + (i + 1));
                    return;
                }
                try 
                {
                    q = Integer.parseInt(qnt);
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(jf, "Invalid quantity at item " + (i + 1));
                    return;
                }
                try
                {
                     s1.update(p, sl, co, q);
                }
                catch(Exception ex1)
                {
                    JOptionPane.showMessageDialog(jf, "Error adding item.");
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        new stck_up();
    }
}