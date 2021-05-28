package rs.ac.uns.ftn.androidserver.AndroidServer.dto;

public class LoginParams {

    private String email;
    private String password;

    private Long userID;
    private String accessToken;

    public LoginParams() {
    }

    public LoginParams(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginParams(Long userID, String email, String accessToken) {
        this.userID = userID;
        this.email = email;
        this.accessToken = accessToken;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Long return the userID
     */
    public Long getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    /**
     * @return String return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
