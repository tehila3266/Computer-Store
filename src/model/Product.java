package model;

public abstract class Product
{
    private  long id;
    private  String name;
    private String Description;
    private  float pricePerUnit;

    public Product(long id, String name, String description, float pricePerUnit) {
        this.id = id;
        this.name = name;
        Description = description;
        this.pricePerUnit = pricePerUnit;
    }
    public Product()
    {
        this.id = 0;
        this.name = null;
        Description = null;
        this.pricePerUnit = 0;
    }

    public abstract float getPrice();


    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
