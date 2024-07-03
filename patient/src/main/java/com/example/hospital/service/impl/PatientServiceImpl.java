package com.example.hospital.service.impl;

import com.example.hospital.model.Patient;
import com.example.hospital.model.User;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.UserRepository;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  TemplateEngine templateEngine;

  @Autowired
  UserRepository userRepository;

  @Autowired
  private PatientRepository patientRepository;

  @Override
  public List<Patient> getAllPatients() {
    return patientRepository.findAll();
  }

  @Override
  public Patient createPatient(Patient patient) {
    return patientRepository.save(patient);
  }

  @Override
  public Patient getPatientById(Long id) throws Exception {
    return patientRepository.findById(id)
      .orElseThrow(() -> new Exception("Patient not found for this id :: " + id));
  }

  @Override
  public Patient updatePatient(Long id, Patient patientDetails) throws Exception {
    Patient patient = patientRepository.findById(id)
      .orElseThrow(() -> new Exception("Patient not found for this id :: " + id));

    patient.setAge(patientDetails.getAge());
    patient.setName(patientDetails.getName());
    patient.setBlood(patientDetails.getBlood());
    patient.setDose(patientDetails.getDose());
    patient.setFees(patientDetails.getFees());
    patient.setPrescription(patientDetails.getPrescription());
    patient.setUrgency(patientDetails.getUrgency());

    return patientRepository.save(patient);
  }

  @Override
  public Map<String, Boolean> deletePatient(Long id) throws Exception {
    Patient patient = patientRepository.findById(id)
      .orElseThrow(() -> new Exception("Patient not found for this id :: " + id));

    patientRepository.delete(patient);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

    @Override
    public Object generateBill(Long id, Model model) {
    User user = userRepository.findById(id).get();
//    Patient patient = patientRepository.findById(id).get();
      Context context = new Context();
      model.addAttribute("name",user.getName());
      model.addAttribute("age",user.getAge());
      model.addAttribute("billNo", UUID.randomUUID().toString());
      model.addAttribute("date", LocalDateTime.now().toString());
      model.addAttribute("billAmount", "₹ "+user.getFees());

      String  total = "₹ ";
      Integer tax = 0;
      String charges = "₹ ";
      if(user.getFees()>0){
        int amount = user.getFees();
        tax = (int) (amount + (amount*0.18));
        charges = charges+ String.valueOf(amount*0.18);
      }
      charges = charges + String.valueOf(tax);
      model.addAttribute("charges", charges);
      model.addAttribute("billTotal", total+ String.valueOf(tax));

      context.setVariables(model.asMap());

    return templateEngine.process("bill", context);

    }
}
