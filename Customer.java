
public class Customer {
    // INSTANCE VARIABLES
    private String name;
    private String city;
    private int customerId;
    private double totalSales;

    // CONSTRUCTOR
    public Customer(String name, String city, int customerId, double totalSales) {
        this.name = name;
        this.city = city;
        this.customerId = customerId;
        this.totalSales = totalSales;
    }

    // METHODS()
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    // TEST STRING
    @Override
    public String toString() {
        return "\nCustomer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", customerId=" + customerId +
                ", totalSales=" + totalSales +
                '}';
    }
}
