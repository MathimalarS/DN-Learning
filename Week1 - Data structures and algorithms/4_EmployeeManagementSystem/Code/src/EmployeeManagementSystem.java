public class EmployeeManagementSystem {
    private Employee[] employees;
    private int employeeCount;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        employeeCount = 0;
    }

    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = employee;
            employeeCount++;
            System.out.println("Successfully added: " + employee);
        } else {
            System.out.println("Sorry, the employee list is full. Cannot add more.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees found in the system.");
            return;
        }

        System.out.println("\nCurrent Employees:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
    }

    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " was not found.");
            return;
        }

        for (int i = indexToDelete; i < employeeCount - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[employeeCount - 1] = null;
        employeeCount--;

        System.out.println("Employee with ID " + employeeId + " has been removed.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Management System!\n");

        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee(101, "Alice Johnson", "Developer", 75000));
        ems.addEmployee(new Employee(102, "Bob Smith", "Designer", 68000));
        ems.addEmployee(new Employee(103, "Charlie Brown", "Manager", 85000));

        ems.displayAllEmployees();

        int searchId = 102;
        System.out.println("Searching for employee with ID " + searchId + "...");
        Employee found = ems.searchEmployee(searchId);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("No employee found with ID " + searchId);
        }

        int deleteId = 101;
        System.out.println("\nDeleting employee with ID " + deleteId + "...");
        ems.deleteEmployee(deleteId);

        ems.displayAllEmployees();

        System.out.println("Thank you for using the Employee Management System!");
    }
}
