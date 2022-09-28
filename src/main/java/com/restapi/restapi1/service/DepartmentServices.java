package com.restapi.restapi1.service;

import com.restapi.restapi1.entity.Department;
import com.restapi.restapi1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentServices {
   public Department addDepartment(Department department);

   public   List<Department> findAllDepartments();

  public  Department findDepartmentById(Long deptId) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long deptId) throws DepartmentNotFoundException;

  public void addAllDepartments(List<Department> list);

  public  Department updateDepartment(Long deptId, Department department);

  public  Department findDepartmentByName(String departmentName);

  public  Department findDepartmentByCode(String departmentCode);

  public Department findDepartmentByAddress(String departmentAddress);

  public  void deleteAllDepartments();
}
