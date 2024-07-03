package com.example.doclogin.controller;

import com.example.doclogin.model.Appointment;
import com.example.doclogin.model.TimeSlot;
import com.example.doclogin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @GetMapping("/appointments")
  public List<Appointment> getAllAppointments() {
    return appointmentService.getAllAppointments();
  }

  @PostMapping("/appointments")
  public Appointment createAppointment(@RequestBody Appointment appointment) throws AuthenticationException {
    return appointmentService.createAppointment(appointment);
  }

  @GetMapping("/appointments/{id}")
  public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) throws Exception {
    Appointment appointment = appointmentService.getAppointmentById(id);
    return ResponseEntity.ok(appointment);
  }

  @DeleteMapping("/appointments/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws Exception {
    Map<String, Boolean> response = appointmentService.deleteAppointment(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/timeSlots")
  public ResponseEntity<List<String>> getTimeSlots(){
    return ResponseEntity.ok().body(Arrays.stream(TimeSlot.values())
      .map(TimeSlot::getTime)
      .collect(Collectors.toList()));
  }
  @GetMapping("/availableTimeSlots")
  public ResponseEntity<List<String>> getTimeSlots(@RequestParam String date){
    return ResponseEntity.ok().body(appointmentService.getAvailableTimeSlots(date));

  }
}
