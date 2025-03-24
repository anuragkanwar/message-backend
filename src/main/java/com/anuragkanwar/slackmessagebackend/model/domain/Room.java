package com.anuragkanwar.slackmessagebackend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;


@SuperBuilder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private boolean is_private;

    @ManyToOne
    private Workspace workspace;

    @ManyToOne
    private User creator;

    @ManyToMany
    private Set<User> users = new LinkedHashSet<>();
}
