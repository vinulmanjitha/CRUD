package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "DEMO_TEST")
public class ACAEListDoneRQ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FACILITY_COVENANTS")
    @SequenceGenerator(name = "SEQ_FACILITY_COVENANTS", sequenceName = "SEQ_FACILITY_COVENANTS", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SOL_ID")
    private String solId;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

}
