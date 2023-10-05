package controllers;

import java.util.ArrayList;

import models.Employee;
import models.EmployeeData;
import views.MainConsole;

public class MainController {
    public MainController(){
        ArrayList<Employee> empList = new EmployeeData().getEmployees();
        MainConsole.printEmployees(empList);
    }
}
