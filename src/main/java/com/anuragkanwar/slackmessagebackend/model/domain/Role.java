package com.anuragkanwar.slackmessagebackend.model.domain;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;
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
public class Role extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
