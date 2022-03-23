package com.example.playground.exploreEntityRelations;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class A {

    @Id
    long id;

    private int aNum;

    @OneToOne(mappedBy = "aRelation")
    private B bRelation;

}
