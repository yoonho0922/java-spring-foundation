package com.yoon.foundation.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_MEMBER")
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer satiety;

    @Column(name ="service_size")
    private double servingSize;

    @Column(name = "carbon_pledge")
    private double carbonPledge;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
