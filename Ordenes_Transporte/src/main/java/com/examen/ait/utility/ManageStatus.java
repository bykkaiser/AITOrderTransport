package com.examen.ait.utility;

import java.util.Set;

public enum ManageStatus {
    CREATED,
    IN_TRANSIT,
    DELIVERED,
    CANCELLED;

    public static boolean validateChange(ManageStatus nextStatus) {
        return switch (nextStatus) {
            case CREATED -> Set.of(IN_TRANSIT, CANCELLED).contains(nextStatus);
            case IN_TRANSIT -> Set.of(DELIVERED, CANCELLED).contains(nextStatus);
            case DELIVERED, CANCELLED -> false; 
        };
    }
    
    public static ManageStatus fromString(String value) {
        for (ManageStatus status : ManageStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Estado no reconocido: " + value);
    }
}