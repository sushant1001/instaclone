package com.project.instaclone.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Test
 */

@Entity
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}