package com.shouvit.assignments.assignment18;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

enum Gender {
    MALE,
    FEMALE,
    NONBINARY
}

@Data
class Contact {
    private int id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer pincode;
    private String country;
    private Date birthDate;

    Contact(int id, String firstname, String lastname, Gender gender, String email, String phone, String address, String city, String state, int pincode, String country, Date birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.birthDate = birthDate;
    }

    public Contact() { }
}

class DaoException extends Throwable {

}

interface ContactsDao {
    // CRUD operations
    public void addContact(Contact contact) throws DaoException;
    public Contact getContact(int id) throws DaoException;
    public void updateContact(Contact contact) throws DaoException;
    public void deleteContact(int id) throws DaoException;

    // Queries
    public Contact getContactByEmail(String email) throws DaoException;
    public Contact getContactByPhone(String phone) throws DaoException;
    public List<Contact> getContactsByLastname(String lastname) throws DaoException;
    public List<Contact> getContactsByCity(String city) throws DaoException;
    public List<Contact> getContacts() throws DaoException;
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException;
}

class Contacts implements ContactsDao {
    private List<Contact> list;

    Contacts() {
        list = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact) throws DaoException {
        list.add(contact);
    }

    @Override
    public Contact getContact(int id) throws DaoException {
        return list.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElseThrow(DaoException::new);
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {
        list = list.stream()
                .filter(c -> c.getId() == contact.getId())
                .map(c -> contact)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteContact(int id) throws DaoException {
        list.removeIf(c -> c.getId() == id);
    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        Contact result = list.stream()
                .filter(c -> email.equalsIgnoreCase(c.getEmail()))
                .findAny()
                .orElse(null);
        if(result == null) throw new DaoException();
        return result;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        return list.stream()
                .filter(c -> phone.equalsIgnoreCase(c.getPhone()))
                .findAny()
                .orElseThrow(DaoException::new);
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        List<Contact> result = list.stream()
                .filter(c -> lastname.equalsIgnoreCase(c.getLastname()))
                .collect(Collectors.toList());
        if(result.isEmpty()) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        List<Contact> result = list.stream()
                .filter(c -> city.equalsIgnoreCase(c.getCity()))
                .collect(Collectors.toList());
        if(result.isEmpty()) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        return list;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        List<Contact> result = list.stream()
                .filter(c -> from.after(c.getBirthDate()) && to.before(c.getBirthDate()))
                .collect(Collectors.toList());
        if(result.isEmpty()) throw new DaoException();
        return result;
    }
}

class Menu {
    static Contact takeContact(Scanner sc) throws ParseException {
        Contact contact = new Contact();
        System.out.print("Enter firstname: ");
        contact.setFirstname(sc.next());
        System.out.print("Enter lastname: ");
        contact.setLastname(sc.next());
        System.out.print("Enter 0 for male, 1 for female, and 2 for non-binary: ");
        int choice = sc.nextInt();
        contact.setGender((choice == 1) ? Gender.FEMALE : (choice == 2) ? Gender.NONBINARY : Gender.MALE);
        System.out.print("Enter email: ");
        contact.setEmail(sc.next());
        System.out.print("Enter phone: ");
        contact.setPhone(sc.next());
        System.out.print("Enter address: ");
        contact.setAddress(sc.next());
        System.out.print("Enter city: ");
        contact.setCity(sc.next());
        System.out.print("Enter state: ");
        contact.setState(sc.next());
        System.out.print("Enter pincode: ");
        contact.setPincode(sc.nextInt());
        System.out.print("Enter country: ");
        contact.setCountry(sc.next());
        System.out.print("Enter birthdate in dd-MM-yyyy format: ");
        contact.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));

        return contact;
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Contacts contacts = new Contacts();
        do {
            System.out.println("Menu:\n" +
                    "1. Add new contact\n" +
                    "2. List all contacts\n" +
                    "3. Search by lastname\n" +
                    "4. Search by email address\n" +
                    "5. Search by phone number\n" +
                    "6. Search by city\n" +
                    "7. Search by date of birth range\n" +
                    "8. Delete contact\n" +
                    "9. Edit contact\n" +
                    "0. To exit\n" +
                    "Enter choice: ");
            try {
                choice = sc.nextInt();
                if(choice == 0) break;
                switch(choice) {
                    case 1:
                        contacts.addContact(takeContact(sc));
                        break;
                    case 2:
                        System.out.println(contacts.getContacts());
                        break;
                    case 3:
                        System.out.println("Enter Last name to search: ");
                        System.out.println(contacts.getContactsByLastname(sc.next()));
                        break;
                    case 4:
                        System.out.println("Enter email to search: ");
                        System.out.println(contacts.getContactByEmail(sc.next()));
                        break;
                    case 5:
                        System.out.println("Enter phone to search: ");
                        System.out.println(contacts.getContactByPhone(sc.next()));
                        break;
                    case 6:
                        System.out.println("Enter city to search: ");
                        System.out.println(contacts.getContactsByCity(sc.next()));
                        break;
                    case 7:

                        System.out.println("Enter range of date of birth to search: \n From, to, in dd-MM-yyyy format");
                        System.out.println(contacts.getContactsByBirthDate(
                                new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()),
                                new SimpleDateFormat("dd-MM-yyyy").parse(sc.next())
                        ));
                        break;
                    case 8:
                        System.out.println("Enter Id to delete: ");
                        contacts.deleteContact(sc.nextInt());
                        break;
                    case 9:
                        System.out.println("Enter id to edit: ");
                        int id = sc.nextInt();
                        Contact contact = takeContact(sc);
                        contact.setId(id);
                        contacts.updateContact(contact);
                        break;
                    default:
                        System.out.println("Exiting....");
                        break;
                }
            } catch(DaoException e) {
                System.out.println("Exiting....");
                break;
            } catch(Exception e) {
                System.out.println("Invalid Choice!");
            }
        } while(choice != 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Menu.run();
    }
}
