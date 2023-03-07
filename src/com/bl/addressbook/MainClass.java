package com.bl.addressbook;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        AddressBook obj = new AddressBook ();
        obj.createContacts();
       /* AddressBookMain address = new AddressBookMain();
        address.addContact();
        address.displayPerson();
        address.editPerson();
        address.deletePerson();*/
        System.out.println("Welcome To The Address Book Problem-");
        AddressBookMain address = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Contact");
        System.out.println("2.Edit Contact");
        System.out.println("3.Display Contact");
        System.out.println("4.Exit");
        int k=0;
        while(k==0)
        {
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    address.addContact();
                    break;
                case 2:
                    address.displayPerson();
                    break;
                case 3:
                    address.editPerson();
                    break;
                case 4:
                    address.deletePerson();
                    break;
                case 5:
                    address.newAddressBook();
                    break;
                case 6:
                    address.displayAddressBook();
                    break;
                case 7:
                    System.out.println("Exit");
                    k = 1;
                    break;
            }
        }
    }
    }

