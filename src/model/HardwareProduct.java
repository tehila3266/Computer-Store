package model;

public class HardwareProduct extends Product
{
    private int WarrantyPeriod;



    public int getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        WarrantyPeriod = warrantyPeriod;
    }

    public HardwareProduct(long id, String name, String description, float pricePerUnit, int warrantyPeriod) {
        super(id, name, description, pricePerUnit);
        WarrantyPeriod = warrantyPeriod;
    }

    public HardwareProduct(int warrantyPeriod) {
        WarrantyPeriod = warrantyPeriod;
    }

    @Override
    public float getPrice()
    {
      return   WarrantyPeriod + getPricePerUnit();
    }



}
