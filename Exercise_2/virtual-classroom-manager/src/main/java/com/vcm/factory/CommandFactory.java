package com.vcm.factory;

import com.vcm.commands.AddClassroomCommand;
import com.vcm.commands.AddStudentCommand;
import com.vcm.commands.Command;
import com.vcm.commands.HelpCommand;
import com.vcm.commands.ListClassroomsCommand;
import com.vcm.commands.ListStudentsCommand;
import com.vcm.commands.RemoveClassroomCommand;
import com.vcm.commands.ScheduleAssignmentCommand;
import com.vcm.commands.SubmitAssignmentCommand;
import com.vcm.exceptions.InvalidCommandException;

public class CommandFactory {

    public static Command createCommand(String input) throws InvalidCommandException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException("Command input cannot be empty.");
        }

        String[] parts = input.trim().split("\\s+");
        String commandName = parts[0].toLowerCase();

        switch (commandName) {
            case "add_classroom":
                if (parts.length < 2) {
                    throw new InvalidCommandException("Usage: add_classroom <class_name>");
                }
                return new AddClassroomCommand(String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length)));

            case "add_student":
                if (parts.length != 3) {
                    throw new InvalidCommandException("Usage: add_student <student_id> <class_name>");
                }
                return new AddStudentCommand(parts[1], parts[2]);

            case "schedule_assignment":
                if (parts.length < 3) {
                    throw new InvalidCommandException("Usage: schedule_assignment <class_name> <assignment_details>");
                }
                return new ScheduleAssignmentCommand(parts[1], String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length)));

            case "submit_assignment":
                if (parts.length < 4) {
                    throw new InvalidCommandException("Usage: submit_assignment <student_id> <class_name> <assignment_details>");
                }
                return new SubmitAssignmentCommand(parts[1], parts[2], String.join(" ", java.util.Arrays.copyOfRange(parts, 3, parts.length)));

            case "list_classrooms":
                return new ListClassroomsCommand();

            case "list_students":
                if (parts.length != 2) {
                    throw new InvalidCommandException("Usage: list_students <class_name>");
                }
                return new ListStudentsCommand(parts[1]);

            case "remove_classroom":
                if (parts.length < 2) {
                    throw new InvalidCommandException("Usage: remove_classroom <class_name>");
                }
                return new RemoveClassroomCommand(String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length)));

            case "help":
                return new HelpCommand();

            default:
                throw new InvalidCommandException("Error: Unknown command '" + commandName + "'. Type 'help' to see available commands.");
        }
    }
}
