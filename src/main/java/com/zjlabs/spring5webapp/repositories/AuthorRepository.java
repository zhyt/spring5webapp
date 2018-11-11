package com.zjlabs.spring5webapp.repositories;

import com.zjlabs.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
