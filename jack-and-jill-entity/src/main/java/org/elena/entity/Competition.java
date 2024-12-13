package org.elena.entity;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "competition")
public class Competition extends BaseEntity{

    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(nullable = false, name = "start_date")
    private Instant startDate;

    @ManyToMany
    @JoinTable(
            name = "JUDGES_TO_COMPETITION",
            joinColumns = @JoinColumn(name = "JUDGE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPETITION_ID", referencedColumnName = "ID")
    )
    private List<Judge> judges;
}

