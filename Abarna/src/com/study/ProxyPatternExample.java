package com.study;
interface Image {
    void display();
}

// RealSubject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
        // Simulate delay/loading time
        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + filename);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // lazy initialization
        } else {
            System.out.println("Using cached image: " + filename);
        }
        realImage.display();
    }
}

// Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // First time loading - will be slow
        image1.display();
        System.out.println();

        // Cached access - will be fast
        image1.display();
        System.out.println();

        // First time loading another image
        image2.display();
        System.out.println();

        // Cached access
        image2.display();
    }
}
