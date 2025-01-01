package com.ebn.ebn.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UserEntity {

    private Long id;

    @NotBlank(message = "should not be blank")
//    @Pattern(regexp = "\\d{12}", message = "ewaybillNumber must be 12 digits")
    private String shippingId;


   @NotNull(message = "should not be null.............")
   @Min(value = 100000000000L, message = "E-way Bill Number should be at least 12 digits.")
   @Max(value = 999999999999L, message = "E-way Bill Number should be at most 12 digits.")
    private Long ewayBillNumb;

//    @Pattern(regexp ="^(?:(?:(0[1-9]|1\\d|2[0-8])/(0[1-9]|1[0-2])|29/02/(?:(?:(?:[02468][048]|[13579][26])00)|(?:\\d{2}(?:0[48]|[2468][048]|[13579][26]))))|(?:0[1-9]|[12]\\d|3[01])/(0[13578]|1[02])|(?:0[1-9]|[12]\\d|30)/(0[469]|11))/\\d{4}$\n")
//    @CreationTimestamp
    private LocalDate validationDate;
//    @CreationTimestamp

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private LocalDate creationDate;

//    @UpdateTimestamp  this is used when we are saving date in database
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate lastModifiedDate;


//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return creationDate.format(formatter);
    }

    public UserEntity(Long id, String shippingId, LocalDate validationDate, Long ewayBillNumb, LocalDate creationDate, LocalDate lastModifiedDate) {

        this.id = id;
        this.shippingId = shippingId;
        this.validationDate = LocalDate.now();
        this.ewayBillNumb = ewayBillNumb;
        this.creationDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
    }

    public UserEntity() {

    }

    public void updateLastModifiedDate() {
        this.lastModifiedDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public Long getEwayBillNumb() {
        return ewayBillNumb;
    }

    public void setEwayBillNumb(Long ewayBillNumb) {
        this.ewayBillNumb = ewayBillNumb;
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

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
