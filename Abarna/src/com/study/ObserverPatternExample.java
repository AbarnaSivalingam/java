package com.study;
import java.util.*;

//Step 2: Subject Interface
interface Stock {
 void registerObserver(Observer o);
 void deregisterObserver(Observer o);
 void notifyObservers();
}

//Step 4: Observer Interface
interface Observer {
 void update(String stockSymbol, double price);
}

//Step 3: Concrete Subject
class StockMarket implements Stock {
 private List<Observer> observers = new ArrayList<>();
 private String stockSymbol;
 private double price;

 public void setStockPrice(String stockSymbol, double price) {
     this.stockSymbol = stockSymbol;
     this.price = price;
     System.out.println("Stock Updated: " + stockSymbol + " = $" + price);
     notifyObservers();
 }

 @Override
 public void registerObserver(Observer o) {
     observers.add(o);
     System.out.println("Observer registered: " + o.getClass().getSimpleName());
 }

 @Override
 public void deregisterObserver(Observer o) {
     observers.remove(o);
     System.out.println("Observer deregistered: " + o.getClass().getSimpleName());
 }

 @Override
 public void notifyObservers() {
     for (Observer observer : observers) {
         observer.update(stockSymbol, price);
     }
 }
}

//Step 5: Concrete Observers
class MobileApp implements Observer {
 private String appName;

 public MobileApp(String appName) {
     this.appName = appName;
 }

 @Override
 public void update(String stockSymbol, double price) {
     System.out.println(appName + " Mobile App - Stock: " + stockSymbol + " updated to $" + price);
 }
}

class WebApp implements Observer {
 private String appName;

 public WebApp(String appName) {
     this.appName = appName;
 }

 @Override
 public void update(String stockSymbol, double price) {
     System.out.println(appName + " Web App - Stock: " + stockSymbol + " updated to $" + price);
 }
}

//Step 6: Test Class
public class ObserverPatternExample {
 public static void main(String[] args) {
     StockMarket stockMarket = new StockMarket();

     Observer mobileApp = new MobileApp("InvestorPro");
     Observer webApp = new WebApp("StockWatch");

     stockMarket.registerObserver(mobileApp);
     stockMarket.registerObserver(webApp);

     System.out.println("\n-- First stock price update --");
     stockMarket.setStockPrice("AAPL", 172.85);

     System.out.println("\n-- Deregister Mobile App --");
     stockMarket.deregisterObserver(mobileApp);

     System.out.println("\n-- Second stock price update --");
     stockMarket.setStockPrice("GOOGL", 2890.30);
 }
}
