package ng.com.iqubesolutions.drinkshub.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.com.iqubesolutions.drinkshub.R;

/**
 * Created by OLUWAPHEMMY on 5/25/2017.
 */

public class WineSpiritFragment extends Fragment{

    private static final String TAG = "WineSpiritFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wine_spirit, container, false);

        return view;
    }

}
