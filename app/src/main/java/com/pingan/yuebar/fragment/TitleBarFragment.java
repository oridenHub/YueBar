package com.pingan.yuebar.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pingan.yuebar.R;

public class TitleBarFragment extends Fragment {

    private TextView mTitleName;

    // TODO: Rename and change types and number of parameters
    public static TitleBarFragment newInstance(String param1, String param2) {
        TitleBarFragment fragment = new TitleBarFragment();
        return fragment;
    }

    public TitleBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_title_bar, container, false);

        mTitleName = (TextView) view.findViewById(R.id.title_name);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // 设置标题名称
    public void setTitleName(String titleName) {
        mTitleName.setText(titleName);
    }

}
