package com.example.dl_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ArrayList<Model> arrayList = new ArrayList<>();
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.ll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tableLayout = findViewById(R.id.tbl);


        TextView title = new TextView(MainActivity.this);
        String ti = null;
        String image = null;
        String footer = null;

        try {
            InputStream inputStream = getAssets().open("templetes.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.normalize();


            NodeList nodeList=document.getElementsByTagName("*");
            int j=0;
            for (int i=0; i<nodeList.getLength(); i++){
                Element nodes = (Element) nodeList.item(i);

                if (nodes.getTagName().equals("Label")){

                    ti = nodes.getTextContent();
                    if (!nodes.getAttribute("color").equals(null)){
                        title.setTextColor(Color.parseColor(nodes.getAttribute("color")));
                    }
                    if (!nodes.getAttribute("fontsize").equals(null)){
                        title.setTextSize(Integer.parseInt(nodes.getAttribute("fontsize")));
                    }
                    if (!nodes.getAttribute("style").equals(null)){
                        title.setTypeface(null, Typeface.BOLD);
                    }

                }
                if (nodes.getTagName().equals("Table")){
                    j = i + 1;
                    break;
                }
            }

            for (int i=j; i<nodeList.getLength(); i++)
            {
                String row = null,col = null,text = null,color = null, font = null,
                        style = null,card = null;
                Boolean check = false;
                Element element = (Element)nodeList.item(i);
                if (element.getTagName().equals("Row")){
                    row = String.valueOf(element.getNodeName());
                    Log.e("data", "tags: " + element.getNodeName());

                }
                if (element.getTagName().equals("Footer")){
                    footer = element.getTextContent();
                    Log.e("data", "footer: " +footer);
                }

                if (element.getTagName().equals("Img")){
                    image = element.getTextContent();
                    Log.e("data", "img: " + image);
                }

                if (element.getTagName().equals("Col")){
                    col = String.valueOf(element.getNodeName());
                    Log.e("data", "tags: " + element.getNodeName());
                }

                if (element.getTagName().equals("Label")){
                    if (!element.getAttribute("color").equals(null)){
                        color = String.valueOf(element.getAttribute("color"));
                    }
                    if (!element.getAttribute("fontsize").equals(null)){
                        font = String.valueOf(element.getAttribute("fontsize"));
                    }
                    if (!element.getAttribute("style").equals(null)){
                        style = String.valueOf(element.getAttribute("style"));
                    }

                    Element tagcheck = (Element) nodeList.item(i-1);
                    if (tagcheck.getTagName().equals("Header")){
                        Element cardcheck = (Element) nodeList.item(i-2);
                        if (cardcheck.getTagName().equals("Card")){
                            check = true;
                            Log.e("data", "check: " + check);
                        }
                    }else if (tagcheck.getTagName().equals("Content")){
                        Element cardcheck = (Element) nodeList.item(i-4);
                        if (cardcheck.getTagName().equals("Card")){
                            check = true;
                            Log.e("data", "check: " + check);
                        }
                    }

//                    Log.e("data", "check: " + check);
                    text = element.getTextContent();
                    Model model = new Model(image,color,font,style,row,col,text,check);
                    arrayList.add(model);
                    Log.e("data", "text: " + element.getTextContent());
                    image = null;
                }else{
                    continue;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject userData = jsonArray.getJSONObject(i);

                title.setText(userData.getString(ti));
                TableLayout.LayoutParams layoutParams1 = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
                title.setShadowLayer(10,10,10,Color.DKGRAY);
                layoutParams1.setMargins(0,100,0,60);
                title.setLayoutParams(layoutParams1);
                title.setGravity(Gravity.CENTER);
                tableLayout.addView(title);

                for (int j=0;j<arrayList.size();j++){

                    Boolean cardcheck = false, colcheck = false;
                    Log.e("data", "check: " +arrayList.get(j).getCard());
                    CardView cardView = new CardView(MainActivity.this);
                    TableRow tableRow = new TableRow(MainActivity.this);
                    TableRow tableRow1 = new TableRow(MainActivity.this);
                    TextView textView = new TextView(MainActivity.this);
                    TextView textView1 = new TextView(MainActivity.this);
                    TextView textView2 = new TextView(MainActivity.this);
                    TextView textView3 = new TextView(MainActivity.this);
                    TableLayout.LayoutParams layoutParams3 = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

                    if (!String.valueOf(arrayList.get(j).getRow()).equals(null)){

                        if (arrayList.get(j).getCard()){
                            cardView.setCardBackgroundColor(Color.WHITE);
                            cardView.setCardElevation(30);
                            cardcheck = true;
                        }

                        textView.setText(userData.getString(arrayList.get(j).getCol1text1()));
                        if (arrayList.get(j).getCol1text1().equals("dose1")){
                            colcheck = true;
                            String data = userData.getString(arrayList.get(j+4).getCol1text1()) + "\n" +
                                    userData.getString(arrayList.get(j+5).getCol1text1());
                            String data1 = userData.getString(arrayList.get(j+1).getCol1text1()) + "\n" +
                                    userData.getString(arrayList.get(j+2).getCol1text1());
                            Log.e("data", "nxt: " + data);
                            textView2.setText(data);
                            textView2.setGravity(Gravity.CENTER);
                            textView2.setTextColor(Color.parseColor(arrayList.get(j+1).getColor()));
                            textView2.setTextSize(Integer.parseInt(arrayList.get(j+1).getFont()));
                            textView3.setText(data1);
                            textView3.setGravity(Gravity.CENTER);
                            textView3.setTextColor(Color.parseColor(arrayList.get(j+1).getColor()));
                            textView3.setTextSize(Integer.parseInt(arrayList.get(j+1).getFont()));
                            textView1.setText(userData.getString(arrayList.get(j+3).getCol1text1()));
                        }

                        if (!arrayList.get(j).getColor().equals(null)){
                            textView.setTextColor(Color.parseColor(arrayList.get(j).getColor()));
                            textView1.setTextColor(Color.parseColor(arrayList.get(j).getColor()));

                        }

                        if (!arrayList.get(j).getFont().equals(null)){
                            textView.setTextSize(Integer.parseInt(arrayList.get(j).getFont()));
                            textView1.setTextSize(Integer.parseInt(arrayList.get(j).getFont()));

                        }

                        if (arrayList.get(j).getStyle().equals("BOLD")){
                            textView.setTypeface(null, Typeface.BOLD);
                            textView1.setTypeface(null, Typeface.BOLD);
                        }

                        textView.setGravity(Gravity.CENTER);
                        textView1.setGravity(Gravity.CENTER);
                        tableRow.setGravity(Gravity.CENTER);


                        Log.e("data", "image: " + arrayList.get(j).getImg());
                        if (!String.valueOf(arrayList.get(j).getImg()).equals("null")){
                            int imageResource = getResources().getIdentifier(arrayList.get(j).getImg(),null,getPackageName());
                            ImageView imageView = new ImageView(MainActivity.this);
                            Drawable res = getResources().getDrawable(imageResource);
                            TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(600, 600);
                            imageView.setLayoutParams(layoutParams2);
                            imageView.setImageDrawable(res);
                            tableLayout.addView(imageView);
                            arrayList.get(j).setImg(null);
                        }

                        if (cardcheck){
                            cardView.addView(textView);
                            tableLayout.addView(cardView);
                        }else if (colcheck){
                            layoutParams3.setMargins(0,60,0,0);
                            tableRow.setLayoutParams(layoutParams3);
                            tableRow.addView(textView);
                            tableRow.addView(textView1);
                            tableRow1.addView(textView2);
                            tableRow1.addView(textView3);
                            tableRow1.setGravity(Gravity.CENTER);
                            tableLayout.setGravity(Gravity.CENTER);
                            tableLayout.addView(tableRow);
                            tableLayout.addView(tableRow1);
                            j = j+5;
                            continue;
                        }else{
                            tableRow.addView(textView);
                            tableLayout.addView(tableRow);
                        }
                    }
                }

                Log.e("aaa", "footerimg: " + footer);
                int imgResource = getResources().getIdentifier(footer.trim(),null,getPackageName());
                ImageView img = new ImageView(MainActivity.this);
                Drawable re = getResources().getDrawable(imgResource);
                TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(210, 210);
                img.setLayoutParams(layoutParams3);
                img.setImageDrawable(re);
                tableLayout.addView(img);

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