package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private ArrayList<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double total = 0.0;
        for( OrderItem o : items ) {
            total += o.subTotal();
        }
        return total;
    }

    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Order momment: " + moment.format(fmt) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append("Client: " + client.getName() + " (" + client.getBirthDate().format(fmt2) + ") - " + client.getEmail() + "\n");
        sb.append("Order items: \n");
        for(OrderItem i : items) {
            sb.append(i.toString());
        }
        sb.append("Total: $" + total());
        return sb.toString();
    }
}
