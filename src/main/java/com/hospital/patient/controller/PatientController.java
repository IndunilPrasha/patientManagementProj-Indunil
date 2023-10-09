package com.hospital.patient.controller;/* Created by patient */

import com.hospital.patient.model.Patient;
import com.hospital.patient.repository.PatientRepository;
import com.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Patient existingPatient = patientService.getPatientById(id);

        if (existingPatient == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the fields that can be modified
        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setLastName(updatedPatient.getLastName());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
        existingPatient.setEmail(updatedPatient.getEmail());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setVisitDate(updatedPatient.getVisitDate());
        existingPatient.setDiagnosis(updatedPatient.getDiagnosis());
        existingPatient.setDrugCode(updatedPatient.getDrugCode());
        existingPatient.setAdditionalInformation(updatedPatient.getAdditionalInformation());
        Patient updated = patientService.createPatient(existingPatient);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
