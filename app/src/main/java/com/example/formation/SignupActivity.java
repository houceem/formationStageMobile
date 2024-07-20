package com.example.formation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    private TextView btnin;
    private EditText name , mail ,numb , cin , pass , Cpass ;

    private Button Sup ;

    private String nameInput, mailI , numbI , cinI , passI , CpassI;

    private final String mailPattern ="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnin = findViewById(R.id.btnin);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        numb = findViewById(R.id.numb);
        cin = findViewById(R.id.cin);
        pass = findViewById(R.id.pass);
        Cpass = findViewById(R.id.Cpass);
        Sup = findViewById(R.id.Sup);


        btnin.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, SigninActivity.class));
        });

        Sup.setOnClickListener(v -> {


            if (Validate()){
               Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
          }



        });
    }

    private boolean Validate (){
        boolean res = false;

        nameInput = name.getText().toString().trim();
        mailI = mail.getText().toString().trim();
        numbI = numb.getText().toString().trim();
        cinI = cin.getText().toString().trim();
        passI = pass.getText().toString().trim();
        CpassI = Cpass.getText().toString().trim();

        if (nameInput.length()<7 || nameInput.length()==0){
            name .setError("name invalide");
        }
        else
            res=true;




        return res;
    }
}

