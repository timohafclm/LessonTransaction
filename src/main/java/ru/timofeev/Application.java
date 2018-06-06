package ru.timofeev;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.timofeev.model.Contact;
import ru.timofeev.service.ContactService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        //contacts.stream().forEach(System.out::println);

        Contact contact = contactService.findById(1L);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact count: " + contactService.countAll());
    }
}
