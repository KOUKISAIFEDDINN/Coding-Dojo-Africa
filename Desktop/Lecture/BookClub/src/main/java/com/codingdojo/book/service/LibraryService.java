package com.codingdojo.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.book.entity.Library;
import com.codingdojo.book.reposiotry.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository libRepo;
	
	public Library create(Library library) {
		return libRepo.save(library);
	}
	
	public List<Library> getAll(){
		return libRepo.findAll()
;	}
}
