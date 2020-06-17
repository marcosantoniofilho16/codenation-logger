package api.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Users implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@JsonIgnore
	private String password;

	@NotBlank
	@Size(max = 45)
	private String username;

	@ManyToMany(fetch = FetchType.EAGER)
	@Getter(AccessLevel.NONE)
	private Set<Role> authorities;

	@NotNull
	@Getter(AccessLevel.NONE)
	private Boolean accountNonExpired;

	@NotNull
	@Getter(AccessLevel.NONE)
	private Boolean accountNonLocked;

	@NotNull
	@Getter(AccessLevel.NONE)
	private Boolean credentialsNonExpired;

	@NotNull
	@Getter(AccessLevel.NONE)
	private Boolean enabled;

	@Transient
	private Map<String, Object> info = new HashMap<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
