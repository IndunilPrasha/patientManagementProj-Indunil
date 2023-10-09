package com.hospital.patient.model;/* Created by patient */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AdditionalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notes;
    private boolean newPatient;
    private String race;
    private String ssn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isNewPatient() {
        return newPatient;
    }

    public void setNewPatient(boolean newPatient) {
        this.newPatient = newPatient;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
