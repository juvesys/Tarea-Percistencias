package mx.com.mayernet.miscmascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.mayernet.miscmascotas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecundaryFragment extends Fragment {


    public SecundaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_secundary, container, false);
        return v;
    }

}
