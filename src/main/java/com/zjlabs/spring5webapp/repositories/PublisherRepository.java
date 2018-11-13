package com.zjlabs.spring5webapp.repositories;

import com.zjlabs.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
