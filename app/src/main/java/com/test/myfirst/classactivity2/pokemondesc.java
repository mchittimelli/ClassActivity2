package com.test.myfirst.classactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class pokemondesc extends AppCompatActivity {
    ImageView pimg;
    TextView pname,pdesc,pheight,ptype,pability,pweight,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemondesc);

        pimg = findViewById(R.id.desc_imag);
        pname = findViewById(R.id.desc_name);
        pdesc = findViewById(R.id.desc_desc);
        pheight=findViewById(R.id.desc_height);
        pweight=findViewById(R.id.desc_weight);
        ptype=findViewById(R.id.desc_type);
        pability=findViewById(R.id.desc_ability);

        Intent i = getIntent();
        Pokemon p= i.getParcelableExtra("data");
        Picasso.get().load(p.getPimgurl()).into(pimg);

       pname.setText(p.getPname());
       pdesc.setText(p.getDescription());
       pheight.setText(p.getPheight());
       pweight.setText(p.getPweight());
       ptype.setText(p.getPtype());
       pability.setText(p.getPability());

    }
}
