package entities;

public class OrderItem {

    private Integer quatity;
    private Double price;

    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quatity, Product product) {
        this.quatity = quatity;
        this.product = product;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal() {
        return product.getPrice()*quatity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName() + ", " + "$" + product.getPrice() + ", " + "Quantity: " + quatity + ", " + "$" + subTotal() + "\n");
        return sb.toString();
    }
}
