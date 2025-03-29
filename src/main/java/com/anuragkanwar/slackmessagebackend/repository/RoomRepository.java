package com.anuragkanwar.slackmessagebackend.repository;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    boolean existsRoomByName(String name);

    Room getRoomById(Long id);

    Room deleteRoomById(Long id);


    List<Chat> findByIdAfter(@Param("cursor") Long cursor, Pageable pageable);

    Set<Room> findByWorkspace_Id(Long workspaceId);
}
