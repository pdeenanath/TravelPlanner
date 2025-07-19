package com.travelplanner.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -1446398935944895849L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken(){
        return this.jwttoken;
    }
}
