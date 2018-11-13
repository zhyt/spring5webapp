package com.zjlabs.spring5webapp.bootstrap;

import com.zjlabs.spring5webapp.model.Author;
import com.zjlabs.spring5webapp.model.Book;
import com.zjlabs.spring5webapp.model.Publisher;
import com.zjlabs.spring5webapp.repositories.AuthorRepository;
import com.zjlabs.spring5webapp.repositories.BookRepository;
import com.zjlabs.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // Dependency Injection via Constructor
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void intiData(){
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Texas");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);
        saveData(eric, ddd, harper);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Florida");
        Book noEJB = new Book("Java Development without EJB", "23344", worx);
        rod.getBooks().add(noEJB);
        saveData(rod, noEJB, worx);
    }

    public void saveData(Author author, Book book, Publisher publisher){
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intiData();
    }
}
