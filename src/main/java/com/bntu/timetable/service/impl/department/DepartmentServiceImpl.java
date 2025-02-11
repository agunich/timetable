package com.bntu.timetable.service.impl.department;

import com.bntu.timetable.entity.Department;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.department.DepartmentRepository;
import com.bntu.timetable.service.api.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department departmentDto) {
        Department department = new Department();
        department.setShortName(departmentDto.getShortName());
        department.setFullName(departmentDto.getFullName());
        department.setDescription(departmentDto.getDescription());
        department.setCode(departmentDto.getCode());
        department.setDeanery(departmentDto.getDeanery());
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department departmentDto) {
        Department department = getDepartmentById(departmentDto.getId());
        department.setShortName(departmentDto.getShortName());
        department.setFullName(departmentDto.getFullName());
        department.setDescription(departmentDto.getDescription());
        department.setCode(departmentDto.getCode());
        department.setDeanery(departmentDto.getDeanery());
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(UUID id) {
        return getDepartmentById(id);
    }

    private Department getDepartmentById(UUID departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            throw new RuntimeException(ErrorMessage.DEPARTMENT_NOT_FOUND);
        }
        return department;
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartments(UUID deaneryId) {
        return departmentRepository.findAllByDeanery_Id(deaneryId);
    }
}
