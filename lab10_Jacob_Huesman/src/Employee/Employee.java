/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Sort.Sort;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Barebones Employee class. Methods are fairly self explanatory.
 * @author Jacob Huesman
 */
public class Employee {
    /* Instance Variables */
    private String name;
    private char gender;
    private int empID, office;
    
    /* Constructors */
    public Employee(String name, char gender, int empID, int office){
        this.name = name;
        this.gender = gender;
        this.empID = empID;
        this.office = office;
    }
    
    /* Accessor Methods */
    public String getName(){ return name; }
    public char getGender(){ return gender; }
    public int getEmpID(){ return empID; }
    public int getOffice(){ return office; }
    
    /* Mutator Methods */
    public void setName(String name){ this.name = name; }
    public void setGender(char gender){ this.gender = gender; }
    public void setEmpID(int empID){ this.empID = empID; }
    public void setOffice(int office){ this.office = office; }
    
    /* Sorting Methods */
    public static ArrayList<Employee> sortByName(ArrayList<Employee> emps){
        return sort(emps, new CompareName());
    }
    
    public static ArrayList<Employee> sortByGender(ArrayList<Employee> emps){
        return sort(emps, new CompareGender());
    }
    
    public static ArrayList<Employee> sortByEmpID(ArrayList<Employee> emps){
        return sort(emps, new CompareEmpID());
    }
    
    public static ArrayList<Employee> sortByOffice(ArrayList<Employee> emps){
        return sort(emps, new CompareOffice());
    }
    
    /* General sorting method to sort based on given comparator */
    private static ArrayList<Employee> sort(ArrayList<Employee> emps, Comparator comp){
        Employee[] array = new Employee[emps.size()];
        emps.toArray(array);
        Sort.bubbleSort(array, comp);
        ArrayList<Employee> list = new ArrayList<>(emps.size());
        for(int i=0; i<emps.size(); i++){
            list.add(array[i]);
        }
        return list;
    }
    
    /* Comparators */
    private static class CompareName implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    
    private static class CompareGender implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getGender() - o2.getGender();
        }
    }
    
    private static class CompareEmpID implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getEmpID() - o2.getEmpID();
        }
    }
    
    private static class CompareOffice implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getOffice() - o2.getOffice();
        }
    }
}
