package com.vcm.models;

public class Assignment {
    private final String details;

    public Assignment(String details) {
        if (details == null || details.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignment details cannot be null or empty.");
        }
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}