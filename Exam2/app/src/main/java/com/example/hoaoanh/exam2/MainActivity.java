package com.example.hoaoanh.exam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final double USD2VND = 22770.15;
    private final double VND2USD = 0.0000439171;
    private final double USD2EUR = 0.81377;
    String[] items = new String[]{"USD/VND","VND/USD","USD/EURO"};

    EditText editInput;
    EditText editOutput;
    Button btnReset;
    Button btnConvert;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput = (EditText)findViewById(R.id.editInput);
        editOutput = (EditText)findViewById(R.id.editOutput);

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editInput.setText("");
                editOutput.setText("");
            }
        });

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpStr = editInput.getText().toString();
                double input = Double.parseDouble(inpStr);
                if (spinner.getSelectedItem().toString() == "USD/EURO") {
                	String output = String.valueOf(input/USD2EUR);
                	editOutput.setText(output);
                }
                else if (spinner.getSelectedItem().toString() == "VND/USD") {
                	String output = String.valueOf(input/VND2USD);
                	editOutput.setText(output);
                }
                else {
                	String output = String.valueOf(input/USD2VND);
                	editOutput.setText(output);
                }

            }
        });

    }
}
