package ecom.domain;

import javax.validation.constraints.NotNull;

public class ChangePassword {

    @NotNull
    private String username;

    @NotNull
    private String current_password;

    @NotNull
    private String new_password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrent_password() {
        return current_password;
    }

    public void setCurrent_password(String currentPassword) {
        this.current_password = currentPassword;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
