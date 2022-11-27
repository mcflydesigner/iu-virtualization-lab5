package com.aqmp.model;

import javax.persistence.*;

@Entity
@Table(name = "msg_first")
public class MsgFirst {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data")
    private String data;


    public MsgFirst() {

    }

    public MsgFirst(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
