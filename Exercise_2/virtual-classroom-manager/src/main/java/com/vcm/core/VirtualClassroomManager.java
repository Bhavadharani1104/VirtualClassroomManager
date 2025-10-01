package com.vcm.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vcm.exceptions.ClassroomNotFoundException;
import com.vcm.exceptions.StudentNotFoundException;
import com.vcm.models.Assignment;
import com.vcm.models.Classroom;
import com.vcm.models.Student;

public class VirtualClassroomManager {

    private static final Logger logger = LoggerFactory.getLogger(VirtualClassroomManager.class);

    // Eager initialization of Singleton instance
    private static final VirtualClassroomManager instance = new VirtualClassroomManager();

    // Using ConcurrentHashMap for thread-safety in a long-running app
    private final Map<String, Classroom> classrooms;

    // Private constructor to prevent instantiation
    private VirtualClassroomManager() {
        classrooms = new ConcurrentHashMap<>();
    }

    // Public method to get the single instance
    public static VirtualClassroomManager getInstance() {
        return instance;
    }

    public void addClassroom(String name) {
        classrooms.putIfAbsent(name, new Classroom(name));
        System.out.println("Classroom " + name + " has been created.");
        logger.info("Classroom '{}' created.", name);
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms have been created yet.");
            return;
        }
        System.out.println("Available Classrooms:");
        classrooms.keySet().forEach(name -> System.out.println("- " + name));
    }

    public void removeClassroom(String className) throws ClassroomNotFoundException {
        if (!classrooms.containsKey(className)) {
            throw new ClassroomNotFoundException("Error: Cannot remove. Classroom '" + className + "' not found.");
        }
        classrooms.remove(className);
        System.out.println("Classroom " + className + " has been removed.");
        logger.info("Classroom '{}' removed.", className);
    }

    public void addStudent(String studentId, String className) throws ClassroomNotFoundException {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Error: Classroom '" + className + "' not found.");
        }

        if (classroom.hasStudent(studentId)) {
            System.out.println("Warning: Student " + studentId + " is already enrolled in " + className + ".");
            logger.warn("Attempted to add existing student '{}' to classroom '{}'.", studentId, className);
            return;
        }

        Student student = new Student(studentId);
        classroom.addStudent(student);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        logger.info("Student '{}' added to classroom '{}'.", studentId, className);
    }

    public void listStudents(String className) throws ClassroomNotFoundException {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Error: Classroom '" + className + "' not found.");
        }

        if (classroom.getStudents().isEmpty()) {
            System.out.println("No students are enrolled in " + className + ".");
            return;
        }

        System.out.println("Students in " + className + ":");
        classroom.getStudents().forEach(student -> System.out.println("- " + student.getId()));
    }

    public void scheduleAssignment(String className, String assignmentDetails) throws ClassroomNotFoundException {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Error: Classroom '" + className + "' not found.");
        }
        Assignment assignment = new Assignment(assignmentDetails);
        classroom.scheduleAssignment(assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
        logger.info("Assignment '{}' scheduled for classroom '{}'.", assignmentDetails, className);
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails)
            throws ClassroomNotFoundException, StudentNotFoundException {

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Error: Cannot submit assignment. Classroom '" + className + "' not found.");
        }

        // New Validation: Check if the student is enrolled in this specific class.
        if (!classroom.hasStudent(studentId)) {
            throw new StudentNotFoundException("Error: Student '" + studentId + "' is not enrolled in '" + className + "'.");
        }

        // In a real application, you would also check if the assignment exists.
        System.out.println("Assignment '" + assignmentDetails + "' submitted by Student " + studentId + " in " + className + ".");
        logger.info("Assignment '{}' submitted by student '{}' for classroom '{}'.", assignmentDetails, studentId, className);
    }
}
