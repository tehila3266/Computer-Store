package form;

import controller.Backend_DAO_List;
import model.Product;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controller.Backend_DAO_List.getBackend_DAO_List;


public class ManageCatalogForm
{
    public JPanel panel;
    private JButton מחיקתמוצרButton;
    private JButton הוספתמוצרחדשButton;
    private JList list1;
   // private DefaultListModel listModel ;
    private DefaultListModel AllProductListModel;

    public ManageCatalogForm()
    {
        AllProductListModel=new DefaultListModel();
        //listModel=new DefaultListModel();
        //listModel.addAll(getBackend_DAO_List().getAllProducts());
        list1.setModel(AllProductListModel);


        הוספתמוצרחדשButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                JFrame frame = new JFrame("AddNewProductForm");
                frame.setContentPane(new AddNewProductForm(ManageCatalogForm.this).panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        RefreshProductList();

        מחיקתמוצרButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }
        });
    }

    public void RefreshProductList()
    {
        try {

            AllProductListModel.clear();
            HashSet<Product> allProduct= Backend_DAO_List.getBackend_DAO_List().getAllProducts();
            for(Product p:allProduct)
            {
                AllProductListModel.addElement(p);
            }
        }
        catch (Exception ex)
        {
          //  Logger.getLogger(ManageCatalogForm.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("AddManageCatalogForm");
        frame.setContentPane(new ManageCatalogForm().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
