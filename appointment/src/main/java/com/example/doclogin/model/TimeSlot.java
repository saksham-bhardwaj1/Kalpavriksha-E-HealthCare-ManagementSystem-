package com.example.doclogin.model;

import com.example.doclogin.service.TimeSlotDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = TimeSlotDeserializer.class)

public enum TimeSlot {
  SLOT_0900("9:00 AM"),
  SLOT_0920("9:20 AM"),
  SLOT_0940("9:40 AM"),
  SLOT_1000("10:00 AM"),
  SLOT_1020("10:20 AM"),
  SLOT_1040("10:40 AM"),
  SLOT_1100("11:00 AM"),
  SLOT_1120("11:20 AM"),
  SLOT_1140("11:40 AM"),
  SLOT_1200("12:00 PM"),
  SLOT_1220("12:20 PM"),
  SLOT_1240("12:40 PM"),
  SLOT_0100("1:00 PM"),
  SLOT_0120("1:20 PM"),
  SLOT_0140("1:40 PM"),
  SLOT_0200("2:00 PM"),
  SLOT_0220("2:20 PM"),
  SLOT_0240("2:40 PM"),
  SLOT_0300("3:00 PM"),
  SLOT_0320("3:20 PM"),
  SLOT_0340("3:40 PM"),
  SLOT_0400("4:00 PM"),
  SLOT_0420("4:20 PM"),
  SLOT_0440("4:40 PM"),
  SLOT_0500("5:00 PM"),
  SLOT_0520("5:20 PM"),
  SLOT_0540("5:40 PM"),
  SLOT_0600("6:00 PM");

  private final String time;

  TimeSlot(String time) {
    this.time = time;
  }

  public String getTime() {
    return time;
  }
}
