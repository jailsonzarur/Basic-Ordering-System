package applications;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.next();
        String temp = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthdatetemp = sc.next();
        LocalDate birthdate = LocalDate.parse(birthdatetemp, fmt);
        Client client = new Client(name, email, birthdate);

        Order order = new Order(LocalDateTime.now(), OrderStatus.PROCESSING, client);

        System.out.println("Enter Order data: ");
        System.out.println("Status: " + order.getStatus());
        System.out.print("How many items to this order: ");
        Integer manyitems = sc.nextInt();
        for( int i = 1 ; i <= manyitems ; i++ ) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product Name: ");
            String productname = sc.next();
            System.out.print("Product Price: ");
            Double productprice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            Product product = new Product(productname, productprice);
            OrderItem item = new OrderItem(quantity, product);
            order.addItem(item);
        }

        System.out.println("\nORDER SUMMARY: ");
        System.out.println(order.toString());

    }
}
