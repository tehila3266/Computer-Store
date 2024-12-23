package form;

import controller.Backend_DAO_List;
import model.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class AddNewCustomerForm extends JFrame
{
    private JButton jButtonOK;
    private JLabel  jLabelID;
    private JLabel  jLabelName;
    private JLabel  jLabelAddress;
    private JTextField    jTextFieldID;
    private JTextField   jTextFieldName;
    private JTextField   jTextFieldAddress;


    public  AddNewCustomerForm()
    {
        jButtonOK = new JButton("OK");
        jLabelID = new JLabel("ID:");
        jLabelName = new JLabel("Name:");
        jLabelAddress = new JLabel("Address:");
        jTextFieldID = new JTextField();
        jTextFieldName = new JTextField();
        jTextFieldAddress = new JTextField();

        this.add(jLabelID);
        this.add(jTextFieldID);
        this.add(jLabelName);
        this.add(jTextFieldName);
        this.add(jLabelAddress);
        this.add(jTextFieldAddress);
        this.add(jButtonOK);

        this.setPreferredSize(new Dimension(400, 200));
        getContentPane().setLayout(new GridLayout(0,2,10,10));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        this.jTextFieldID.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {

                if (!Character.isDigit(e.getKeyChar()) || AddNewCustomerForm.this.jTextFieldID.getText().length() > 9) {
                    e.consume();
                }

            }
        });


        jButtonOK.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    long id = Long.parseLong(AddNewCustomerForm.this.jTextFieldID.getText());

                    if (id == 0) {
                        throw new Exception("חובה להכניס id");
                    }

                    if (AddNewCustomerForm.this.jTextFieldName.getText().isEmpty()) {
                        throw new Exception("חובה למלא שם");
                    }
                    Backend_DAO_List daoList = Backend_DAO_List.getBackend_DAO_List();
                    for (long l:daoList.getAllCustomers().keySet())
                    {
                       if(l==id)
                           throw new Exception("הלקוח קיים");
                    }
                    Customer customer=new Customer();
                   customer.setId(id);
                    customer.setAddress(AddNewCustomerForm.this.jTextFieldAddress.getText());
                    customer.setName(AddNewCustomerForm.this.jTextFieldName.getText());
                    daoList.AddCustomer(customer);
                    JOptionPane.showMessageDialog((Component)null, "You have successfully registered ");
                    System.out.println(Backend_DAO_List.getBackend_DAO_List().getAllCustomers());


                    for (Customer c :
                            daoList.getAllCustomers().values()) {
                    }

                }

                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog((Component)null, ex.getMessage());
                    System.err.println(ex.getMessage());
                }
            }
        });

    }

    public static void main(String[] args)
    {
        AddNewCustomerForm form=new AddNewCustomerForm();
        form.setSize(300,300);
        form.setVisible(true);
    }
}

