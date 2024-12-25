package com.prx.directory.client.to;

/**
 * Represents an authentication request with alias and password.
 */
public class AuthRequest {
    private String alias;
    private String password;

    /**
     * Default constructor.
     */
    public AuthRequest() {
        // Default Constructor
    }

    /**
     * Parameterized constructor to initialize alias and password.
     *
     * @param alias the alias of the user
     * @param password the password of the user
     */
    public AuthRequest(String alias, String password) {
        this.alias = alias;
        this.password = password;
    }

    /**
     * Gets the alias of the user.
     *
     * @return the alias of the user
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias of the user.
     *
     * @param alias the alias of the user
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
