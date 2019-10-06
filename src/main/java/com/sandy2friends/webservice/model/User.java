package com.sandy2friends.webservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private long Id;

    @Column(name = "NAME",columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "AUTHOR",columnDefinition = "VARCHAR(50)", nullable = false )
    private String author;

    @Column(name = "CREATION_DATE")
    private LocalDate date;
}
