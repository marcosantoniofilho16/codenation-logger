package api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.userdetails.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Users extends User {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 45)
	private String password;

	@NotBlank
	@Size(max = 45)
	private String username;

	@ManyToMany
	@Getter(AccessLevel.NONE)
	private Set<GrantedAuthority> authorities;

	@NotNull
	private Boolean accountNonExpired;

	@NotNull
	private Boolean accountNonLocked;

	@NotNull
	private Boolean credentialsNonExpired;

	@NotNull
	private Boolean enabled;

	@Transient
	private Map<String, Object> info = new HashMap<>();
	
	public Users() {
		super(" ", " ", true, true, true, true, new ArrayList<>());
	}

	public Users(String username, String password, Set<GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public Users(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Set<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		if (((username == null) || "".equals(username)) || (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}

		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
	}

}
