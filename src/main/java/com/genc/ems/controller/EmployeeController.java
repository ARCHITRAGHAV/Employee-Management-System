package com.genc.ems.controller;

import com.genc.ems.entity.Employee;
import com.genc.ems.model.EmployeeAddRequest;
import com.genc.ems.model.EmployeeAddResponse;
import com.genc.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/check")
    public String check() {
        return "server is running";
    }

    @PostMapping("/add")
    public EmployeeAddResponse addEmployee(@RequestBody EmployeeAddRequest request) {
        return employeeService.addEmployee(request);
    }

    @GetMapping("/all")
    public List<EmployeeAddResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id/{id}")
    public EmployeeAddResponse getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/dept/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeService.getAllEmployeesOfDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody EmployeeAddRequest request, @PathVariable Long id) {
        return employeeService.updateEmployee(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
        return Map.of("status", "Employee has been deleted");
    }

    @DeleteMapping("delete/all")
    public Map<String, String> deleteAllEmployees() {
        employeeService.removeAllEmployees();
        return Map.of("status", "All employees are deleted");
    }
}