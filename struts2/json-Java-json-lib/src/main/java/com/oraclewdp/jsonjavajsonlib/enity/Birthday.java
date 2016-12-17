package com.oraclewdp.jsonjavajsonlib.enity;

/**
 *
 * @author lenovo
 */
public class Birthday {

    private String birthday;

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public Birthday(String birthday) {
        super();
        this.birthday = birthday;
    }
    //setter、getter

    public Birthday() {
    }

    @Override
    public String toString() {
        return this.birthday;
    }
}
