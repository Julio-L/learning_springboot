package com.example.playground.exploreEntityRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class B {
    @Id
    long id;

    private String bString;

    @OneToOne
    private A aRelation;

}
