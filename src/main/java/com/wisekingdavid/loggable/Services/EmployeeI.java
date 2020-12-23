package com.wisekingdavid.loggable.Services;

import com.wisekingdavid.loggable.Dto.EmployeeDto;
import com.wisekingdavid.loggable.Exceptions.ValidationException;

import java.util.List;
import java.util.UUID;

public interface EmployeeI {

    EmployeeDto addEmployee(EmployeeDto employee) throws ValidationException;
    EmployeeDto getById(UUID id) ;
    List<EmployeeDto> getAllEmployees();
    EmployeeDto update(EmployeeDto employee, UUID id);
    boolean delete(UUID id);

}
