package app;
import java.util.Scanner;
 interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;

    double calcTax();
}
class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }

    // Getters and setters (if needed)
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
 class Product implements Taxable {
     private int pid;
     private double price;
     private int quantity;

     public Product(int pid, double price, int quantity) {
         this.pid = pid;
         this.price = price;
         this.quantity = quantity;
     }

     @Override
     public double calcTax() {
         return price * SALES_TAX;
     }

     // Getters and setters (if needed)
     public int getPid() {
         return pid;
     }

     public void setPid(int pid) {
         this.pid = pid;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public int getQuantity() {
         return quantity;
     }

     public void setQuantity(int quantity) {
         this.quantity = quantity;
     }
 }

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept Employee information
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double empSalary = scanner.nextDouble();

        Employee employee = new Employee(empId, empName, empSalary);
        double incomeTax = employee.calcTax();
        System.out.println("Income Tax for " + empName + " is: " + incomeTax);

        //  Product information
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        double salesTax = product.calcTax();
        System.out.println("Sales Tax on product with ID " + pid + " is: " + salesTax);

        scanner.close();
    }
}

