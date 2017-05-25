package ng.com.iqubesolutions.drinkshub.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by iqube on 5/24/17.
 */

public class AccountUtils {

    public static final String PREFS = "iqubesolutions";
    public static final String USER_ROLE = "role";
    public static final String USER_TOKEN = "token";
    public static final String USER_ROLE1 = "role";


    public static void setUserRole(Context context, String userRole) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_ROLE, "role");
        editor.apply();

    }
    public static String getUserRole(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return prefs.getString(USER_ROLE, "role");
    }

    public static void setUserToken(Context context, String userToken) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_ROLE, "role");
        editor.apply();
    }

    public static String getUserToken(Context context, String userRole){
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return prefs.getString(USER_ROLE, "role");
    }
}
