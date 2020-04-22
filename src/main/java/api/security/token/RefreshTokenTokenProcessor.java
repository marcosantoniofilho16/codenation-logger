package api.security.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import api.configuration.SecurityProperty;

@ControllerAdvice
public class RefreshTokenTokenProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {
	
	@Autowired
	private SecurityProperty securityProperty;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMethod().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		String refreshToken = body.getRefreshToken().getValue();
		
		HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
		HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();

		addRefreshTokenInCookie(refreshToken, req, resp);
		removeRefreshTokenFromBody(body);

		return body;
	}

	private void removeRefreshTokenFromBody(OAuth2AccessToken body) {
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
		if (!token.getScope().contains("mobile"))
			token.setRefreshToken(null);
		token.getAdditionalInformation().clear();
	}

	private void addRefreshTokenInCookie(String refreshToken, HttpServletRequest req, HttpServletResponse resp) {
		Cookie refreshTokenCookie = new Cookie("refresh_token", refreshToken);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(securityProperty.getEnableHttps()); // TODO 
		refreshTokenCookie.setPath(req.getContextPath() + "/oauth/token");
		refreshTokenCookie.setMaxAge(securityProperty.getRefreshTokenValiditySeconds());
		resp.addCookie(refreshTokenCookie);
	}
}
