import java.util.*;

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }
}

class Company {
    private String companyName;
    private Employee[] employees;
    private int numEmployees;

    public Company(String companyName, Employee[] employees, int numEmployees) {
        this.companyName = companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }

    public double getAverageSalary() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.getSalary();
        }
        return total / numEmployees;
    }

    public double getMaxSalary() {
        double maxSalary = 0;
        for (Employee emp : employees) {
            maxSalary = Math.max(maxSalary, emp.getSalary());
        }
        return maxSalary;
    }

    public Employee[] getEmployeesByDesignation(String designation) {
        List<Employee> list = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getDesignation().equalsIgnoreCase(designation)) {
                list.add(emp);
            }
        }
        return list.toArray(new Employee[0]);
    }
}

public class Company_Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        String companyName = sc.nextLine();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Employee[] empArr = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1) + ":");

            System.out.print("Enter id: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consume newline

            empArr[i] = new Employee(id, name, designation, salary);
        }

        Company company = new Company(companyName, empArr, n);

        System.out.printf("Average salary: %.1f\n", company.getAverageSalary());
        System.out.printf("Max salary: %.1f\n", company.getMaxSalary());

        System.out.print("Enter designation to filter employees: ");
        String searchDesignation = sc.nextLine();

        Employee[] filteredEmployees = company.getEmployeesByDesignation(searchDesignation);

        System.out.println("Employees with designation: " + searchDesignation);
        if (filteredEmployees.length == 0) {
            System.out.println("No employees found with this designation.");
        } else {
            for (Employee e : filteredEmployees) {
                System.out.printf("ID: %d, Name: %s, Designation: %s, Salary: %.1f\n",
                        e.getId(), e.getName(), e.getDesignation(), e.getSalary());
            }
        }
    }
}
