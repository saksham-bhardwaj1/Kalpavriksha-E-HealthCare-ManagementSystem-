package com.hospital.service;

import com.hospital.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
  List<Room> getAllRooms();
  Room createRoom(Room room);
  Optional<Room> getRoomById(Long id);
  Room updateRoom(Long id, Room roomDetails) throws Exception;
  void deleteRoom(Long id) throws Exception;
}
