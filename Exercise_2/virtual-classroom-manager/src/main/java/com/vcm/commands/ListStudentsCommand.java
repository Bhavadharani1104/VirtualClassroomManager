package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;
import com.vcm.exceptions.ClassroomNotFoundException;

public class ListStudentsCommand implements Command {
    private final String className;

    public ListStudentsCommand(String className) {
        this.className = className;
    }

    @Override
    public void execute() throws ClassroomNotFoundException {
        VirtualClassroomManager.getInstance().listStudents(className);
    }
}