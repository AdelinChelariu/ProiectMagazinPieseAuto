import java.sql.Timestamp;

public class User {
    private int idUser;
    private String username;
    private String password;
    private Integer idAngajat;
    private Integer idClient;
    private String role;
    private Timestamp lastLogin;
    private Timestamp accountCreated;
    private boolean accountActive;
    private String resetToken;
    private Timestamp resetTokenExpiry;
    private int failedLoginAttempts;
    private boolean accountLocked;
    private String loginHistory;

    // Constructor gol
    public User() {
    }

    // Constructor cu parametri
    public User(int idUser, String username, String password, Integer idAngajat,
                Integer idClient, String role, java.sql.Timestamp lastLogin,
                java.sql.Timestamp accountCreated, boolean accountActive,
                String resetToken, java.sql.Timestamp resetTokenExpiry,
                int failedLoginAttempts, boolean accountLocked, String loginHistory) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.idAngajat = idAngajat;
        this.idClient = idClient;
        this.role = role;
        this.lastLogin = lastLogin;
        this.accountCreated = accountCreated;
        this.accountActive = accountActive;
        this.resetToken = resetToken;
        this.resetTokenExpiry = resetTokenExpiry;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountLocked = accountLocked;
        this.loginHistory = loginHistory;
    }

    // Getters și Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Integer idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public java.sql.Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(java.sql.Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public java.sql.Timestamp getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(java.sql.Timestamp accountCreated) {
        this.accountCreated = accountCreated;
    }

    public boolean isAccountActive() {
        return accountActive;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public java.sql.Timestamp getResetTokenExpiry() {
        return resetTokenExpiry;
    }

    public void setResetTokenExpiry(java.sql.Timestamp resetTokenExpiry) {
        this.resetTokenExpiry = resetTokenExpiry;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public String getLoginHistory() {
        return loginHistory;
    }

    public void setLoginHistory(String loginHistory) {
        this.loginHistory = loginHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", idAngajat=" + idAngajat +
                ", idClient=" + idClient +
                ", role='" + role + '\'' +
                ", lastLogin=" + lastLogin +
                ", accountCreated=" + accountCreated +
                ", accountActive=" + accountActive +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", accountLocked=" + accountLocked +
                '}';
    }
}