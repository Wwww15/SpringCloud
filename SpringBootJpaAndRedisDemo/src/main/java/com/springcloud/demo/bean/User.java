package com.springcloud.demo.bean;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "sp_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;
}
