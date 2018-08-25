package com.employeeinformation.io.respay.employeeinformation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Habib on 17/8/18.
 */

public class Employee {
    @SerializedName("success")
    private int status;
    @SerializedName("name")
    String  name;
    @SerializedName("type")
    String type;
    @SerializedName("id")
    String id;
    @SerializedName("address")
    String address;
    @SerializedName("date_of_joining")
    String date_of_joining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
