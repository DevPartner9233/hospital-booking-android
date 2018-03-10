package com.example.aman.hospitalappointy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

/**
 * Created by Aman on 14-Feb-18.
 */

public class Fragment_Doctor extends Fragment {

    private EditText mSearchText;
    private TextInputLayout mSearch;
    private RecyclerView mDoctorList;
    //private VerticalRecyclerViewFastScroller mFastScroller;

    private DatabaseReference mDatabase;


    public Fragment_Doctor(){
        //Required Empty public constructor otherwise app will crash
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_doctor,container,false);

        mDoctorList = (RecyclerView) rootView.findViewById(R.id.doctor_recyclerView);
        mDoctorList.setHasFixedSize(true);
        mDoctorList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        mSearch = (TextInputLayout) rootView.findViewById(R.id.search_by_doctor);
        mSearchText =(EditText) rootView.findViewById(R.id.doctor_searchtxt);

        mSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onStart();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onStart();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                onStart();
            }
        });

//        mFastScroller = (VerticalRecyclerViewFastScroller)rootView.findViewById(R.id.fast_scroller);
//        mFastScroller.setRecyclerView(mDoctorList);
//        mDoctorList.setOnScrollListener(mFastScroller.getOnScrollListener());


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        String search = mSearch.getEditText().getText().toString();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Patient_Details");

        Query query = mDatabase.orderByChild("Name").startAt(search).endAt(search +"\uf8ff");

        FirebaseRecyclerOptions<DoctorList> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<DoctorList>()
                .setQuery(query, DoctorList.class)
                .build();

        FirebaseRecyclerAdapter<DoctorList, DoctorListViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<DoctorList, DoctorListViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull DoctorListViewHolder holder, int position, @NonNull final DoctorList model) {

                holder.setName(model.getName());
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),model.getName(),Toast.LENGTH_LONG).show();
                    }
                });

            }

            @Override
            public DoctorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.doctorlist_item_layout, parent,false);

                return new DoctorListViewHolder(view);
            }
        };

        mDoctorList.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();

    }

    public class DoctorListViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public DoctorListViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }


        public void setName(String name) {

            TextView userName = (TextView) mView.findViewById(R.id.doctor_name);
            userName.setText(name);

        }
    }
}
