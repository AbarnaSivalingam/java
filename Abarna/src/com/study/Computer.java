package com.study;
public class Computer {
    // Required parameters
    private String CPU;
    private int RAM;          // in GB
    private int storage;      // in GB

    // Optional parameters
    private boolean graphicsCard;
    private boolean bluetoothEnabled;
    private String operatingSystem;

    // Private constructor: only Builder can create instances
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetoothEnabled = builder.bluetoothEnabled;
        this.operatingSystem = builder.operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB" +
               ", Graphics Card=" + (graphicsCard ? "Yes" : "No") +
               ", Bluetooth=" + (bluetoothEnabled ? "Yes" : "No") +
               ", OS=" + (operatingSystem != null ? operatingSystem : "None") + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private String CPU;
        private int RAM;
        private int storage;

        // Optional parameters - default values
        private boolean graphicsCard = false;
        private boolean bluetoothEnabled = false;
        private String operatingSystem = null;

        // Builder constructor with required params
        public Builder(String CPU, int RAM, int storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // Build method to create Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }

    // Main method to test the builder pattern
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", 8, 256)
                                    .build();

        // Build a gaming computer with graphics card and Bluetooth
        Computer gamingComputer = new Computer.Builder("Intel i9", 32, 1024)
                                     .setGraphicsCard(true)
                                     .setBluetoothEnabled(true)
                                     .setOperatingSystem("Windows 11")
                                     .build();

        // Build an office computer with OS but no graphics card
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", 16, 512)
                                    .setOperatingSystem("Ubuntu 20.04")
                                    .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}


