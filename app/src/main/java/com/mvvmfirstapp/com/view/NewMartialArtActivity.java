package com.mvvmfirstapp.com.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mvvmfirstapp.com.R;

public class NewMartialArtActivity extends AppCompatActivity {
  Button btnSave;
  EditText etMartialArt,etName,etMobileNumber;
    public static final String NEW_MARTIAL_ART_KEY="com.mvvmfirstapp.com.GET_BACK_MARTIAL_ART";
    public static final String NEW_NAME_KEY="com.mvvmfirstapp.com.GET_BACK_NAME";
    public static final String NEW_MOBILE_NUMBER_KEY="com.mvvmfirstapp.com.GET_BACK_MOBILE_NUMBER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_martial_art);
        btnSave=findViewById(R.id.btnSaveMartialArt);
        etMartialArt=findViewById(R.id.etMartialArt);
        etName=findViewById(R.id.etName);
        etMobileNumber=findViewById(R.id.etMobileNumber);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getBackIntent=new Intent();
                if (TextUtils.isEmpty(etMartialArt.getText())){
                    setResult(RESULT_CANCELED,getBackIntent);

                }
                if (TextUtils.isEmpty(etName.getText())){
                    setResult(RESULT_CANCELED,getBackIntent);

                }
                if (TextUtils.isEmpty(etMobileNumber.getText())){
                    setResult(RESULT_CANCELED,getBackIntent);

                }else {
                    String favMA=etMartialArt.getText().toString();
                    String favMA2=etName.getText().toString();
                    String favMA3=etMobileNumber.getText().toString();
                    getBackIntent.putExtra(NEW_MARTIAL_ART_KEY,favMA);
                    getBackIntent.putExtra(NEW_NAME_KEY,favMA2);
                    getBackIntent.putExtra(NEW_MOBILE_NUMBER_KEY,favMA3);
                    setResult(RESULT_OK,getBackIntent);
                }
                finish();
            }
        });
    }
}