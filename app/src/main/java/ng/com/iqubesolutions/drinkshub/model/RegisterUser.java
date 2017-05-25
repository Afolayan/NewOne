package ng.com.iqubesolutions.drinkshub.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Afolayan Oluwaseyi on 5/24/17.
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

    public RegisterUser(String firstName, String lastName, String email, String password, String address, String country, String state, String LGA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.country = country;
        this.state = state;
        this.LGA = LGA;
    }

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

    public String toString(){
        String string = firstName+"\n"+ lastName +"\n"+ email+"\n"+password;
        string += address +"\n" + country +"\n"+ state +"\n"+ LGA;
        return string;
    }
    public class UserResponse{

        @SerializedName("Msg")
        String message;
        @SerializedName("status")
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
