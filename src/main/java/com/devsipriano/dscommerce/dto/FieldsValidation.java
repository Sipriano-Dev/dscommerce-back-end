package com.devsipriano.dscommerce.dto;

public class FieldsValidation {

    private String fieldName;
    private String message;

    public FieldsValidation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
