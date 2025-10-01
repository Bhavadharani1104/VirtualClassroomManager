package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;
import com.vcm.exceptions.ClassroomNotFoundException;

public class AddStudentCommand implements Command {
    private final String studentId;
    private final String className;

    public AddStudentCommand(String studentId, String className) {
        this.studentId = studentId;
        this.className = className;
    }

    @Override
    public void execute() throws ClassroomNotFoundException {
        VirtualClassroomManager.getInstance().addStudent(studentId, className);
    }
}