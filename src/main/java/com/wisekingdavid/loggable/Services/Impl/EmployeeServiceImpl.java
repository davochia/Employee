package com.wisekingdavid.loggable.Services.Impl;


import com.wisekingdavid.loggable.Dto.EmployeeDto;
import com.wisekingdavid.loggable.Model.Employee;
import com.wisekingdavid.loggable.Repository.EmployeeRepository;
import com.wisekingdavid.loggable.Services.EmployeeI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeI {

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        if(employeeDto == null ) return null;
        Employee employee = EmployeeDto.getEmployee(employeeDto);
        return employeeDto.getEmployeeDto(employeeRepository.save(employee));
    }


    @Override
    public EmployeeDto getById(UUID id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee == null){
            return null;
        }
        return EmployeeDto.getEmployeeDto(optionalEmployee.get());
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employees.forEach( employee -> employeeDtos.add(EmployeeDto.getEmployeeDto(employee)));
        return employeeDtos;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, UUID id) {
        Employee employee = EmployeeDto.getEmployee(employeeDto);
        return  EmployeeDto.getEmployeeDto( employeeRepository.save(employee));
    }

    @Override
    public boolean delete(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.delete(employee.get());
        return true;
    }
}
