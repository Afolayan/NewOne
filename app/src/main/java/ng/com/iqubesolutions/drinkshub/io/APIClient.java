package ng.com.iqubesolutions.drinkshub.io;

/**
 * Created by iqube on 5/24/17.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

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
import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.showErrorDialog;
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
                                if( response.contains("html")){
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

    public void doSignUp(final Context context, final String firstName,
                         final String lastName, final String email, final String password,
                         final String address, final String country, final String state, final String LGA){

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
                        params.put("firstname", firstName);
                        params.put("lastname", lastName);
                        params.put("email", email);
                        params.put("password", password);
                        params.put("address", address);
                        params.put("country", country);
                        params.put("state", state);
                        params.put("lga", LGA);

                        return params;
                    }

                };

        DrinksHub.getInstance().addToRequestQueue(stringRequest);
    }

}