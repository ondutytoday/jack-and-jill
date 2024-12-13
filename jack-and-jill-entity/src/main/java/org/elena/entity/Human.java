package org.elena.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Human extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "club")
    private String club;
    @Column(name = "phone")
    private String phone;
}
