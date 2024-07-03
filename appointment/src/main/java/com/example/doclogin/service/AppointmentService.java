package com.example.doclogin.service;

import com.example.doclogin.model.Appointment;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Map;

public interface AppointmentService {
  List<Appointment> getAllAppointments();
  Appointment createAppointment(Appointment appointment) throws AuthenticationException;
  Appointment getAppointmentById(Long id) throws Exception;
  Map<String, Boolean> deleteAppointment(Long id) throws Exception;

  List<String> getAvailableTimeSlots(String date);
}
