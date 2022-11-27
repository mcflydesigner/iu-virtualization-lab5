package com.aqmp.model;

import javax.persistence.*;

@Entity
@Table(name = "msg_second")
public class MsgSecond {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data")
    private String data;


    public MsgSecond() {

    }

    public MsgSecond(String data) {
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
