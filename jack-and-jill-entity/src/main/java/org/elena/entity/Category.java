package org.elena.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends BaseEntity {
    @Column(name = "category", nullable = false, unique = true)
    private String category;
}
