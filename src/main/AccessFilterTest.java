package com.tesco.colleague.performance.activity.detail.service.v1.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tesco.colleague.performance.activity.detail.service.v1.config.BasicAuthSecurityConfig;
import com.tesco.colleague.performance.activity.detail.service.v1.service.auth.AuthorizationHeaderService;
import com.tesco.colleague.performance.commons.colleague.performance.commons.client.config.IdentityApiConfig;
import com.tesco.colleague.performance.commons.colleague.performance.commons.client.service.identity.AccessToken;
import com.tesco.colleague.performance.commons.colleague.performance.commons.client.service.identity.IdentityCacheManager;
import com.tesco.colleague.performance.commons.colleague.performance.commons.client.service.identity.IdentityRestClientService;
import com.tesco.colleague.performance.commons.colleague.performance.commons.security.exception.AuthenticationException;
import com.tesco.colleague.performance.commons.colleague.performance.commons.security.exception.AuthorizationException;
import com.tesco.colleague.performance.commons.colleague.performance.commons.security.service.AuthenticationCache;
import com.tesco.colleague.performance.commons.colleague.performance.commons.security.service.AuthenticationService;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class AccessFilterTest {
    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.isCommitted()" because the return value of "org.apache.catalina.connector.Response.getCoyoteResponse()" is null
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:741)
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:53)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        IdentityApiConfig identityApiConfig = new IdentityApiConfig();
        IdentityRestClientService identityRestClientService = new IdentityRestClientService(identityApiConfig,
                new IdentityCacheManager());

        AuthenticationService authenticationService = new AuthenticationService(identityRestClientService,
                new AuthenticationCache());

        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        accessFilter.doFilterInternal(httpServletRequest, new Response(), mock(FilterChain.class));
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.tesco.colleague.performance.commons.colleague.performance.commons.security.service.AuthenticationService.authenticate(String)" because "this.authenticationService" is null
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:48)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        AccessFilter accessFilter = new AccessFilter(null,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        accessFilter.doFilterInternal(httpServletRequest, new Response(), mock(FilterChain.class));
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal3() throws IOException, ServletException {
        AccessToken accessToken = mock(AccessToken.class);
        when(accessToken.getClientId()).thenReturn("42");
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(accessToken);
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
        verify(authenticationService).authenticate((String) any());
        verify(accessToken).getClientId();
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal4() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.isCommitted()" because the return value of "org.apache.catalina.connector.Response.getCoyoteResponse()" is null
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:741)
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:53)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(mock(AccessToken.class));
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new AuthenticationException(-1)).when(filterChain)
                .doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal5() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.isCommitted()" because the return value of "org.apache.catalina.connector.Response.getCoyoteResponse()" is null
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:741)
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:57)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(mock(AccessToken.class));
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new AuthorizationException(-1)).when(filterChain)
                .doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal6() throws IOException, ServletException {
        AccessToken accessToken = mock(AccessToken.class);
        when(accessToken.getClientId()).thenReturn("42");
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(accessToken);
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new IOException("An error occurred")).when(filterChain)
                .doFilter((ServletRequest) any(), (ServletResponse) any());
        assertThrows(IOException.class,
                () -> accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain));
        verify(authenticationService).authenticate((String) any());
        verify(accessToken).getClientId();
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal7() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.isCommitted()" because the return value of "org.apache.catalina.connector.Response.getCoyoteResponse()" is null
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:741)
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:53)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        new AuthenticationException(-1);
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(mock(AccessToken.class));
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig("ABC123")));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal8() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.isCommitted()" because the return value of "org.apache.catalina.connector.Response.getCoyoteResponse()" is null
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:741)
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:57)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        new AuthorizationException(-1);
        new AuthenticationException(-1);
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(mock(AccessToken.class));
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig()));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal9() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getRequestURI()" because "httpServletRequest" is null
        //       at com.tesco.colleague.performance.activity.detail.service.v1.filter.AccessFilter.doFilterInternal(AccessFilter.java:43)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        new AuthorizationException(-1);
        new AuthenticationException(-1);
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(mock(AccessToken.class));
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig()));
        Response httpServletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(null, httpServletResponse, filterChain);
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal10() throws IOException, ServletException {
        new AuthorizationException(-1);
        new AuthenticationException(-1);
        AccessToken accessToken = mock(AccessToken.class);
        when(accessToken.getClientId()).thenThrow(new AuthenticationException(-1));
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(accessToken);
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig()));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
        verify(authenticationService).authenticate((String) any());
        verify(accessToken).getClientId();
    }

    /**
     * Method under test: {@link AccessFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal11() throws IOException, ServletException {
        new AuthenticationException(-1);
        new AuthorizationException(-1);
        new AuthenticationException(-1);
        AccessToken accessToken = mock(AccessToken.class);
        when(accessToken.getClientId()).thenThrow(new AuthorizationException(-1));
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        when(authenticationService.authenticate((String) any())).thenReturn(accessToken);
        AccessFilter accessFilter = new AccessFilter(authenticationService,
                new AuthorizationHeaderService(new BasicAuthSecurityConfig()));
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        accessFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
        verify(authenticationService).authenticate((String) any());
        verify(accessToken).getClientId();
    }
}

