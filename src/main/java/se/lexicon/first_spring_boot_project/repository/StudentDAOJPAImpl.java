package se.lexicon.first_spring_boot_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.first_spring_boot_project.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Student persist(Student student) throws IllegalArgumentException{
        if(student == null){
            throw new IllegalArgumentException("Can not persist student, " + student);
        }
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student findById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null){
            throw new IllegalArgumentException("Can not find: " + firstName);
        }
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.firstName=?1");
        query.setParameter(1, firstName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void remove(Student student) {
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Student merge(Student student) {
        return entityManager.merge(student);
    }
}
