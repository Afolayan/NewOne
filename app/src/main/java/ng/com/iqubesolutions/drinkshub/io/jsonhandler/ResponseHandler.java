package ng.com.iqubesolutions.drinkshub.io.jsonhandler;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ng.com.iqubesolutions.drinkshub.helper.AccountUtils;
import ng.com.iqubesolutions.drinkshub.model.RegisterUser.UserResponse;
import ng.com.iqubesolutions.drinkshub.model.UserLogin.LoginResponse;

import static android.content.ContentValues.TAG;

/**
 * Created by Afolayan Oluwaseyi on 5/25/17.
 */

public class ResponseHandler {

    private static final String TAG = ResponseHandler.class.getSimpleName();
    public static ResponseHandler getInstance(){
        return new ResponseHandler();
    }

    public String parseSignUpResponse( String response ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // parse json string to object
        UserResponse userResponse = gson.fromJson(response, UserResponse.class);

        return userResponse.getMessage();
    }

    public String[] parseLoginResponse( String response ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // parse json string to object
        LoginResponse userResponse = gson.fromJson(response, LoginResponse.class);

        String comment = userResponse.getComment();
        String token = userResponse.getToken();

        Log.e(TAG, "parseLoginResponse: "+comment );

        String[] parsedResponse = new String[2];
        parsedResponse[0] = comment;
        parsedResponse[1] = token;

        return parsedResponse;
    }

}
