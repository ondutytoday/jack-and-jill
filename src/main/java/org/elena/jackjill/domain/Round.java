package org.elena.jackjill.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Round extends BaseEntity {

    @Column(unique = true, nullable = false, name = "round")
    private String round;
}
