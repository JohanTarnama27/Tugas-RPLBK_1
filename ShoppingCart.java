import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        // Daftar barang yang tersedia
        Item[] availableItems = {
            new Item("Laptop", 15000000),
            new Item("Mouse", 200000),
            new Item("Keyboard", 350000)
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Items:");
        for (int i = 0; i < availableItems.length; i++) {
            System.out.println((i + 1) + ". " + availableItems[i].getName() + " - " + availableItems[i].getFormattedPrice());
        }

        System.out.println("How many items would you like to add to your cart?");
        int itemCount = scanner.nextInt();
        Item[] cart = new Item[itemCount];

        // Memilih barang dari daftar
        for (int i = 0; i < itemCount; i++) {
            System.out.println("Select item " + (i + 1) + " by number (1-" + availableItems.length + "): ");
            int itemChoice = scanner.nextInt() - 1;
            cart[i] = availableItems[itemChoice];
        }

        // Diskon 10%
        double discountRate = 0.10;
        double totalPrice = calculateTotalPrice(cart);
        double discountedPrice = applyDiscount(totalPrice, discountRate);

        // Format ke mata uang Rupiah
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println("Total Price: " + rupiahFormat.format(totalPrice));
        System.out.println("Price after Discount: " + rupiahFormat.format(discountedPrice));
    }

    // Menghitung total harga barang di keranjang
    private static double calculateTotalPrice(Item[] items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Menerapkan diskon ke total harga
    private static double applyDiscount(double price, double discountRate) {
        return price - (price * discountRate);
    }
}

// Representasi barang di keranjang belanja
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFormattedPrice() {
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return rupiahFormat.format(price);
    }
}
