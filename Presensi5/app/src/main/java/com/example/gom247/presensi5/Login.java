package com.example.gom247.presensi5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gom247.presensi5.Api.BaseApiService;
import com.example.gom247.presensi5.Api.UtilsApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private Button login;
    private EditText nim, pass;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.btLogin);
        nim = (EditText)findViewById(R.id.edNimss);
        pass = (EditText)findViewById(R.id.edPassword);
        mAuth = FirebaseAuth.getInstance();

        mApiService = UtilsApi.getAPIServiceLogin();

        /*mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    //startActivity(new Intent(getApplicationContext(), Presensi.class));
                    Intent i = new Intent(Login.this, Presensi.class);
                    startActivity(i);
                    finish();

                }
            }
        };*/



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent it = new Intent(Login.this, content_drawlayout.class);
                Bundle b = new Bundle();
                b.putString("parse_nim", Nim);
                it.putExtras(b);
                startActivity(it);

                startSignIn();*/

                prosesLogin();

            }


        });

    }

    /*@Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }*/

    private void prosesLogin() {
        String Nim = nim.getText().toString();
        String Password = pass.getText().toString();

        /*if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)){
            Toast.makeText(this, "username dan password wajib di isi", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                        pass.setText("");
                    }
                }
            });
        }*/

        mApiService.loginRequest(Nim, Password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
             if (response.isSuccessful()){
                 Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(), Presensi.class));
                 finish();
             } else {
                 Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
             }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }


}


