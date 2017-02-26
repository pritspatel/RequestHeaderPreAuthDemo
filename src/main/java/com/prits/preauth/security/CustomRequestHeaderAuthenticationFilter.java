package com.prits.preauth.security;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.util.Assert;

/**
 * Created by priteshpatel on 2/26/17.
 */
public class CustomRequestHeaderAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter{

    private String principalRequestHeader = "MY_USER";
    private String credentialsRequestHeader;
    private boolean exceptionIfHeaderMissing = true;


    protected Object getPreAuthenticatedPrincipal(javax.servlet.http.HttpServletRequest request) {
        String principal = request.getHeader(principalRequestHeader);

        if (principal == null && exceptionIfHeaderMissing) {
            throw new PreAuthenticatedCredentialsNotFoundException(principalRequestHeader
                    + " header not found in request.");
        }

        return principal;
    }

    protected Object getPreAuthenticatedCredentials(javax.servlet.http.HttpServletRequest request) {
        if (credentialsRequestHeader != null) {
            return request.getHeader(credentialsRequestHeader);
        }

        return "N/A";
    }

    public void setPrincipalRequestHeader(String principalRequestHeader) {
        Assert.hasText(principalRequestHeader,
                "principalRequestHeader must not be empty or null");
        this.principalRequestHeader = principalRequestHeader;
    }

    public void setCredentialsRequestHeader(String credentialsRequestHeader) {
        Assert.hasText(credentialsRequestHeader,
                "credentialsRequestHeader must not be empty or null");
        this.credentialsRequestHeader = credentialsRequestHeader;
    }

    /**
     * Defines whether an exception should be raised if the principal header is missing.
     * Defaults to {@code true}.
     *
     * @param exceptionIfHeaderMissing set to {@code false} to override the default
     * behaviour and allow the request to proceed if no header is found.
     */
    public void setExceptionIfHeaderMissing(boolean exceptionIfHeaderMissing) {
        this.exceptionIfHeaderMissing = exceptionIfHeaderMissing;
    }
}
