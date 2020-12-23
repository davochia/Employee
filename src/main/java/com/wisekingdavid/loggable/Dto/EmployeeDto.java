package com.wisekingdavid.loggable.Dto;

import com.wisekingdavid.loggable.Model.Employee;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID id;
    private String name;
    private int age;
    private String email;
    private int phone;

    public static Employee getEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());

        return employee;
    }

    public static EmployeeDto getEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhone(employee.getPhone());
        return employeeDto;
    }
}
