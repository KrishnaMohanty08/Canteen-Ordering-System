import java.awt.event.ActionListener;
import javax.swing.*;

public class Update implements ActionListener
{
    JFrame jf;
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2, tf3, tf4;
    JButton b1;

    public Update() 
    {
        jf = new JFrame("Update the Existing Item");
        jf.setSize(350, 300);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int labelX = 30, fieldX = 130, width = 80, height = 25, gap = 40, startY = 30;

        l1 = new JLabel("Name");
        l1.setBounds(labelX, startY, width, height);
        jf.add(l1);

        tf1 = new JTextField();
        tf1.setBounds(fieldX, startY, 150, height);
        jf.add(tf1);

        l2 = new JLabel("Product Id");
        l2.setBounds(labelX, startY + gap, width, height);
        jf.add(l2);

        tf2 = new JTextField();
        tf2.setBounds(fieldX, startY + gap, 150, height);
        jf.add(tf2);

        l3 = new JLabel("Cost");
        l3.setBounds(labelX, startY + 2 * gap, width, height);
        jf.add(l3);

        tf3 = new JTextField();
        tf3.setBounds(fieldX, startY + 2 * gap, 150, height);
        jf.add(tf3);

        l4 = new JLabel("Quantity");
        l4.setBounds(labelX, startY + 3 * gap, width, height);
        jf.add(l4);

        tf4 = new JTextField();
        tf4.setBounds(fieldX, startY + 3 * gap, 150, height);
        jf.add(tf4);

        b1 = new JButton("Submit Item");
        b1.setBounds(fieldX, startY + 4 * gap, 100, height);
        b1.addActionListener(this);
        jf.add(b1);

        jf.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) 
    {
        String name = tf1.getText();
        String p = tf2.getText();
        String c = tf3.getText();
        String q = tf4.getText();
        int pid = 0, cost = 0, quan = 0;
        boolean valid = true;

        if (name.isEmpty() || p.isEmpty() || c.isEmpty() || q.isEmpty()) 
        {
            JOptionPane.showMessageDialog(jf, "Please enter all fields");
            valid = false;
        }
        else
        {
            try 
            {
                pid = Integer.parseInt(p);
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(jf, "Invalid Product Id");
                valid = false;
            }
            try 
            {
                cost = Integer.parseInt(c);
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(jf, "Invalid Cost");
                valid = false;
            }
            try 
            {
                quan = Integer.parseInt(q);
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(jf, "Invalid Quantity");
                valid = false;
            }

            if (e.getSource() == b1 && valid) 
            {
                sql s1 = new sql();
                try 
                {
                    s1.add(pid, name, cost, quan);
                    JOptionPane.showMessageDialog(jf, "Item added successfully!");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                } 
                catch (Exception e1) 
                {
                    JOptionPane.showMessageDialog(jf, "Error adding item.");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Update();
    }
}