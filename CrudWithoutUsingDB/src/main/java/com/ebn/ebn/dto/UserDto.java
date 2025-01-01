package com.ebn.ebn.dto;

import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {

    private Long id;


    private String awdNumber;

    private Long ebnNumber;


    private LocalDate validationDate;

    private LocalDate creationDate;


    private LocalDate lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAwdNumber() {
        return awdNumber;
    }

    public void setAwdNumber(String awdNumber) {
        this.awdNumber = awdNumber;
    }

    public Long getEbnNumber() {
        return ebnNumber;
    }

    public void setEbnNumber(Long ebnNumber) {
        this.ebnNumber = ebnNumber;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
