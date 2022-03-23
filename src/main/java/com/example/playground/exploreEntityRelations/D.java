package com.example.playground.exploreEntityRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class D {
    @Id
    long id;

    private int aNum;

    @ManyToOne
    private C cRelation;

}
