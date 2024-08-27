package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.Service.EmployeeService;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmployeeServiceTest {


    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test_saveEmployee(){

        Employee employee=new Employee(1,	"Ram",	"Sushanth",	"Ram@gmail.com");
        when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals(employee,employeeService.saveEmployee(employee));


    }

    @Test
    public void test_getEmployeeById(){

        Employee employee=new Employee(1,	"Ram",	"Sushanth",	"Ram@gmail.com");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        assertEquals("Ram@gmail.com",employeeService.getEmployeeById(1).getEmail());



    }

    @Test
    public void test_getAllEmployees(){


        List<Employee> employee= Arrays.asList(new Employee(1,	"Ram",	"Sushanth",	"Ram@gmail.com")
        , new Employee(2,	"Ram",	"Sushanth",	"Ra@gmail.com"));

        when(employeeRepository.findAll()).thenReturn(employee);
        assertEquals(2,employeeService.getAllEmployees().size());


    }

    @Test
    public void test_deleteEmployeeById(){

        Employee employee=new Employee(1,	"Ram",	"Sushanth",	"Ram@gmail.com");
        employeeService.deleteEmployeeById(employee.getId());
        verify(employeeRepository,times(1)).deleteById(1L);
    }



}
