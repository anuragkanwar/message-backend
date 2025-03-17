package com.anuragkanwar.slackmessagebackend.model.domain;

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
    private Workspace worskspace;

    @ManyToMany
    private Set<User> users = new LinkedHashSet<>();
}
