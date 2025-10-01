package com.vcm.models;

import java.util.HashMap;
import java.util.Map;

import com.vcm.patterns.Subject;

public class Classroom extends Subject {

    private final String name;
    private final Map<String, Student> students;
    private final Map<String, Assignment> assignments;

    public Classroom(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be null or empty.");
        }
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (student != null && !students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            this.addObserver(student); // Student is now an observer of this class
        }
    }

    public java.util.Collection<Student> getStudents() {
        return students.values();
    }

    public boolean hasStudent(String studentId) {
        return students.containsKey(studentId);
    }

    public void scheduleAssignment(Assignment assignment) {
        if (assignment != null) {
            assignments.put(assignment.getDetails(), assignment);
            // Notify all enrolled students (observers) about the new assignment
            notifyObservers(this.name, assignment.getDetails());
        }
    }
}
