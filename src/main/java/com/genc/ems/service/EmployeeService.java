package com.genc.ems.service;

import com.genc.ems.entity.Employee;
import com.genc.ems.model.EmployeeAddRequest;
import com.genc.ems.model.EmployeeAddResponse;
import com.genc.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeAddResponse addEmployee(EmployeeAddRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee storedEmployee = employeeRepository.save(employee); //we pass entity class object inside it

        return new EmployeeAddResponse(storedEmployee.getId(), storedEmployee.getName());
    }

    public List<EmployeeAddResponse> getAllEmployees() {

        List<Employee> dbEmployees = employeeRepository.findAll();
        List<EmployeeAddResponse> employees = new ArrayList<>();

        for (Employee e : dbEmployees) {
            EmployeeAddResponse ear = new EmployeeAddResponse();
            ear.setId(e.getId());
            ear.setName(e.getName());

            employees.add(ear);
        }
        return employees;
    }

    public EmployeeAddResponse getEmployee(Long id) {
        if (id == null) {
            return null;
        }
        Employee dbEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
        return new EmployeeAddResponse(dbEmployee.getId(), dbEmployee.getName());
    }

    public List<Employee> getAllEmployeesOfDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public Employee updateEmployee(EmployeeAddRequest request, Long id) {
        if (id == null || request == null) {
            return null;
        }
        Employee dbEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
        if (request.getName() != null) {
            dbEmployee.setName(request.getName());
        }
        if (request.getDepartment() != null) {
            dbEmployee.setDepartment(request.getDepartment());
        }
        if (request.getSalary() != null) {
            dbEmployee.setSalary(request.getSalary());
        }

        return employeeRepository.save(dbEmployee);
    }

    public void removeEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void removeAllEmployees() {
        employeeRepository.deleteAll();
    }
}