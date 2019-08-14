package com.samark.Dao;

import com.samark.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakerData")
public class FakerStudentDaoImplement implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "samark", "science"));
                put(2, new Student(2, "samark", "science"));
                put(3, new Student(3, "samark", "science"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student std = students.get(student.getId());
        std.setName(student.getName());
        std.setCourse(student.getCourse());
        students.put(student.getId(), student);

    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
