package com.vcm.commands;

import com.vcm.Main;

public class HelpCommand implements Command {
    @Override
    public void execute() throws Exception {
        Main.displayMenu();
    }
}