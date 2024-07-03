package com.hospital.controller;

import com.hospital.model.Room;
import com.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  @Autowired
  private RoomService roomService;

  @GetMapping
  public List<Room> getAllRooms() {
    return roomService.getAllRooms();
  }

  @PostMapping
  public Room createRoom(@RequestBody Room room) {
    return roomService.createRoom(room);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
    Optional<Room> room = roomService.getRoomById(id);
    return room.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) throws Exception {
    Room updatedRoom = roomService.updateRoom(id, roomDetails);
    return ResponseEntity.ok(updatedRoom);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRoom(@PathVariable Long id) throws Exception {
    roomService.deleteRoom(id);
    return ResponseEntity.noContent().build();
  }
}
