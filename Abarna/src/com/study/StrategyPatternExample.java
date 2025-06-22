package com.study;
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Concrete Strategies

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
        System.out.println("Card Holder: " + cardHolderName);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
        System.out.println("PayPal Account: " + email);
    }
}

// Step 4: Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(double amount) {
        if (strategy == null) {
            System.out.println("Payment strategy not set.");
        } else {
            strategy.pay(amount);
        }
    }
}

// Step 5: Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card Payment
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "Alice Johnson", "123");
        context.setPaymentStrategy(creditCard);
        context.payAmount(150.75);

        System.out.println();

        // Use PayPal Payment
        PaymentStrategy paypal = new PayPalPayment("alice@example.com", "securepassword");
        context.setPaymentStrategy(paypal);
        context.payAmount(89.99);
    }
}
