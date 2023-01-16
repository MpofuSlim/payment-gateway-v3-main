package com.example.meraki.Config.gateway;

public enum PaymentStatus {
    PROCESSING(100, false),
    SUCCESS(200, true),
    FAILED(500, false),
    REVERSED(300, false),
    PENDING(700, true),
    NOT_FOUND(404, false);

    final int statusCode;
    final boolean success;

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    PaymentStatus(int statusCode, boolean success) {
        this.statusCode = statusCode;
        this.success = success;
    }
}
