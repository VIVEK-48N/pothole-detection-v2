package com.example.pothole_detection_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class detection_model extends AppCompatActivity {

    ImageView picture;
    TextView result, profileName;
    Button form , camera,logout2 ;
    FirebaseAuth mAuth;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection_model);
        picture = findViewById(R.id.picture);
        result = findViewById(R.id.result);
        form = findViewById(R.id.form);
        camera = findViewById(R.id.btn_camera);
        profileName = findViewById(R.id.profileName2);
        logout2 = findViewById(R.id.LogoutBtn2);


        //email and logout
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        if (account!=null){
            String personName = account.getEmail();
            profileName.setText(personName);
        }

        logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String str = intent.getStringExtra("homeAdd");

                Intent b1 = new Intent(detection_model.this,Form.class);
                b1.putExtra("ADDRESS",str);
                startActivity(b1);
            }
        });
    }
    void signout(){
        mAuth.signOut();
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(detection_model.this,MainActivity.class));
            }
        });
    }


}