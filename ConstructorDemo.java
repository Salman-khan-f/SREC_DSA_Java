class Car {
    // Instance variables
    private String model;
    private int year;
    private double price;
    private static int carCount = 0; // Shared across all objects
    
    // Instance Initialization Block (runs before constructor)
    {
        System.out.println("Car is being created...");
        carCount++;
    }
    
    // Default Constructor
    public Car() {
        this("Unknown", 2025, 0.0); // Calls parameterized constructor
        System.out.println("Default constructor called");
    }
    
    // Parameterized Constructor
    public Car(String model, int year, double price) {
        this.model = model;   // 'this' refers to current object
        this.year = year;
        this.price = price;
        System.out.println("Car created: " + model);
    }
    
    // Method demonstrating 'this' keyword
    public void updatePrice(double price) {
        this.price = price; // Distinguishes parameter from instance variable
    }
    
    public void displayInfo() {
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Price: $" + this.price);
        System.out.println("Total cars created: " + carCount);
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;
    
    public ElectricCar(String model, int year, double price, int battery) {
        super(model, year, price); // Calls parent constructor
        this.batteryCapacity = battery;
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car1 = new Car();

        // car1.carCount;

        Car car2 = new Car("Tesla Model 3", 2024, 45000);
        ElectricCar eCar = new ElectricCar("Tesla Model S", 2024, 95000, 100);
        
        car2.displayInfo();
    }
}
