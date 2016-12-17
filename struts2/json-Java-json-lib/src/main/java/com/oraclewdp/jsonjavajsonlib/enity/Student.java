package com.oraclewdp.jsonjavajsonlib.enity;

/**
 *
 * @author lenovo
 */
public class Student {
     private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }
    private String email;
    private String address;
    private Birthday birthday;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Birthday getBirthday() {
        return birthday;
    }
 
    @Override
    public String toString() {
        return this.name + "#" + this.id + "#" + this.address + "#" + this.birthday + "#" + this.email;
    }

}
