package osr.net.utils;

public class YamlFile {

    private String url;
    private String adminUrl;
    private String userLogin;
    private String userPassword;
    private String artistLogin;
    private String artistPassword;

    public YamlFile() {}

    /**
     * Get URL from yaml file
     *
     * @return String represents URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get admin URL from yaml file
     *
     * @return String represents URL
     */
    public String getAdminUrl() {
        return adminUrl;
    }

    /**
     * Get user email from yaml file
     *
     * @return String represents email
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Get user password from yaml file
     *
     * @return String represents password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Get user email from yaml file
     *
     * @return String represents email
     */
    public String getArtistLogin() {
        return artistLogin;
    }

    /**
     * Get user password from yaml file
     *
     * @return String represents password
     */
    public String getArtistPassword() {
        return artistPassword;
    }
}
