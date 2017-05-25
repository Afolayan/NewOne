package ng.com.iqubesolutions.drinkshub.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.com.iqubesolutions.drinkshub.R;
import ng.com.iqubesolutions.drinkshub.helper.FontChangeCrawler;
import ng.com.iqubesolutions.drinkshub.io.APIClient;

import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.isEmpty;
import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.setError;
import static ng.com.iqubesolutions.drinkshub.helper.UIHelper.validateAllFields;

public class SignupFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = SignupFragment.class.getSimpleName();

    @Bind(R.id.first_name_field)  TextInputLayout fNameField;
    @Bind(R.id.et_first_name) TextInputEditText fName;

    @Bind(R.id.last_name_field) TextInputLayout lNameField;
    @Bind(R.id.et_last_name) TextInputEditText lName;

    @Bind(R.id.email_field) TextInputLayout emailField;
    @Bind(R.id.et_email) TextInputEditText emailAdd;

    @Bind(R.id.password_field) TextInputLayout passwordField;
    @Bind(R.id.et_password) TextInputEditText password;

    @Bind(R.id.confirm_password_field) TextInputLayout cPasswordField;
    @Bind(R.id.et_confirm_password) TextInputEditText cfPassword;

    @Bind(R.id.address_field) TextInputLayout addressField;
    @Bind(R.id.et_address) TextInputEditText address;

    @Bind(R.id.country_field) TextInputLayout countryField;
    @Bind(R.id.et_country) TextInputEditText country;

    @Bind(R.id.state_field) TextInputLayout stateField;
    @Bind(R.id.et_state) TextInputEditText state;

    @Bind(R.id.lga_field) TextInputLayout lgaField;
    @Bind(R.id.et_lga) TextInputEditText lga;

    @Bind(R.id.btnSignUp) Button signUpBtn;


    private OnFragmentInteractionListener mListener;

    public SignupFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, view);

        signUpBtn.setOnClickListener( this );
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public void onClick(View view) {
        if( view.getId() == R.id.btnLogin){
            String firstName = fName.getText().toString().trim();
            String lastName = lName.getText().toString().trim();
            String email = emailAdd.getText().toString().trim();
            String passw = password.getText().toString().trim();
            String cpassw = cfPassword.getText().toString().trim();
            String addr = address.getText().toString().trim();
            String countryStr = country.getText().toString().trim();
            String stateStr = state.getText().toString().trim();
            String lgaStr = address.getText().toString().trim();

            if( isEmpty(firstName)) setError(fNameField, "Input first name");
            if( isEmpty(lastName)) setError(lNameField, "Input last name");
            if( isEmpty(email)) setError(emailField, "Input a valid email address");
            if( isEmpty(passw)) setError(passwordField, "Input password");
            if( isEmpty(cpassw)) setError(cPasswordField, "Input password");
            if( isEmpty(addr))setError(addressField, "Input a valid address");

            if ( !passw.equals(cpassw)){
                setError(passwordField, "Password does not match");
                setError(cPasswordField, "Password does not match");
            }
            if( isEmpty(countryStr)) setError(countryField, "Input a valid country");
            if( isEmpty(stateStr)) setError(stateField, "Input a valid state");
            if( isEmpty(lgaStr)) setError(lgaField, "Input a valid local government");

            if( validateAllFields( firstName, lastName, email, passw, cpassw, addr)){
                APIClient.getInstance().doSignUp( getActivity(), firstName,
                        lastName, email, passw, addr, countryStr, stateStr, lgaStr);
            }
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/proxima-nova-regular.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());
    }
}
