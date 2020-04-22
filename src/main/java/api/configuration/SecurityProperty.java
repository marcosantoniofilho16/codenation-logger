package api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class SecurityProperty {
	
	@Value("${security.enabled}")	
	private Boolean enabled;
	
	@Value("${security.enable-https}")	
	private Boolean enableHttps;

	@Value("${security.cli}")
	private String cli;
	
	@Value("${security.cli2}")
	private String cli2;

	@Value("${security.secret}")
	private String secret;

	@Value("${security.signing-key}")
	private String signingKey;

	@Value("${security.access-token-validity-seconds}")
	private int accessTokenValiditySeconds;
	
	@Value("${security.refresh-token-validity-seconds}")
	private int refreshTokenValiditySeconds;


}
