package org.elena.jackjill.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Judge extends Human {

    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(
            name = "JUDGES_TO_COMPETITION",
            joinColumns = @JoinColumn(name = "JUDGE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPETITION_ID", referencedColumnName = "ID")
    )
    List<Competition> competitions;
}
