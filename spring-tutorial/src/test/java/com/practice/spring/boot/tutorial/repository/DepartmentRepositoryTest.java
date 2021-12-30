package com.practice.spring.boot.tutorial.repository;

import com.practice.spring.boot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentAddress("Pune")
                        .departmentCode("ME-012")
                        .build();
                testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Find BYy DepartmentID - Good Test Case")
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
         assertEquals(department.getDepartmentName(), "Mechanical Engineering");
        assertEquals(department.getDepartmentCode(), "ME-012");
    }
}