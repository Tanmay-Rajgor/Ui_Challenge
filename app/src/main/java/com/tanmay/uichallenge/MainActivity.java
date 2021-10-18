package com.tanmay.uichallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ImageView imageView;
    private EditText editTextTextPersonName, editTextTextPersonName2,editTextTextEmailAddress, editTextTextPassword;
    private Button button,button2;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked to Choose Image", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }

    private void initRegister(){
        if(validateData()){
           if(checkBox.isChecked()){
               showSnackBar();
           } else {
               Toast.makeText(MainActivity.this, "You need to agree to the licence agreement", Toast.LENGTH_SHORT).show();
           }
        }
    }

    private void showSnackBar(){
        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    private boolean validateData(){
        if(editTextTextPersonName.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please Enter Your First Name Before Submitting", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editTextTextPersonName2.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please Enter Your Last Name Before Submitting", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editTextTextEmailAddress.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please Enter Your Email Address Before Submitting", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(editTextTextPassword.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please Enter Your Password Before Submitting", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initViews(){
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
    }
}