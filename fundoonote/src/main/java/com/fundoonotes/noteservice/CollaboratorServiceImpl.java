package com.fundoonotes.noteservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.fundoonotes.userservice.UserDAO;

public class CollaboratorServiceImpl implements ICollaboratorService {

	@Autowired
	private UserDAO userDao;
	@Autowired
	INoteService noteService;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Override
	public void createCollaborator(String sharedUseremail, int noteId, int userId) {
		
		Collaborator collaborator =  new Collaborator();
		collaborator.setNote(noteService.getNoteByNoteId(noteId));
		collaborator.setSharedUser(userDao.findByEmail(sharedUseremail));
		collaborator.setOwner(userDao.findById(userId).get());
		collaboratorRepository.save(collaborator);
		
	}

	@Override
	public void removeCollaborator(String sharedUseremail, int noteId) {
		
		
	}

	
}
