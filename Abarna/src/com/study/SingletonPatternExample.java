package com.study;
public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {
        // Private static instance of Logger (eager initialization)
        private static Logger instance = null;

        // Private constructor to prevent instantiation
        private Logger() {
            System.out.println("Logger initialized.");
        }

        // Public method to return the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main class to test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("User logged in.");

        // Verifying that both logger1 and logger2 refer to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton works!");
        } else {
            System.out.println("Different instances. Singleton failed!");
        }
    }
}



