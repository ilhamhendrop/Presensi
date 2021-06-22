package com.example.gom247.presensi5;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gom247.presensi5.Api.BaseApiService;
import com.example.gom247.presensi5.Api.UtilsApi;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Absen extends AppCompatActivity {

    Button presensi;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        presensi = (Button)findViewById(R.id.btAbsen);


        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();

        presensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                absen();
            }
        });
    }

    private void absen() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Absen.this);
        dialog.setCancelable(false);
        dialog.setTitle("Informasi");
        dialog.setMessage("Apakah anda yakin akan melakukan Presensi");

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mApiService.simpanPresensi("15.11.8482").enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(Absen.this, "Presensi Berhasil", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Absen.this, "Presensi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create().show();
    }
}
