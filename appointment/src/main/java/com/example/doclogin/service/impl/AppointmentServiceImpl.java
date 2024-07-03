package com.example.doclogin.service.impl;

import com.example.doclogin.model.Appointment;
import com.example.doclogin.model.TimeSlot;
import com.example.doclogin.model.User;
import com.example.doclogin.repository.AppointmentRepository;
import com.example.doclogin.repository.UserRepository;
import com.example.doclogin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  @Override
  public Appointment createAppointment(Appointment appointment) throws AuthenticationException {
    User user = userRepository.findById(appointment.getDoctorId()).get();
    if(appointmentRepository.findByDateAndTimeSlot(appointment.getDate(), appointment.getTimeSlot())!=null){
      throw new AuthenticationException("Slot already exists");
    }
    appointment.setDoctorName(user.getName());
    return appointmentRepository.save(appointment);
  }

  @Override
  public Appointment getAppointmentById(Long id) throws Exception {
    return appointmentRepository.findById(id)
      .orElseThrow(() -> new Exception("Appointment not found for this id :: " + id));
  }

  @Override
  public Map<String, Boolean> deleteAppointment(Long id) throws Exception {
    Appointment appointment = appointmentRepository.findById(id)
      .orElseThrow(() -> new Exception("Appointment not found for this id :: " + id));

    appointmentRepository.delete(appointment);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

  @Override
  public List<String> getAvailableTimeSlots(String date) {
    List<Appointment> appointments = appointmentRepository.findAllByDate(date);
    List<String> usedSlots = new ArrayList<>();
    for(Appointment appointment : appointments){
      usedSlots.add(appointment.getTimeSlot().getTime());
    }
    List<String> totalSlots = Arrays.stream(TimeSlot.values())
      .map(TimeSlot::getTime)
      .collect(Collectors.toList());
    totalSlots.removeAll(usedSlots);
    return totalSlots;
  }
}
