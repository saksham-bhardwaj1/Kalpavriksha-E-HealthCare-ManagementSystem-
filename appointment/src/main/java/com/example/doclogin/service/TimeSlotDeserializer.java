package com.example.doclogin.service;

import com.example.doclogin.model.TimeSlot;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TimeSlotDeserializer extends JsonDeserializer<TimeSlot> {

  @Override
  public TimeSlot deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException, JsonProcessingException {
    String value = p.getText();
    for (TimeSlot slot : TimeSlot.values()) {
      if (slot.getTime().equals(value)) {
        return slot;
      }
    }
    throw new IllegalArgumentException("Invalid time slot: " + value);
  }
}
