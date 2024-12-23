package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagerGUIViewForm {
    private JPanel panel;
    private JButton צפיהבהזמנותButton;
    private JButton הוספתלקוחButton;
    private JButton מוצריםButton;
    private JButton ביצועהזמנהButton;

    public StoreManagerGUIViewForm() {
        הוספתלקוחButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              new AddNewCustomerForm().setVisible(true);
            }
        });

        מוצריםButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame("ManagerGUIViewForm");
                frame.setContentPane(new ManageCatalogForm().panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StoreManagerGUIViewForm");
        frame.setContentPane(new StoreManagerGUIViewForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
