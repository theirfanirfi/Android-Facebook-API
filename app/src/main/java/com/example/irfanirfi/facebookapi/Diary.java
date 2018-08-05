package com.example.irfanirfi.facebookapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Diary extends AppCompatActivity {
    EditText titlee,textt;
    Button btn, getbtn,remove;
    Database db;
    Context context;
    TextView tx;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        titlee = (EditText) findViewById(R.id.title);
        textt = (EditText) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.add);
        getbtn = (Button) findViewById(R.id.getSharedP);
        remove = (Button) findViewById(R.id.removeSharedP);
        db = new Database(Diary.this);
        preferences = getSharedPreferences("Login",Context.MODE_PRIVATE);
        editor = preferences.edit();
      //  tx = (TextView) findViewById(R.id.display);

    // fetch();
        context = this;

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("user_id");
                editor.remove("username");
                editor.commit();
                editor.apply();
            }
        });

        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getid = preferences.getInt("user_id",0);
                String uname = preferences.getString("username","");
                if(getid == 0)
                {
                    Toast.makeText(Diary.this,"VALUES IS ZERO : "+getid,Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Diary.this,"Name :  "+uname+ "  ID: "+Integer.toString(getid),Toast.LENGTH_LONG).show();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    String t = titlee.getText().toString();
//                    String tex = textt.getText().toString();
//                    boolean b = db.insert(t, tex);
//                    if (b) {
//                        fetch();
//                        Toast.makeText(Diary.this, "Inserted", Toast.LENGTH_LONG).show();
//
//                    } else {
//                        Toast.makeText(Diary.this, "Not Inserted", Toast.LENGTH_LONG).show();
//
//                    }
//                }catch(Exception e)
//                {
//                    Toast.makeText(Diary.this, e.toString(), Toast.LENGTH_LONG).show();
//
//                }

                int  id = 2;
                editor.putInt("user_id",id);
                editor.putString("username","xyz");
                editor.commit();
                editor.apply();
            }
        });
    }

    private void fetch()
    {
        Cursor r = db.getAllData();
        int rows = r.getCount();
        if(rows > 0)
        {
            StringBuffer buffer = new StringBuffer();
            while (r.moveToNext())
            {
                buffer.append("ID : "+r.getInt(0)+ " Title : "+r.getString(1)+"\n" +" Description : "+r.getString(2));
            }
            tx.setText(buffer.toString());
        }
    }
}
