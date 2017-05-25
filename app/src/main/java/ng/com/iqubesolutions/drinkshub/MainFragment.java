package ng.com.iqubesolutions.drinkshub;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.com.iqubesolutions.drinkshub.adapter.RecyclerAdapter;
import ng.com.iqubesolutions.drinkshub.helper.FeedClassUIHelper;
import ng.com.iqubesolutions.drinkshub.helper.FontChangeCrawler;
import ng.com.iqubesolutions.drinkshub.model.Item;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class MainFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerAdapter cursorAdapter;

    FeedClassUIHelper uiHelper;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private ArrayList<Item> items = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        uiHelper = new FeedClassUIHelper(view);

        fab = (FloatingActionButton) view.findViewById(R.id.fab_feed);
        recyclerView = (RecyclerView) view.findViewById( R.id.recyclerview );
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
               /* if(fab.isShown()) fab.hide();
                else fab.show();*/
            }
        });


        cursorAdapter = new RecyclerAdapter(getActivity(), null);
        cursorAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(cursorAdapter);

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
