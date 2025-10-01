package com.vcm.commands;

import com.vcm.core.VirtualClassroomManager;

public class ListClassroomsCommand implements Command {
    @Override
    public void execute() {
        VirtualClassroomManager.getInstance().listClassrooms();
    }
}