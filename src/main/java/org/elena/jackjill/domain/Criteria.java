package org.elena.jackjill.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Criteria extends BaseEntity{

    @Column(unique = true, nullable = false, name = "criteria")
    private String criteria;
}
