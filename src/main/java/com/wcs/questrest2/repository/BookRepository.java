package com.wcs.questrest2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wcs.questrest2.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("SELECT b FROM Book b WHERE (b.title LIKE CONCAT('%', :query, '%') OR b.description LIKE CONCAT('%', :query, '%'))")
  List<Book> searchBook(@Param("query") String query);

}
