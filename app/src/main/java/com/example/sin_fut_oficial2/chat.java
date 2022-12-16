package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {

    private RecyclerView rvMensajes;
    private EditText etName;
    private EditText etMensaje;
    private Button btnButton;

    private List<MensajeVO> lstMensajes;
    private adapterRvme mAdapterRvme;

    private void setComponents(){
        rvMensajes = findViewById(R.id.rvMensajes);
        etName = findViewById(R.id.etName);
        etMensaje = findViewById(R.id.etMensaje);
        btnButton = findViewById(R.id.btnButton);

        lstMensajes = new ArrayList<>();
        mAdapterRvme = new adapterRvme(lstMensajes);
        rvMensajes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMensajes.setAdapter(mAdapterRvme);
        rvMensajes.setHasFixedSize(true);

        FirebaseFirestore.getInstance().collection( "char").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
                for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()){
                    if (documentChange.getType() == DocumentChange.Type.ADDED )
                    {
                        lstMensajes.add(documentChange.getDocument().toObject(MensajeVO.class));
                        mAdapterRvme.notifyDataSetChanged();
                        rvMensajes.smoothScrollToPosition(lstMensajes.size());
                    }
                }
            }
        });
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.length() == 0 || etMensaje.length() == 0)
                    return;
                MensajeVO mensajeVO = new MensajeVO();
                mensajeVO.setMessage(etMensaje.getText().toString());
                mensajeVO.setName(etName.getText().toString());
                FirebaseFirestore.getInstance().collection("chat").add(mensajeVO);
                etMensaje.setText("");
                etName.setText("");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setComponents();

    }
}