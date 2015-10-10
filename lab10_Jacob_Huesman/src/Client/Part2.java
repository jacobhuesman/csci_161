/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Employee.Employee;
import java.util.ArrayList;

/**
 * Client that will sort a sequence of items as specified in the part 2 of the assignment.
 * @author Jacob Huesman
 */
public class Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> emps = generateEmployees();
        
        /* Lab10 Part II */
        System.out.println("Lab10 Part II");
        
        /* Unsorted List */
        System.out.println("Unsorted List:");
        printEmps(emps);
        System.out.println("");
        
        /* Sort By Name */
        System.out.println("Sorted by Name:");
        printEmps(Employee.sortByName(emps));
        System.out.println("");
        
        /* Sort By Gender */
        System.out.println("Sorted by Gender:");
        emps = generateEmployees();
        printEmps(Employee.sortByGender(emps));
        System.out.println("");
        
        /* Sort By EmpID */
        System.out.println("Sorted by EmpID:");
        emps = generateEmployees();
        printEmps(Employee.sortByEmpID(emps));
        System.out.println("");
        
        /* Sort By Office */
        System.out.println("Sorted by Office:");
        emps = generateEmployees();
        printEmps(Employee.sortByOffice(emps));
        
    }
    
    /* Method to generate employees */
    private static ArrayList<Employee> generateEmployees(){
        ArrayList<Employee> emps = new ArrayList<>(10);
        emps.add(new Employee("Oliver", 'm', 1111, 111));
        emps.add(new Employee("Alicia", 'f', 2111, 161));
        emps.add(new Employee("Jaci",   'f', 1561, 112));
        emps.add(new Employee("Jay",    'm', 7161, 911));
        emps.add(new Employee("Sam",    'm', 8213, 541));
        emps.add(new Employee("Krista", 'f', 2811, 011));
        emps.add(new Employee("Mila",   'f', 7151, 179));
        emps.add(new Employee("Pratap", 'm', 3213, 781));
        emps.add(new Employee("Kevin",  'm', 4568, 843));
        emps.add(new Employee("Josh",   'm', 2258, 159));
        return emps;
    }
    
    /* Method to print the list of employees */
    private static void printEmps(ArrayList<Employee> emps){
        for(Employee emp : emps){
            System.out.println(emp.getName() + ", " + emp.getGender() + ", " + emp.getEmpID() + ", " + emp.getOffice());
        }
    }
    
}
