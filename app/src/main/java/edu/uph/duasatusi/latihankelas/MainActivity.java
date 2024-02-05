package edu.uph.duasatusi.latihankelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton clearButton = (ImageButton) findViewById(R.id.imageButtondelete);
        EditText editNameText = (EditText) findViewById(R.id.editNameText);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        CheckBox codingCheckBox = (CheckBox) findViewById(R.id.checkBoxcoding);
        CheckBox readingCheckBox = (CheckBox) findViewById(R.id.checkBoxreading);
        CheckBox travellingCheckBox = (CheckBox) findViewById(R.id.checkBoxtravelling);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editNameText.setText("");
                radioGroup.clearCheck();
                codingCheckBox.setChecked(false);
                readingCheckBox.setChecked(false);
                travellingCheckBox.setChecked(false);
            }
        });
        ImageButton saveButton = (ImageButton) findViewById(R.id.imageButtonadd);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "";
                RadioButton checkedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String hobi = "";
                if (codingCheckBox.isChecked()) {
                    hobi += "coding";
                }
                if (readingCheckBox.isChecked()) {
                    if (hobi != "") hobi += ",";
                    hobi += "reading";
                }
                if (travellingCheckBox.isChecked()) {
                    if (hobi != "") hobi += ",";
                    hobi += "travelling";
                }
                if (editNameText.getText().toString() == "" || checkedRadioButton == null || hobi == "") {
                    Toast.makeText(getApplication().getBaseContext(), "Harap lengkapi input terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication().getBaseContext(), "Berhasil Disimpan! Nama :" +
                                    editNameText.getText() + ", Gender:" + checkedRadioButton.getText()+", Hobi:" + hobi  ,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}