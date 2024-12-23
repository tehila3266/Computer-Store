package form;

import controller.Backend_DAO_List;
import model.E;
import model.HardwareProduct;
import model.Product;
import model.SoftwareProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewProductForm {
    public JPanel panel;
    private JButton addButton;
    private JComboBox cmbType;
    private JLabel productName;
    private JLabel description;
    private JLabel price;
    private JLabel varyable;
    private JTextField nameFiled;
    private JTextField descriptionFiled;
    private JTextField priceFiled;
    private JTextField varyableFiled;
    ManageCatalogForm manageCatalog;

    private DefaultComboBoxModel checkType = new DefaultComboBoxModel(E.values());

    public AddNewProductForm(ManageCatalogForm m)
    {
        manageCatalog = m;
        cmbType.setModel(checkType);
        cmbType.setSelectedIndex(0);


        cmbType.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
             if(isInHardwareMode())
                 varyable.setText("Warrenty Period");
            else
                    varyable.setText("Number of Users");
            }
        });
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try {
                    Product newProduct = null;
                    if (isInHardwareMode())
                    {
                      //   הקצאה לאובייקט מטיפוס hardware
                        newProduct =new HardwareProduct(1,nameFiled.getText(),descriptionFiled.getText(),(Float.parseFloat(priceFiled.getText())),(Integer.parseInt(varyableFiled.getText())));                //מילוי השדות של המוצר ע"י לקיחת הנתונים מתיבות הטקסט

                    }
                    else
                        newProduct =new SoftwareProduct(1,nameFiled.getText(),descriptionFiled.getText(),(Float.parseFloat(priceFiled.getText())),(Integer.parseInt(varyableFiled.getText())));                //מילוי השדות של המוצר ע"י לקיחת הנתונים מתיבות הטקסט
                    Backend_DAO_List.getBackend_DAO_List().AddProduct(newProduct);
                    //הוספת למערך המוצרים ע"י פונקצית ההוספה.

                    // הפעלת פונקצית רענון המוצרים:
                    manageCatalog.RefreshProductList();
                    JOptionPane.showMessageDialog((Component)null, "לקוח חדש התווסף בהצלחה ");
                }  catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
        });




}


    private boolean isInHardwareMode()
    {
      return (cmbType.getSelectedItem().equals(E.HARDWARE));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddNewProductForm");
        frame.setContentPane(new ManageCatalogForm().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

