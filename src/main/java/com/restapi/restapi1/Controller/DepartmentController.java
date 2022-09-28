package com.restapi.restapi1.Controller;

import com.restapi.restapi1.entity.Department;
import com.restapi.restapi1.error.DepartmentNotFoundException;
import com.restapi.restapi1.service.DepartmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
     private  DepartmentServices departmentServices;

    private final Logger LOGGER=  LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department addDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside the addDepartment method of departmentController");
        return departmentServices.addDepartment(department);
    }
    @PostMapping("/departmentsAll")
    public String addAllDepartments(@Valid  @RequestBody List<Department> list){
        departmentServices.addAllDepartments(list);
        return ("All the departments added successfully");
    }


    @GetMapping("/departments")
    public List<Department> findAllDepartments(){
        LOGGER.info("Inside the findAllDepartments method of departmentController");

        return departmentServices.findAllDepartments();
    }

    @GetMapping("/departments/{Id}")
    public Department findDepartmentById(@PathVariable("Id") Long deptId) throws DepartmentNotFoundException {
        return departmentServices.findDepartmentById(deptId);
    }
    @DeleteMapping("/departments/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Long deptId) throws DepartmentNotFoundException {
        departmentServices.deleteDepartmentById(deptId);
        return "Department deleted successfully";
    }

    @DeleteMapping("/departmentsAll")
    public String deleteAllDepartments(){
        departmentServices.deleteAllDepartments();
        return "All the departments deleted successfully.";
    }

    @PutMapping("/departments/{Id}")
    public Department updateDepartment(@PathVariable("Id") Long deptId, @RequestBody Department department){
        return departmentServices.updateDepartment(deptId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return departmentServices.findDepartmentByName(departmentName);
    }

    @GetMapping("/departments/code/{code}")
    public Department findDepartmentByCode(@PathVariable("code") String departmentCode){
        return departmentServices.findDepartmentByCode(departmentCode);
    }
    @GetMapping("/departments/address/{address}")
    public Department findDepartmentByAddress(@PathVariable("address") String departmentAddress){
        return departmentServices.findDepartmentByAddress(departmentAddress);
    }



}
