package com.bl.addressbook;

import java.util.Scanner;

public class AddressBook {

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    private String email;
    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String city;
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private int zip;
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    private String state;
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    private String phoneNum;
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void createContacts(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        setFirstName(sc.nextLine());
        System.out.print("Enter Last Name : ");
        setLastName(sc.nextLine());
        System.out.print("Enter City Name : ");
        setCity(sc.nextLine());
        System.out.print("Enter State Name : ");
        setState(sc.nextLine());
        System.out.print("Enter Email : ");
        setEmail(sc.nextLine());
        System.out.print("Enter Zip Code : ");
        setZip(sc.nextInt());
        System.out.print("Enter Phone Number : ");
        setPhoneNum(sc.next());

    }
    public String toString()
    {

        String str = "Contacts: [First Name = " + getFirstName() + ", Last Name = " + getLastName() +
                ", City = " + getCity() + ", State = " + getState() + ", Email = " + getEmail() + ", Zip = " + getZip() + ", PhoneNumber = " + getPhoneNum()  +"]";
        return str;

    }
}
