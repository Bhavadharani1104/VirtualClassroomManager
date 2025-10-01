package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;

public class AddClassroomCommand implements Command {
    private final String className;

    public AddClassroomCommand(String className) {
        this.className = className;
    }

    @Override
    public void execute() {
        VirtualClassroomManager.getInstance().addClassroom(className);
    }
}