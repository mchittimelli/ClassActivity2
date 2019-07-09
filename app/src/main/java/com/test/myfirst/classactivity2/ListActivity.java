package com.test.myfirst.classactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListActivity extends AppCompatActivity {
ArrayList<Pokemon> poke;
ListView lview;
    ListAdapt adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        poke=new ArrayList<>();
        lview=findViewById(R.id.list_pokemon);

        String link = getResources().getString(R.string.link);


        try {
            String myjson = new syncdata().execute(link).get();
            System.out.println("MainActivity :"+myjson);

            JSONObject mainObj = new JSONObject(myjson);

            JSONArray pokemons = mainObj.getJSONArray("Pokemon");


for (int i=0;i<pokemons.length();i++){

    JSONObject childObj = pokemons.getJSONObject(i);
    String name = childObj.getString("name");
    String image = childObj.getString("image");
    String type = childObj.getString("type");
    String ability = childObj.getString("ability");
    String height = childObj.getString("height");
    String weight = childObj.getString("weight");
    String description= childObj.getString("description");
poke.add(new Pokemon(name,image,type,ability,height,weight,description));


}
            adapt = new ListAdapt(getApplicationContext(),poke);

            lview.setAdapter(adapt);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(ListActivity.this,pokemondesc.class);

                    i.putExtra("data",poke.get(position));
                    startActivity(i);

                }
            });



        } catch (ExecutionException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
