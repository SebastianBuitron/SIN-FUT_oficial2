package com.example.sin_fut_oficial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class logginNewAccount extends AppCompatActivity {

    Button btn_registrar;
    EditText nombre, correo, contraseña;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin_new_account);

        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correoelectronico);
        contraseña = findViewById(R.id.contrasena1);
        btn_registrar = findViewById(R.id.btn_registrar);
        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        btn_registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nombreUser = nombre.getText().toString().trim();
                String correoUser = correo.getText().toString().trim();
                String contraseñaUser = contraseña.getText().toString().trim();
                if (nombreUser.isEmpty() && contraseñaUser.isEmpty() && contraseñaUser.isEmpty()){
                    Toast.makeText(logginNewAccount.this, "complete los datos", Toast.LENGTH_SHORT).show();
                }else{
                    regitrarUsuario(nombreUser, correoUser, contraseñaUser);
                }

            }
        });

    }

    private void regitrarUsuario(String nombreUser, String correoUser, String contraseñaUser) {
        mAuth.createUserWithEmailAndPassword(correoUser, contraseñaUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("nombre",nombreUser);
                map.put("correo",correoUser);
                map.put("contraseña",contraseñaUser);

                mFirestore.collection("ususario").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(logginNewAccount.this, MainActivity.class));
                        Toast.makeText(logginNewAccount.this, "usuario registrado", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(logginNewAccount.this, "error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(logginNewAccount.this, "error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}