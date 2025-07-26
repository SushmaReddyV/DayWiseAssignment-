package defaultmethods;

interface Payment {
    void pay(double amount);
    default void logTransaction(double amount) {
        System.out.println("Transaction of Rs." + amount + " completed.");
    }
}

class PayPal implements Payment {
    public void pay(double amount) {
        System.out.println("Paid using PayPal");
        logTransaction(amount);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment p = new PayPal();
        p.pay(500.0);
    }
}