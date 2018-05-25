package com.fundoonotes.noteservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="collaboratorRepository")
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

}
