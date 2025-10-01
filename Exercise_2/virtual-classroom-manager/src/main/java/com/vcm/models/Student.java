package com.vcm.models;

import com.vcm.patterns.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    private final String id;

    public Student(String id) {
        // Defensive programming: Ensure ID is not null or empty
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void update(String classroomName, String assignmentDetails) {
        String notification = String.format("Notification for Student %s: New assignment '%s' scheduled for classroom '%s'.",
                this.id, assignmentDetails, classroomName);
        System.out.println(notification);
        logger.info("Sent assignment notification to student {}", this.id);
    }
}