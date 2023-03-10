package com.bl.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    public ArrayList<Contact> contactbook = new ArrayList<>();
    ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();
    public void addContact()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter First Name");
        String first = scan.nextLine();
        System.out.println("Enter Last Name");
        String last = scan.nextLine();
        System.out.println("Enter Address");
        String address = scan.nextLine();
        System.out.println("Enter City");
        String city = scan.nextLine();
        System.out.println("Enter State");
        String state = scan.nextLine();
        System.out.println("Enter Zip Code");
        int zip = scan.nextInt();
        System.out.println("Enter Phone Number");
        long mobileNo = scan.nextLong();
        System.out.println("Enter E-mail");
        String email = scan.next();
        Contact contact = new Contact(first, last, address, city, state,  email,mobileNo, zip);
        contactbook.add(contact);
        System.out.println("Contact added Successfully");
        System.out.println("\n You can add multiple person's entry");
    }
    public void displayPerson()
    {
        System.out.println("\n Person Details is:");
        for (Contact person : contactbook)
        {
            System.out.println(person.toString());
        }
    }

    public void editPerson() {

        System.out.println("\n enter First name to edit details:");

        Scanner scan = new Scanner(System.in);
        String name = scan.next();

        for (Contact person : contactbook) {
            System.out.println(person.toString());

            if (name.equals(person.firstName)) {

                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email-Id\n"
                        + "3) Address\n"
                        + "4) Quit");
                int numb = scan.nextInt();

                switch (numb) {
                    case 1: {
                        System.out.println("enter new Mobile number:");
                        long mobileNo = scan.nextLong();

                        person.setMobileNo(mobileNo);
                        System.out.println("mobile no. is updated\n");
                        break;
                    }
                    case 2: {
                        System.out.println("enter new Email-id:");
                        String email = scan.nextLine();

                        person.setEmail(email);
                        System.out.println("Email-id is updated\n");
                        break;
                    }
                    case 3: {
                        System.out.println("enter your city");
                        String city = scan.nextLine();

                        System.out.println("enter your state");
                        String state = scan.nextLine();

                        System.out.println("enter your zip code");
                        int zip = scan.nextInt();

                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        System.out.println("Address is updated\n");
                        break;
                    }
                    default:
                        System.out.println("please enter right choice");
                }
            } else
                System.out.println("Person is not registered");
        }
        System.out.println(toString());
    }

    public void deletePerson()
    {
        System.out.println("enter First name to delete details:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        for (int i=0; i < contactbook.size(); i++)
        {
            String personName = contactbook.get(i).firstName;

            if (name.equals(personName))
            {
                contactbook.remove(i);
                System.out.println("this person details is deleted");
                break;
            }
            else
                System.out.println("please enter valid name");
        }
    }

    public void newAddressBook()
    {
        System.out.println("Enter AddressBook Name");
        Scanner scan = new Scanner(System.in);
        String userInputBookName = scan.next();
        AddressBookList addressbook = new AddressBookList(userInputBookName);
        addressBookNameList.add(addressbook);
        System.out.println("New Address Book Name is added to list");
    }
    public void displayAddressBook()
    {

        System.out.println("Existing AddressBook Names are : ");

        for (AddressBookList addressBookList : addressBookNameList) {
            System.out.println(addressBookList);
        }
    }

    public void duplicateCheck()
    {
        String first = null;
        for (int k = 0; k < contactbook.size(); k++)
        {
            String contactName = contactbook.get(k).firstName;

            if (first.equals(contactName))
            {
                System.out.println("This Person is Already Present");
            }
            else
            {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

  /*  public void searchPersonByCity()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter City name to search Person by city name");
        String userCity = scan.nextLine();

        contactbook.stream().filter(map -> map.getCity().contains(userCity)).
                forEach(contactbook -> System.out.println(contactbook));
    }
    public void searchPersonByState()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.nextLine();

        contactbook.stream().filter(map -> map.getState().contains(userState)).
                forEach(contactbook -> System.out.println(contactbook));
    }*/

    public void searchPersonByCity()
    {
        System.out.println("Enter City name to search Person by city name");
        Scanner scan = new Scanner(System.in);
        String userCity = scan.nextLine();

        Dictionary Citywisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getCity().contains(userCity)).forEach(contactbook -> Citywisedict.put(contactbook.getFirstName(),userCity));
        System.out.println("City Name: " + userCity);
        for (Enumeration i = Citywisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    public void searchPersonByState()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.nextLine();

        Dictionary Statewisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getState().contains(userState)).forEach(contactbook -> Statewisedict.put(contactbook.getFirstName(),userState));
        System.out.println("State Name: " + userState);
        for (Enumeration i = Statewisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    public void countByCity(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((Contact C) -> C.getCity())));
        System.out.println((contactbook.stream().collect(Collectors.groupingBy((Contact C) -> C.getCity(),Collectors.counting()))));
    }

    public void countByState(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((Contact C) -> C.getState())));
        System.out.println((contactbook.stream().collect(Collectors.groupingBy((Contact C) -> C.getState(),Collectors.counting()))));
    }
}
