package com.alexktp.chaywela.enums;

public enum Status {

    STARTED("STARTED"),
    PAUSED("PAUSED"),
    CANCELED("CANCELED"),
    FINISHED("FINISHED");

    public final  String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
