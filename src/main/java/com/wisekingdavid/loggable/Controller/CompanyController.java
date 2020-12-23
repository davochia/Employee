package com.wisekingdavid.loggable.Controller;

import com.wisekingdavid.loggable.Dto.EmployeeDto;
import com.wisekingdavid.loggable.Exceptions.ValidationException;
import com.wisekingdavid.loggable.Services.EmployeeI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CompanyController {

    //Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private EmployeeI employeeI;

    @GetMapping("employee/{id}")
    public EmployeeDto getEmployee(@PathVariable UUID id)  {
         EmployeeDto employee = employeeI.getById(id);
        if (employee ==null) {
            //logger.error("Employee with id: " + id + "not found");
            return null;

        } else{
            return employee;
        }
    }

    @GetMapping("employees")
    public List<EmployeeDto> getEmployees()   {
        return employeeI.getAllEmployees();
    }

    @PostMapping("employee")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employee) throws ValidationException {
        return employeeI.addEmployee(employee);
    }


    @DeleteMapping("employee/{id}")
    public boolean deleteEmployee(@PathVariable UUID id) {
        return employeeI.delete(id);
    }


    @PutMapping("employee/{id}")
    public EmployeeDto updateEmployee(@PathVariable UUID id, @RequestBody EmployeeDto employee) {
        return employeeI.update(employee, id);
    }


}
