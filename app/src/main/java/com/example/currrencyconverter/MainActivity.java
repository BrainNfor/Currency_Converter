package com.example.currrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_from, spinner_to;
    private  EditText editText_amount;
    private Button button_convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_from = findViewById(R.id.spinner_from);
        spinner_to = findViewById(R.id.spinner_to);
        editText_amount = findViewById(R.id.edittext_amount);
        button_convert = findViewById(R.id.button_convert);

        String [] from = {"Usd"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        spinner_from.setAdapter(ad1);

        String [] to = {"Fcfa", "Naira","Euros"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        spinner_to.setAdapter(ad2);

        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double final_covertion;
                Double amount = Double.parseDouble(editText_amount.getText().toString());

                if (spinner_from.getSelectedItem().toString() == "Usd" && spinner_to.getSelectedItem().toString() == "Fcfa"){
                    final_covertion = amount * 650;
                    Toast.makeText(getApplicationContext(), final_covertion.toString(), Toast.LENGTH_LONG).show();
                }
                if (spinner_from.getSelectedItem().toString() == "Usd" && spinner_to.getSelectedItem().toString() == "Naira"){
                    final_covertion = amount * 350;
                    Toast.makeText(getApplicationContext(), final_covertion.toString(), Toast.LENGTH_LONG).show();
                }
                if (spinner_from.getSelectedItem().toString() == "Usd" && spinner_to.getSelectedItem().toString() == "Euros"){
                    final_covertion = amount/50;
                    Toast.makeText(getApplicationContext(), final_covertion.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}