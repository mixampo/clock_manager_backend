package shared;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    // Link to source: https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    private Boolean checkPwd(String password, String hashedPwd) {
        return BCrypt.checkpw(password, hashedPwd);
    }

    public String getPasswordHash(String password) {
        return hashPassword(password);
    }

    public Boolean getPasswordCheckStatus(String password, String hashedPwd){
        return checkPwd(password, hashedPwd);
    }
}
