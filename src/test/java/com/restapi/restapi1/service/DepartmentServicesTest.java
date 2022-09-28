package com.restapi.restapi1.service;

import com.restapi.restapi1.entity.Department;
import com.restapi.restapi1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServicesTest {
    @Autowired
    private DepartmentServices departmentServices;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("Mumbai")
                .departmentCode("ME_123")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("Mechanical")).thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="Mechanical";
        Department found= departmentServices.findDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}