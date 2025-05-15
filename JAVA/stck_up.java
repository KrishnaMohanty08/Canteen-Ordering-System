import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class stck_up implements ActionListener 
{
    JFrame jf;
    JLabel tf1,tf2;
    JTextField tf3;
    JButton b1, fin;
    int y = 150;
    ArrayList<JComboBox<String>> items;
    ArrayList<JTextField> quanFields;

    public stck_up() 
    {
        jf = new JFrame("MENU");
        tf1 = new JLabel("Welcome to the Canteen");
        tf1.setBounds(100, 50, 300, 40);
        jf.add(tf1);

        b1 = new JButton("Add Item");
        b1.setBounds(100, 100, 150, 30);
        jf.add(b1);

        tf2=new JLabel("Quantity");
        tf2.setBounds(300, 100, 150, 30);
        jf.add(tf2);

        items = new ArrayList<>();
        quanFields = new ArrayList<>();

        b1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JComboBox<String> jc1 = new JComboBox<>(new String[]{"B", "C", "F", "N"});
                jc1.setBounds(100, y, 150, 30);
                jf.add(jc1);
                items.add(jc1);

                JTextField quantityField = new JTextField();
                quantityField.setBounds(260, y, 100, 30);
                jf.add(quantityField);
                quanFields.add(quantityField);

                y += 50;
                jf.revalidate();
                jf.repaint();
            }
        });

        fin = new JButton("Finish");
        fin.setBounds(100, 450, 150, 30);
        fin.addActionListener(this);
        jf.add(fin);

        tf3 = new JTextField("Total Bill");
        tf3.setBounds(100, 500, 150, 30);
        jf.add(tf3);

        jf.setSize(500, 600);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
     {
        int sum = 0;
        for (int i = 0; i < items.size(); i++) 
        {
            int co = 0;
            String sl = (String) items.get(i).getSelectedItem();
            int q = 0;
            try 
            {
                q = Integer.parseInt(quanFields.get(i).getText());
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(jf, "Invalid quantity at item " + (i + 1));
                return;
            }
            switch (sl) 
            {
                case "B":
                    co = 50;
                    break;
                case "C":
                    co = 20;
                    break;
                case "F":
                    co = 80;
                    break;
                case "N":
                    co = 67;
                    break;
                default:
                    throw new AssertionError();
            }
            sum += co * q;
        }
        String bill = String.valueOf(sum);
        tf3.setText(bill);
    }

    public static void main(String[] args) 
    {
        new stck_up();
    }
}