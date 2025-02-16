package com.example.demowithtests.util.mappers;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.employee.EmployeeDto;
import com.example.demowithtests.dto.employee.EmployeeIsVisibleDto;
import com.example.demowithtests.dto.employee.EmployeeReadDto;
import com.example.demowithtests.dto.employee.EmployeeUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {EmployeesCabinetsMapper.class})
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Named("setAvatarUrl")
    static String setAvatarUrl(Integer id) {
        return "http://localhost:8087/api/users/" + id + "/avatar";
    }

    Employee fromDto(EmployeeDto dto);

    EmployeeDto toDto(Employee employee);

    @Mapping(source = "id", target = "avatarUrl", qualifiedByName = "setAvatarUrl")
    @Mapping(source = "employeesCabinets", target = "cabinets")
    @Mapping(source = "workPass.prevPass.id", target = "workPass.prevPassId")
    EmployeeReadDto toReadDto(Employee employee);

    List<EmployeeIsVisibleDto> toListIsVisibleDto(List<Employee> employees);

    List<EmployeeReadDto> toListReadDto(List<Employee> employees);

    Employee fromUpdateDto(EmployeeUpdateDto dto);
}
