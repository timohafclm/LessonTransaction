package ru.timofeev.repository;

import org.springframework.data.repository.CrudRepository;
import ru.timofeev.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
