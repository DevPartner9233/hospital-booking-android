package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Patient_ShowBookedAppointmentActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView recyclerView;

    private String key = "";

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__show_booked_appointment);

        mToolbar = (Toolbar) findViewById(R.id.show_bookedAppointment);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Booked Appointments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.show_Appointment_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        Query query = mDatabase.child("Booked_Appointments").child(mAuth.getCurrentUser().getUid());

        FirebaseRecyclerOptions<BookedAppointmentList> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<BookedAppointmentList>()
                .setQuery(query, BookedAppointmentList.class)
                .build();

        FirebaseRecyclerAdapter<BookedAppointmentList, BookedAppointmentsVH> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<BookedAppointmentList, BookedAppointmentsVH>(firebaseRecyclerOptions){

                    @Override
                    public BookedAppointmentsVH onCreateViewHolder(ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.single_booked_appointment,parent,false);
                        return new BookedAppointmentsVH(view);
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull final BookedAppointmentsVH holder, final int position, @NonNull final BookedAppointmentList model) {


                        holder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                key = getRef(position).getKey().toString();
                                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "KEY = "+key, Toast.LENGTH_SHORT).show();

                            }
                        });
                        mDatabase.child("Doctor_Details").child( model.getDoctor_ID().toString()).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String doctorID = model.getDoctor_ID().toString();
                                //Toast.makeText(Patient_ShowBookedAppointmentActivity.this,doctorID, Toast.LENGTH_SHORT).show();

                                String doctorName = dataSnapshot.child("Name").getValue(String.class);

                                holder.setDoctorName(doctorName);
                                holder.setDate(model.getDate());
                                holder.setTime(model.getTime());
                                //Toast.makeText(Patient_ShowBookedAppointmentActivity.this,position +" "+ doctorName, Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public class BookedAppointmentsVH extends RecyclerView.ViewHolder{

        View mView;

        public BookedAppointmentsVH(View itemView) {
            super(itemView);

            mView = itemView;

            ImageView cancelAppointment = (ImageView) mView.findViewById(R.id.cancel_bookedAppointment);
            cancelAppointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "Cancel Appointment Clicked=="+key, Toast.LENGTH_SHORT).show();

                    mDatabase.child("Booked_Appointment").child(mAuth.getCurrentUser().getUid()).child(key).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Patient_ShowBookedAppointmentActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });
        }


        public void setDoctorName(String doctorName) {
            TextView name = (TextView) findViewById(R.id.single_doctorName);
            name.setText(doctorName);
        }

        public void setTime(String time) {

            TextView appointmentTime = (TextView) findViewById(R.id.single_time);
            appointmentTime.setText(time);
        }

        public void setDate(String date) {

            TextView appointmentDate = (TextView) findViewById(R.id.single_date);
            appointmentDate.setText(date);
        }
    }
}
