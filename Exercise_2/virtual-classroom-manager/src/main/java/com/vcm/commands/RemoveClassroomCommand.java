package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;
import com.vcm.exceptions.ClassroomNotFoundException;

public class RemoveClassroomCommand implements Command {
    private final String className;

    public RemoveClassroomCommand(String className) {
        this.className = className;
    }

    @Override
    public void execute() throws ClassroomNotFoundException {
        VirtualClassroomManager.getInstance().removeClassroom(className);
    }
}