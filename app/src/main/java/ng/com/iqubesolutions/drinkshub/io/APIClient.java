package ng.com.iqubesolutions.drinkshub.io;

/**
 * Created by Afolayan Oluwaseyi on 5/24/17.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import ng.com.iqubesolutions.drinkshub.app.DrinksHub;
import ng.com.iqubesolutions.drinkshub.helper.AppSettings;
import ng.com.iqubesolutions.drinkshub.io.jsonhandler.ResponseHandler;
import ng.com.iqubesolutions.drinkshub.model.RegisterUser;

import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.showErrorDialog;
import static ng.com.iqubesolutions.drinkshub.helper.AccountUtils.hasSignedIn;
import static ng.com.iqubesolutions.drinkshub.helper.AccountUtils.setUserToken;
public class APIClient {

    public static final String TAG = APIClient.class.getSimpleName();


    public  static synchronized APIClient getInstance() {
        return new APIClient();
    }
    public void doLogin(final Context context, final String email, final String password) {

        String loginUrl = AppSettings.BASE_URL + AppSettings.CUSTOMER + AppSettings.LOGIN;
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Login in..\nPlease wait"  );
        dialog.show();

        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, loginUrl,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                Log.e(TAG, "response login" + response);
                                if(! response.contains("html")){

                                    String[] parsedResponse =
                                            ResponseHandler.getInstance().parseLoginResponse( response );
                                    String comment = parsedResponse[0];
                                    String token = parsedResponse[1];

                                    Toast.makeText(context, "Message: "+comment, Toast.LENGTH_SHORT).show();
                                    setUserToken(context, token);
                                    hasSignedIn(context);

                                } else {
                                    //response is not json, dont parse
                                }
                                dialog.hide();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e(TAG, "Error: " + error.getMessage());

                        showErrorDialog(context, "Confirm your login credentials " +
                                "or check your internet connection");
                        dialog.hide();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("email", email);
                        params.put("password", password);

                        return params;
                    }
                };

        DrinksHub.getInstance().addToRequestQueue(stringRequest);
    }

    public void doSignUp(final Context context, final RegisterUser user){

        String signupUrl = AppSettings.BASE_URL + AppSettings.SIGN_UP;
        final ProgressDialog dialog = new ProgressDialog( context );
        dialog.setMessage("Signing up...");
        dialog.show();

        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, signupUrl,
                        new Response.Listener<String>(){

                            @Override
                            public void onResponse(String response) {
                                Log.e(TAG, "response signup "+response);
                                String res = ResponseHandler.getInstance().parseSignUpResponse(response);

                                Toast.makeText(context, "Message: "+res, Toast.LENGTH_SHORT).show();
                                dialog.hide();
                            }
                        }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e(TAG, "Error: " + error.getMessage());
                        showErrorDialog(context, "Something happened, please check back later.");
                        dialog.hide();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("firstname", user.getFirstName());
                        params.put("lastname", user.getLastName());
                        params.put("email", user.getEmail());
                        params.put("password", user.getPassword());
                        params.put("address", user.getAddress());
                        params.put("country", user.getCountry());
                        params.put("state", user.getState());
                        params.put("lga", user.getLGA());

                        return params;
                    }

                };

        DrinksHub.getInstance().addToRequestQueue(stringRequest);
    }

}