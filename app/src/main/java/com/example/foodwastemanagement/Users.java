package com.example.foodwastemanagement;

public class Users {

    private String uid;
    private String Name;
    private String Phone;
    private String Email;
    private String Pass;
    private String Quantity;
    private String Address;

    public Users(){

    }
    public Users(String uid,String name, String phone, String email, String pass, String quantity,String address) {
        uid=uid;
        Name = name;
        Phone = phone;
        Email = email;
        Pass = pass;
        Quantity =quantity;
        Address = address;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
