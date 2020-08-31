package com.geekbrains.java.course.custom;

public class PhoneNumber {
    private String phone;

    public PhoneNumber(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof PhoneNumber){
            return phone.hashCode() == obj.hashCode();
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return phone.hashCode();
    }
}
