package com.restapi.restapi1.repository;

import com.restapi.restapi1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentCode(String departmentCode);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    public Department findAllByDepartmentAddress(String departmentAddress);
}
