package com.tracker.employee.controller;

import java.util.List;

import com.tracker.employee.entity.Employee;
import com.tracker.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        final List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "list-employees";
    }

}
