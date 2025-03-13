package com.example.demo.util.Mappers;

import com.example.demo.dto.request.StudentSaveRequestDTO;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student RequestDTOtoEntity(StudentSaveRequestDTO studentSaveRequestDTO);
}
