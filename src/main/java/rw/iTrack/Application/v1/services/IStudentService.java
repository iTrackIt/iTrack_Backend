package rw.iTrack.Application.v1.services;

import rw.iTrack.Application.v1.dto.LoginResponse;
import rw.iTrack.Application.v1.dto.UpdateStudentDTO;
import rw.iTrack.Application.v1.models.Student;

import java.rmi.StubNotFoundException;
import java.util.List;

public interface IStudentService {

    public Student createStudent(Student student);

    public Student updateStudent(Student student, UpdateStudentDTO newData);

    public String deleteStudent(String password, Long id) throws Exception;

    public List<Student> getAllStudents();

    public Student getStudentById(Long id) throws Exception;

    public List<Student> addMultipleStudents(List<Student> students);

    LoginResponse login(String email, String password);

    Student getLoggedInStudent();
}