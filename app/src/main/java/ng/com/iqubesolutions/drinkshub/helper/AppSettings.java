package ng.com.iqubesolutions.drinkshub.helper;

/**
 * Created by iqube on 5/24/17.
 */

public class AppSettings {
    public static final String BASE_URL = "http://ask.net.ng/drinkshub/drinkshub-api/public/api/v1";
    public static final String BASE_URL_LIVE = "http://iqubeglobal.com/drinkshub-api/public/api/v1";
    public static final String CUSTOMER = "/customer";
    public static final String LOGIN = "/login";

    public static final String SIGN_UP = "/signup";
    public static final String CATEGORIES_ALL = "/products/categories/all";
    public static final String PRODUCT_TYPE = "/products/categories/product_type/{product_type}";

    public static final String PACK_TYPE = "/products/categories/pack_type/{pack_type}";
    public static final String ALL_PRODUCT = "/products/all";

    /*/customer/products/product/{id}
        /customer/products/search
        /customer/carts/cart/add



        /customer/carts/cart/update/{id}
        /customer/carts/cart/{id}
        /customer/carts/cart/checkout/{id}
        /customer/carts/cart/item/delete/{product_id}
        /customer/order_history/order/status/{order_id}
        /customer/order_history/order/all
        /customer/order_history/order/{order_id}
        /customer/user_profile
        /customer/user_profile/update
        /customer/payments/datagrabber
        /customer/payments/part_payment
        /customer/payments/full_payment
        /customer/payments/coupon/verify
        /customer/notifications/email/deliveries/order_summary/{order_id}
        /customer/notifications/email/deliveries/payment_receipt/{transaction_id}
        /customer/notifications/email/deliveries/confirmation/{order_id}
        /customer/notifications/email/deliveries/reschedule/{order_id}*/

}
