package com.codingdojo.book.reposiotry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.book.entity.Library;
@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
List<Library> findAll();
}
