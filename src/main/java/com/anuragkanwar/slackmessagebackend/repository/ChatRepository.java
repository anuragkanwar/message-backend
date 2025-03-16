package com.anuragkanwar.slackmessagebackend.repository;

import java.util.List;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findAllByRoom_Id(Long room_id);
}

