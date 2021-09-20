package com.shouvit.assignments.assignment19;

import com.shouvit.assignments.assignment18.Contact;
import com.shouvit.assignments.assignment18.ContactsDao;
import com.shouvit.assignments.assignment18.DaoException;

import java.util.*;

public class HashMapContacts {}

class Contacts implements ContactsDao {
    private HashMap<Integer, Contact> map;

    Contacts() {
        map = new HashMap<>();
    }

    @Override
    public void addContact(Contact contact) throws DaoException {
        map.put(map.size(), contact);
    }

    @Override
    public Contact getContact(int id) throws DaoException {
        return map.get(id);
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {
        map.put(contact.getId(), contact);
    }

    @Override
    public void deleteContact(int id) throws DaoException {
        map.remove(id);
    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        Contact result = null;
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry c = (Map.Entry)itr.next();
            Contact contact = (Contact)c.getValue();
            if(email.equalsIgnoreCase(contact.getEmail())) {
                result = contact;
            }
        }
        if(result == null) throw new DaoException();
        return result;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        Contact result = null;
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry c = (Map.Entry)itr.next();
            Contact contact = (Contact)c.getValue();
            if(phone.equalsIgnoreCase(contact.getPhone())) {
                result = contact;
            }
        }
        if(result == null) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        List<Contact> result = new ArrayList<>();
        for (Map.Entry<Integer, Contact> integerContactEntry : map.entrySet()) {
            Contact contact = integerContactEntry.getValue();
            if (lastname.equalsIgnoreCase(contact.getLastname())) {
                result.add(contact);
            }
        }
        if(result.isEmpty()) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        List<Contact> result = new ArrayList<>();
        for (Map.Entry<Integer, Contact> integerContactEntry : map.entrySet()) {
            Contact contact = integerContactEntry.getValue();
            if (city.equalsIgnoreCase(contact.getCity())) {
                result.add(contact);
            }
        }
        if(result.isEmpty()) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        List<Contact> result = new ArrayList<>();
        for (Map.Entry<Integer, Contact> integerContactEntry : map.entrySet()) {
            Contact contact = integerContactEntry.getValue();
            result.add(contact);
        }
        if(result.isEmpty()) throw new DaoException();
        return result;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        List<Contact> result = new ArrayList<>();
        for (Map.Entry<Integer, Contact> integerContactEntry : map.entrySet()) {
            Contact contact = integerContactEntry.getValue();
            if (from.after(contact.getBirthDate()) && to.before(contact.getBirthDate())) {
                result.add(contact);
            }
        }
        if(result.isEmpty()) throw new DaoException();
        return result;
    }
}
