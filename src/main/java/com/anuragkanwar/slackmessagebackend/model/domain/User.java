package com.anuragkanwar.slackmessagebackend.model.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@SuperBuilder
@Entity
@Table(name = "\"User\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<Room> rooms = new LinkedHashSet<>();

}
