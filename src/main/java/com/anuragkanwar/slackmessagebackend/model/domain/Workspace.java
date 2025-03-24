package com.anuragkanwar.slackmessagebackend.model.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace extends AbstractAuditingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    private Set<User> users = new HashSet<>();

    @OneToOne
    private User creator;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Room> rooms = new HashSet<>();
}
