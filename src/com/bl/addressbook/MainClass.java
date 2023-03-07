package com.bl.addressbook;

public class MainClass {

    public static void main(String[] args) {
        AddressBook obj = new AddressBook ();
        obj.createContacts();
        AddressBookMain address = new AddressBookMain();
        address.addContact();
        address.displayPerson();
    }
}
