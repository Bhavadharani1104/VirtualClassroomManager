package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;
import com.vcm.exceptions.ClassroomNotFoundException;
import com.vcm.exceptions.StudentNotFoundException;

public class SubmitAssignmentCommand implements Command {
    private final String studentId;
    private final String className;
    private final String details;

    public SubmitAssignmentCommand(String studentId, String className, String details) {
        this.studentId = studentId;
        this.className = className;
        this.details = details;
    }

    @Override
    public void execute() throws ClassroomNotFoundException, StudentNotFoundException {
        VirtualClassroomManager.getInstance().submitAssignment(studentId, className, details);
    }
}