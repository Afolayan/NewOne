package ng.com.iqubesolutions.drinkshub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import ng.com.iqubesolutions.drinkshub.helper.FontChangeCrawler;
import ng.com.iqubesolutions.drinkshub.helper.UIHelper;
import ng.com.iqubesolutions.drinkshub.io.APIClient;

import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.isEmail;
import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.isEmpty;
import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.setError;


public class LoginFragment extends Fragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = LoginFragment.class.getSimpleName();


    private OnFragmentInteractionListener mListener;

    @Bind(R.id.et_login_email)
    TextInputEditText emailTextView;
    @Bind(R.id.login_email_field) TextInputLayout emailField;

    @Bind(R.id.et_login_password) TextInputEditText passwordTextView;
    @Bind(R.id.login_password_field) TextInputLayout passwordField;
    @Bind(R.id.btnLogin) Button loginBtn;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        loginBtn.setOnClickListener(this);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ){
            case R.id.btnLogin:
                String email = emailTextView.getText().toString().trim();
                String password = passwordTextView.getText().toString().trim();

                if( isEmpty(email) || !isEmail(email)) setError(emailField, "Input a valid email address");
                if( isEmpty(password)) setError( passwordField , "Input password");

                if( !isEmpty(email) && isEmail(email) && !isEmpty(password)){
                    APIClient.getInstance().doLogin(getActivity(), email, password);
                }
                /*startActivity(
                        new Intent(getActivity(), MainActivity.class)
                );
                getActivity().finish();*/
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //changing the fonts
        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/proxima-nova-regular.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());
    }
}
