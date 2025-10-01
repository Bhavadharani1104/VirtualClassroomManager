package com.vcm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vcm.commands.Command;
import com.vcm.factory.CommandFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    // A volatile boolean flag to control the application loop, ensuring visibility across threads.
    private static volatile boolean isRunning = true;

    public static void displayMenu() {
        System.out.println("\n--- Virtual Classroom Manager Menu ---");
        System.out.println("Available Commands:");
        System.out.println("  add_classroom <class_name>              - Creates a new classroom.");
        System.out.println("  add_student <student_id> <class_name>       - Enrolls a student in a classroom.");
        System.out.println("  schedule_assignment <class_name> <details>  - Schedules an assignment for a class.");
        System.out.println("  submit_assignment <student_id> <class_name> <details> - Submits an assignment.");
        System.out.println("  list_classrooms                           - Shows all created classrooms.");
        System.out.println("  list_students <class_name>                - Lists all students in a classroom.");
        System.out.println("  remove_classroom <class_name>             - Removes a classroom.");
        System.out.println("  help                                      - Shows this command menu.");
        System.out.println("  exit                                      - Shuts down the application.");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Virtual Classroom Manager Initialized.");
        displayMenu();
        System.out.println("Enter commands or type 'exit' to quit.");

        // Main application loop controlled by a boolean flag, avoiding 'while(true)'
        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine();

            // Graceful shutdown command
            if ("exit".equalsIgnoreCase(input.trim())) {
                isRunning = false;
                continue; // Skip the rest of the loop
            }

            try {
                // Factory creates the appropriate command object
                Command command = CommandFactory.createCommand(input);
                // Command is executed
                command.execute();
            } catch (Exception e) {
                // Centralized exception handling
                System.err.println("Error: " + e.getMessage());
                logger.error("An exception occurred during command execution:", e);
            }
        }

        System.out.println("Virtual Classroom Manager shutting down. Goodbye!");
        logger.info("Application shut down gracefully.");
        scanner.close();
    }
}
