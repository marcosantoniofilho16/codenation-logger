package api.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.model.Users;
import api.repository.UsersRepository;

@Service
public class UserDetailsSystem implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.loadUserDatabase(username);
	}

	private UserDetails loadUserDatabase(String username) {
		return loadUser(username);
	}

	private UserDetails loadUser(String username) {
		Optional<Users> usuarioOptional = userRepository.findByUsername(username);
		Users user = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("config.security.invalid_user")); 

		return user;
	}

}
