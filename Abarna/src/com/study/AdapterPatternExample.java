package com.study;
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1: PayPal Gateway with its own interface
class PayPalGateway {
    public void sendPayment(String email, double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal for account: " + email);
    }
}

// Adaptee 2: Stripe Gateway with its own interface
class StripeGateway {
    public void makePayment(double amountInCents) {
        System.out.println("Processing payment of $" + (amountInCents / 100.0) + " via Stripe");
    }
}

// Adapter for PayPalGateway implementing PaymentProcessor
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String email;

    public PayPalAdapter(PayPalGateway payPalGateway, String email) {
        this.payPalGateway = payPalGateway;
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        // Adapt the processPayment call to PayPal's sendPayment
        payPalGateway.sendPayment(email, amount);
    }
}

// Adapter for StripeGateway implementing PaymentProcessor
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Convert dollars to cents and call Stripe's makePayment
        stripeGateway.makePayment((int)(amount * 100));
    }
}

// Test class demonstrating adapter pattern usage
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create adaptees
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();

        // Create adapters
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal, "user@example.com");
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Use the PaymentProcessor interface to process payments regardless of gateway
        payPalProcessor.processPayment(100.00);  // PayPal payment of $100
        stripeProcessor.processPayment(250.50);  // Stripe payment of $250.50
    }
}


