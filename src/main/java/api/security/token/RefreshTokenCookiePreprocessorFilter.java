package api.security.token;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreprocessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getRequestURI().endsWith("oauth/token") && "refresh_token".equals(req.getParameter("grant_type"))
				&& req.getCookies() != null) {

			for (Cookie c : req.getCookies()) {
				if (c.getName().equals("refresh_token")) {
					String refreshToken = c.getValue();
					req = new CustomServletRequestWrapper(req, refreshToken);
				}

			}

		}

		chain.doFilter(req, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	private static class CustomServletRequestWrapper extends HttpServletRequestWrapper {

		private String refreshToken;

		public CustomServletRequestWrapper(HttpServletRequest request, String refreshToken) {
			super(request);
			this.refreshToken = refreshToken;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			map.put("refresh_token", new String[] { this.refreshToken });
			map.setLocked(true);
			return map;
		}

	}

}
