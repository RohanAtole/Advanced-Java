package net.engineeringdigest.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.internal.connection.tlschannel.NeedsWriteException;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalEntryRepository;  // Dependency injection
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public void saveEntry(JournalEntry journalEntry, String userName) {

	    User user = userService.findByUserName(userName);

	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    // save journal entry
	    JournalEntry saved = journalEntryRepository.save(journalEntry);

	    // add entry to user
	    user.getJournalEntries().add(saved);

	    // save updated user
	    userService.saveUser(user);
	}
	
	public void saveEntry(JournalEntry journalEntry) {
		journalEntryRepository.save(journalEntry);
	}
	
	public List<JournalEntry> getAll(){
		return journalEntryRepository.findAll();
	}
	
	public Optional<JournalEntry> findById(ObjectId id) {
		return journalEntryRepository.findById(id);
	}
	
	public void deleteById(ObjectId id ,String userName) {
		User user = userService.findByUserName(userName);
		user.getJournalEntries().removeIf(x -> x.getId().equals(id));
		userService.saveUser(user);
		journalEntryRepository.deleteById(id);
	}
}

// Controller ---> service ----> repository
