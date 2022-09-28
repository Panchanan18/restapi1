package com.restapi.restapi1.service;

import com.restapi.restapi1.entity.Department;
import com.restapi.restapi1.error.DepartmentNotFoundException;
import com.restapi.restapi1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServicesImpl implements DepartmentServices{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(deptId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department is not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(deptId);
        if(department.isPresent()) {
            departmentRepository.deleteById(deptId);
        }
        else{
            throw new DepartmentNotFoundException("Department is not present for deletion");
        }
    }

    @Override
    public void addAllDepartments(List<Department> list) {
        departmentRepository.saveAll(list);
    }

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department depDB = departmentRepository.findById(deptId).get();
        departmentRepository.deleteById(deptId);

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        depDB.setDepartmentId(deptId);
        return departmentRepository.save(depDB);
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Department findDepartmentByCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

    @Override
    public Department findDepartmentByAddress(String departmentAddress) {
        return departmentRepository.findAllByDepartmentAddress(departmentAddress);
    }

    @Override
    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }
}
