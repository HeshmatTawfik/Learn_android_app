package com.heshmat.learnandroid.userui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heshmat.learnandroid.DatabaseAdapter;
import com.heshmat.learnandroid.R;
import com.heshmat.learnandroid.TopicAdapter;
import com.heshmat.learnandroid.models.Topic;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopicsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.topicsRv)
    RecyclerView topicsRv;
    TopicAdapter mAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopicsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopicsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopicsFragment newInstance(String param1, String param2) {
        TopicsFragment fragment = new TopicsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static TopicsFragment newInstance() {

        return new TopicsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    DatabaseAdapter mDatabaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topics, container, false);
        ButterKnife.bind(this, view);
        mDatabaseAdapter = DatabaseAdapter.getDatabaseAdapter(this.getContext());
        List<Topic> topics = mDatabaseAdapter.getTopics();
        mAdapter = new TopicAdapter(topics, this.getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        topicsRv.setLayoutManager(mLayoutManager);
        topicsRv.setAdapter(mAdapter);


        return view;
    }
}
