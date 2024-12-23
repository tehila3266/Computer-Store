package controller;

import model.*;

import java.util.*;

public class Backend_DAO_List implements Backend
{
    private Map<Long, Customer> Customers;
    private Set<Product> Products;
    private List<PurchaseOrder> PurchaseOrders;

    private static Backend_DAO_List singleton;
    public static Backend_DAO_List getBackend_DAO_List()
    {
        if(singleton==null)
            singleton=new Backend_DAO_List();
        return singleton;
    }

    private Backend_DAO_List()
    {
        Customers = new HashMap< >();
        Products = new HashSet< >();
        PurchaseOrders = new ArrayList< >();

        Products.add(new HardwareProduct(123,"computer","small",3400,455));
        Products.add(new SoftwareProduct(123,"computer","small",3400,455));
    }

    @Override
    public void AddCustomer(Customer c) throws Exception {
            Customers.put(c.getId(),c);
    }

    @Override
    public void AddProduct(Product c) throws Exception {
     Products.add(c);
    }

    @Override
    public HashMap<Long, Customer> getAllCustomers() throws Exception {
        return (HashMap<Long, Customer>) Customers;
    }

    @Override
    public HashSet<Product> getAllProducts() throws Exception {
      return (HashSet<Product>) Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {
        PurchaseOrders.add(po);
    }

    @Override
    public void RemoveProduct(Product c) throws Exception {
    Products.remove(c);
    }

    @Override
    public ArrayList<Product> getCustomersOrders(Customer c) throws Exception {
        ArrayList<Product> ret = new ArrayList<Product>();//מחזיר רשימת מוצרים של לקוח
        Iterator<PurchaseOrder> iter = PurchaseOrders.iterator();

        while(iter.hasNext())
        {
           PurchaseOrder next =iter.next();
            if(next.getOrderingCustomer().getId()==c.getId())
            {

                Iterator<Product> iterProduct = next.getProductsList().iterator();
                while (iterProduct.hasNext())
                {
                    ret.add((iterProduct.next()));
                }
            }
        }
        return ret;
    }
    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception
    {
        float sum=0;
        for (Product item:products)
        {
         sum+=item.getPrice();
        }
        return  sum;
    }
}
