package com.labs.maverick.a116.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

/**
 * Created by Maverick on 4/08/2017.
 */
@Table(name = "contact")
public class Contact extends SugarRecord {
    @Unique
    private String name;
    private String phone;

    public Contact(){

    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
