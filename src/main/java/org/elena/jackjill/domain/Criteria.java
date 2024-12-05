package org.elena.jackjill.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "criteria")
public class Criteria extends BaseEntity{

    @Column(unique = true, nullable = false, name = "criteria")
    private String criteria;
}
