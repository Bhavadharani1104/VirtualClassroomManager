package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;
import com.vcm.exceptions.ClassroomNotFoundException;

public class ScheduleAssignmentCommand implements Command {
    private final String className;
    private final String details;

    public ScheduleAssignmentCommand(String className, String details) {
        this.className = className;
        this.details = details;
    }

    @Override
    public void execute() throws ClassroomNotFoundException {
        VirtualClassroomManager.getInstance().scheduleAssignment(className, details);
    }
}