package com.wcs.questrest2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.questrest2.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
