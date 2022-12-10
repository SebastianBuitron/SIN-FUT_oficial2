package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

public class loggin extends AppCompatActivity {
    Button btn_login;
    EditText correo, contraseña;
    FirebaseAuth miAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        miAuth = FirebaseAuth.getInstance();
        correo.findViewById(R.id.correo1);
        contraseña.findViewById(R.id.contraseña1);
        btn_login.findViewById(R.id.btn_login1);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = correo.getText().toString().trim();
                String passUser = contraseña.getText().toString().trim();
                if (emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(loggin.this, "ingresar los datos", Toast.LENGTH_SHORT).show();
                }else {
                    loginUser(emailUser, passUser);
                }
            }
        });

    }


    private void loginUser(String emailUser, String passUser) {
        miAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(loggin.this, MainActivity.class));
                    Toast.makeText(loggin.this, "bienvenido", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(loggin.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(loggin.this, "error al inicar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}