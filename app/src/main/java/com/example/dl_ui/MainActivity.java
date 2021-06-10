package com.example.dl_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView name, age, dose1date, dose2date, dose1code, dose2code, vaccineName, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.ll);
        LinearLayout linearLayout1 = findViewById(R.id.ll1);
        TableLayout tableLayout = findViewById(R.id.tl1);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject userData = jsonArray.getJSONObject(i);

                TableRow tableRow = new TableRow(MainActivity.this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                try {
                    tableRow.setGravity(Gravity.CENTER);
                    TextView name = new TextView(MainActivity.this);
                    name.setText(userData.getString("name"));
                    name.setTextColor(Color.WHITE);
                    name.setTypeface(null, Typeface.BOLD);
                    name.setTextSize(18);
                    name.setGravity(Gravity.CENTER);
                    layoutParams.setMargins(0,30,0,0);
                    name.setLayoutParams(layoutParams);
                    tableRow.addView(name);

                }catch (Exception e){
                    e.printStackTrace();
                }


                TableRow tableRow1 = new TableRow(MainActivity.this);
                TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                try {
                    tableRow1.setGravity(Gravity.CENTER);
                    TextView age = new TextView(MainActivity.this);
                    age.setText(userData.getString("age"));
                    age.setTextColor(Color.WHITE);
                    age.setGravity(Gravity.CENTER);
                    layoutParams1.setMargins(0,4,0,0);
                    age.setLayoutParams(layoutParams1);
                    tableRow1.addView(age);

                }catch (Exception e){
                    e.printStackTrace();
                }

                TableRow tableRow2 = new TableRow(MainActivity.this);
                TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                try {
                    tableRow2.setGravity(Gravity.CENTER);
                    TextView dose1 = new TextView(MainActivity.this);
                    dose1.setText(userData.getString("dose1"));
                    dose1.setTextColor(Color.WHITE);
                    dose1.setTypeface(null, Typeface.BOLD);
                    dose1.setTextSize(18);
                    layoutParams3.setMargins(0,80,0,30);
                    dose1.setLayoutParams(layoutParams3);
                    dose1.setGravity(Gravity.CENTER);
                    tableRow2.addView(dose1);

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    TextView dose2 = new TextView(MainActivity.this);
                    dose2.setText(userData.getString("dose2"));
                    dose2.setTextColor(Color.WHITE);
                    dose2.setTypeface(null, Typeface.BOLD);
                    dose2.setTextSize(18);
                    layoutParams3.setMargins(0,80,0,30);
                    dose2.setLayoutParams(layoutParams3);
                    dose2.setGravity(Gravity.CENTER);
                    tableRow2.addView(dose2);

                }catch (Exception e){
                    e.printStackTrace();
                }


                TableRow tableRow3 = new TableRow(MainActivity.this);
                TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                try {
                    tableRow3.setGravity(Gravity.CENTER);
                    TextView dose1date = new TextView(MainActivity.this);
                    dose1date.setText(userData.getString("dose1date"));
                    dose1date.setTextColor(Color.WHITE);
                    dose1date.setTextSize(13);
                    layoutParams4.setMargins(0,0,0,0);
                    dose1date.setLayoutParams(layoutParams4);
                    dose1date.setGravity(Gravity.CENTER);
                    tableRow3.addView(dose1date);

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    TextView dose2date = new TextView(MainActivity.this);
                    dose2date.setText(userData.getString("dose2date"));
                    dose2date.setTextColor(Color.WHITE);
                    dose2date.setTextSize(13);
                    layoutParams4.setMargins(0,0,0,0);
                    dose2date.setLayoutParams(layoutParams4);
                    dose2date.setGravity(Gravity.CENTER);
                    tableRow3.addView(dose2date);

                }catch (Exception e){
                    e.printStackTrace();
                }


                TableRow tableRow4 = new TableRow(MainActivity.this);
                try {
                    tableRow4.setGravity(Gravity.CENTER);
                    TextView dose1code = new TextView(MainActivity.this);
                    dose1code.setText(userData.getString("dose1code"));
                    dose1code.setTextColor(Color.WHITE);
                    dose1code.setTextSize(13);
                    dose1code.setGravity(Gravity.CENTER);
                    tableRow4.addView(dose1code);

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    TextView dose2code = new TextView(MainActivity.this);
                    dose2code.setText(userData.getString("dose2code"));
                    dose2code.setTextColor(Color.WHITE);
                    dose2code.setTextSize(13);
                    dose2code.setGravity(Gravity.CENTER);
                    tableRow4.addView(dose2code);

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    TextView vaccineName = new TextView(MainActivity.this);
                    vaccineName.setText(userData.getString("vaccineName"));
                    vaccineName.setTextColor(Color.BLACK);
                    vaccineName.setTextSize(26);
                    vaccineName.setTypeface(null,Typeface.BOLD);
                    vaccineName.setGravity(Gravity.CENTER);
                    linearLayout1.addView(vaccineName);

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    TextView status = new TextView(MainActivity.this);
                    status.setText(userData.getString("status"));
                    status.setTextColor(Color.GREEN);
                    status.setGravity(Gravity.CENTER);
                    status.setTypeface(null, Typeface.BOLD);
                    status.setTextSize(16);
                    params1.bottomMargin = 30;
                    status.setLayoutParams(params1);
                    linearLayout1.addView(status);

                }catch (Exception e){
                    e.printStackTrace();
                }


                tableLayout.addView(tableRow);
                tableLayout.addView(tableRow1);
                tableLayout.addView(tableRow2);
                tableLayout.addView(tableRow3);
                tableLayout.addView(tableRow4);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String JsonDataFromAsset() {

        String json = null;

        try {

            InputStream inputStream = getAssets().open("user.json");
            int size = inputStream.available();
            byte[] bufferData = new byte[size];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData,"UTF-8");


        }catch (Exception e){
            e.printStackTrace();
        }

        return json;
    }
}