package com.wcs.questrest2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import com.wcs.questrest2.entity.Book;
import com.wcs.questrest2.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping("")
  public List<Book> index() {
    return bookRepository.findAll();
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable Long id) {
  Optional<Book> optionalBook = bookRepository.findById(id);
  if (optionalBook.isPresent()) {
    return optionalBook.get();
  } else {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
  }
}

  @PostMapping("")
  public Book createBook(@RequestBody Book book) {
    return bookRepository.save(book);
   }

   @PutMapping("/{id}")
   public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    if (optionalBook.isPresent()) {
      Book updatedBook = optionalBook.get();
      updatedBook.setTitle(book.getTitle());
      updatedBook.setAuthor(book.getAuthor());
      updatedBook.setDescription(book.getDescription());
      return bookRepository.save(updatedBook);
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookRepository.deleteById(id);
  }

   }
