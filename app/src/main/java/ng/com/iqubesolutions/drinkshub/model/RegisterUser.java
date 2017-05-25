package ng.com.iqubesolutions.drinkshub.model;


/**
 * Created by iqube on 5/24/17.
 */

public class RegisterUser {
    String firstName;
    String lastName;
    String email;
    String password;
    String address;
    String country;
    String state;
    String LGA;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getLGA() {
        return LGA;
    }

    public class UserResponse{

        String message;
        String status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
