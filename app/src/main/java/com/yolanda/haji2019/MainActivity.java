package com.yolanda.haji2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText edit_nama, edit_no, edit_alamat;
    Spinner spinner;
    String[] pilihan = {"Laki-laki", "Perempuan"};
    Button btn_simpan, btn_tampilkan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nama = findViewById(R.id.edit_nama);
        edit_no = findViewById(R.id.edit_no);
        edit_alamat = findViewById(R.id.edit_alamat);

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_tampilkan = findViewById(R.id.btn_tampilkan);

        spinner = findViewById(R.id.pilihan);
    }

    private void tambahHaji(){
        final String name = edit_nama.getText().toString().trim();
        final String no = edit_no.getText().toString().trim();
        final String alamat = edit_alamat.getText().toString().trim();
        final String jk = spinner.getSelectedItem().toString();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA,name);
                params.put(Konfigurasi.KEY_NOHP,no);
                params.put(Konfigurasi.KEY_ALAMAT, alamat);
                params.put(Konfigurasi.KEY_JK,jk);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btn_simpan){
            tambahHaji();
        }

        if(v == btn_tampilkan){
            startActivity(new Intent(this,TampilDataHaji.class));
        }
    }

}
