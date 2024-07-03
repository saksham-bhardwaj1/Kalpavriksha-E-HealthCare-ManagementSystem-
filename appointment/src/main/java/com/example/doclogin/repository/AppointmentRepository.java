package com.example.doclogin.repository;

import com.example.doclogin.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doclogin.model.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findByDateAndTimeSlot(String date, TimeSlot timeSlot);

  List<Appointment> findAllByDate(String date);
}

