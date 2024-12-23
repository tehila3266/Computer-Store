package model;

public class SoftwareProduct extends Product
{
   private int NumberOfUsers;

    public SoftwareProduct(long id, String name, String description, float pricePerUnit, int numberOfUsers) {
        super(id, name, description, pricePerUnit);
        NumberOfUsers = numberOfUsers;
    }

    public SoftwareProduct(int numberOfUsers) {
        NumberOfUsers = numberOfUsers;
    }

    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        NumberOfUsers = numberOfUsers;
    }


    @Override
    public float getPrice()
    {
        return   NumberOfUsers + getPricePerUnit();
    }


}
