package se.lexicon.first_spring_boot_project.repository;

import se.lexicon.first_spring_boot_project.model.Student;

import java.util.List;

public interface StudentDAO {

    Student persist(Student student);

    Student findById(int studentId);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void remove(Student student);

    Student merge(Student student);
}
