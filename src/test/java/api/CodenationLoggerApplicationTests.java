package api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import api.model.EventLogger;
import api.model.Users;
import api.model.enums.Level;
import api.repository.EventLoggerRepository;
import api.repository.UsersRepository;

@SpringBootTest
@Transactional
class CodenationLoggerApplicationTests {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private EventLoggerRepository eventLoggerRepository;

	@Test
	void shouldSaveUser() {
		Users user = new Users();
		user.setUsername("test");
		user.setNonEncryptedPassword("test");
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		
		user = usersRepository.save(user);
		assertNotNull(user.getId());
	}
	
	@Test
	void shouldSaveEventLogger() {
		EventLogger event = new EventLogger();
		event.setLevel(Level.INFO);
		event.setEventDescription("test");
		event.setEventLogger("test");
		event.setSource("test");
		event.setDate(LocalDateTime.now());
		event.setQuantity(1);
		
		event = eventLoggerRepository.save(event);
		assertNotNull(event.getId());
	}

}
