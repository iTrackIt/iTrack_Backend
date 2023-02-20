package rw.iTrack.Application.v1.services;

import rw.iTrack.Application.v1.dto.UpdateStudentDTO;
import rw.iTrack.Application.v1.models.Student;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.UUID;

public interface IStudentService {

    public Student createStudent(Student student);

    public Student updateStudent(Student student, UpdateStudentDTO newData);

    public String deleteStudent(String password, UUID id) throws Exception;

    public List<Student> getAllStudents();

    public Student getStudentById(UUID id) throws Exception;

    public List<Student> addMultipleStudents(List<Student> students);
}
