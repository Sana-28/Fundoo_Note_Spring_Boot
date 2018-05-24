package com.fundoonotes.noteservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="noteRepository")
public interface NoteRepository extends JpaRepository<Note, Integer> {

	
}