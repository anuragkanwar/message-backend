package com.anuragkanwar.slackmessagebackend.repository;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsRoomByName(String name);
    Room getRoomsById(Long id);
}
