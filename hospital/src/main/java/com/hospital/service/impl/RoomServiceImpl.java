package com.hospital.service.impl;

import com.hospital.model.Room;
import com.hospital.repository.RoomRepository;
import com.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public List<Room> getAllRooms() {
    return roomRepository.findAll();
  }

  @Override
  public Room createRoom(Room room) {
    return roomRepository.save(room);
  }

  @Override
  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }

  @Override
  public Room updateRoom(Long id, Room roomDetails) throws Exception {
    Room room = roomRepository.findById(id)
      .orElseThrow(() -> new Exception("Room not found with id: " + id));

    room.setRoomNumber(roomDetails.getRoomNumber());
    room.setType(roomDetails.getType());
    room.setAvailable(roomDetails.isAvailable());

    return roomRepository.save(room);
  }

  @Override
  public void deleteRoom(Long id) throws Exception {
    Room room = roomRepository.findById(id)
      .orElseThrow(() -> new Exception("Room not found with id: " + id));

    roomRepository.delete(room);
  }
}
