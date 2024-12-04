package org.elena.jackjill.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(name = "category", nullable = false, unique = true)
    private String category;
}
