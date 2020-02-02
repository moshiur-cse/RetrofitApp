package com.moshiurcse.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.moshiurcse.myapplication.flowers.Flower;
import com.moshiurcse.myapplication.flowers.FlowerAdapter;
import com.moshiurcse.myapplication.flowers.FlowerServiceApi;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL="http://services.hanselandpetal.com/";
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.flowerRV);

        final Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final FlowerServiceApi serviceApi=retrofit.create(FlowerServiceApi.class);
        serviceApi.getAllFlowers().enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if(response.isSuccessful()){
                    List<Flower> flowerList=response.body();

                    Log.e("flower","Respone"+flowerList.size());

                    FlowerAdapter adapter=new FlowerAdapter(MainActivity.this,flowerList);
                    LinearLayoutManager llm=new LinearLayoutManager(MainActivity.this);

                    GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2);


                    recyclerView.setLayoutManager(glm);
                    recyclerView.setAdapter(adapter);


                }


                }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                Log.e("flower","Failer: "+t.getLocalizedMessage());

            }
        });
    }
}
