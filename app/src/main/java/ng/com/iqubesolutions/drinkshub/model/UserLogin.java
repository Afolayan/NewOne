package ng.com.iqubesolutions.drinkshub.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afolayan Oluwaseyi on 5/24/17.
 */

public class UserLogin  {
    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public class LoginResponse{
        @SerializedName("status")
        String status;

        @SerializedName("comment")
        String comment;

        @SerializedName("token")
        String token;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
