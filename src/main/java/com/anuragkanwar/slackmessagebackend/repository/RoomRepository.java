package com.anuragkanwar.slackmessagebackend.repository;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsRoomByName(String name);

    Room getRoomsById(Long id);
}
