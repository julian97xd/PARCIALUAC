package com.julian.parcialJulian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.julian.parcialJulian.Contact;
import com.julian.parcialandroid.R;

public class actividad_add extends AppCompatActivity {

    private Spinner spinGroup;
    private EditText edtName, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        initViews();
        initListeners();
    }

    private void initViews(){
        spinGroup = findViewById(R.id.spinner);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
    }

    private void initListeners(){

        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkForm()){
                    Contact contact = new Contact(
                            edtName.getText().toString(),
                            edtPhone.getText().toString(),
                            spinGroup.getItemAtPosition(spinGroup.getFirstVisiblePosition()).toString());

                    Intent intent = getIntent();
                    intent.putExtra("newPerson", contact);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        spinGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private boolean checkForm(){
        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("Ingrese un nombre");
            return false;
        }
        if (edtPhone.getText().toString().isEmpty()) {
            edtPhone.setError("Ingrese un número de teléfono");
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.limpiar_list:
                edtName.setText("");
                edtPhone.setText("");
                return true;
            case R.id.show:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

