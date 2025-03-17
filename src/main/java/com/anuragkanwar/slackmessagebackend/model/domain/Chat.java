package com.anuragkanwar.slackmessagebackend.model.domain;

import com.anuragkanwar.slackmessagebackend.model.enums.ChatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chat extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ChatType messageType;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private int total_replies;

    @Column(nullable = false)
    private boolean is_deleted;

    @OneToOne(cascade = CascadeType.ALL)
    private Chat parent;

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;

}

