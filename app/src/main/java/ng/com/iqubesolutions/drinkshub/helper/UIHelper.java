package ng.com.iqubesolutions.drinkshub.helper;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

public class UIHelper {

    public static Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap, int borderWidth){
        if(bitmap ==null || bitmap.isRecycled()){
            return null;
        }
        final int width = bitmap.getWidth()+ borderWidth;
        final int height = bitmap.getHeight()+ borderWidth;
        Bitmap canvasBitmap =Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
        BitmapShader shader =new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint =new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        Canvas canvas =new Canvas(canvasBitmap);
        float radius = width > height ?((float) height)/2f:((float) width)/2f;
        canvas.drawCircle(width /2, height /2, radius, paint);
        paint.setShader(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(borderWidth);
        canvas.drawCircle(width /2, height /2, radius - borderWidth /2, paint);

        return canvasBitmap;
    }

    public static boolean isEmail(String emailAddress){
        return emailAddress.contains("@");
    }

    public static boolean isEmpty(String string){
        return TextUtils.isEmpty(string);
    }
    public static void setError(TextInputLayout til, String error){
        til.setError(error);
    }

    public static boolean validateAllFields(String firstName, String lastName,
                                            String email, String passw, String cpassw, String addr,
                                            String country, String state, String lga){
        return (!isEmpty(firstName) && !isEmpty(lastName) && !isEmpty(email)
                && !isEmpty(passw) && !isEmpty(cpassw) && !isEmpty(addr)
                && !isEmpty(country)&& !isEmpty(state)&& !isEmpty(lga));
    }

    public static void showErrorDialog(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(message).setTitle("Error")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Go to Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //go to settings page
                    }
                });
        builder.create();

        builder.show();
    }

}
