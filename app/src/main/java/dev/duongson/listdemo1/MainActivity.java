package dev.duongson.listdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import dev.duongson.listdemo1.adapters.WeatherAdapter;
import dev.duongson.listdemo1.models.WeatherModel;

public class MainActivity extends AppCompatActivity {
    ListView lvWearther;
    Button btnDel;
    WeatherAdapter weatherAdapter;
    List<WeatherModel> weathers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addWeatherDemo();

        weatherAdapter = new WeatherAdapter(weathers, this, R.layout.line_weather);
        lvWearther.setAdapter(weatherAdapter);

        lvWearther.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                WeatherModel w = weathers.get(position);
                weathers.remove(position);
                weatherAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Delete " + w.getDay(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                for (int i = 0; i < weathers.size(); i++){
                    View view = lvWearther.getChildAt(i);
                    CheckBox chk = view.findViewById(R.id.chkTick);
                    if (chk.isChecked()){
                        weathers.remove(i);
                        count++;
                    }
                }
                weatherAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Delete " + count, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addWeatherDemo() {
        weathers = new ArrayList<>();
        weathers.add(new WeatherModel(R.drawable.cloud, "Monday", "cloud"));
        weathers.add(new WeatherModel(R.drawable.partly, "Tuesday", "patly"));
        weathers.add(new WeatherModel(R.drawable.rain, "Wednesday", "rain"));
        weathers.add(new WeatherModel(R.drawable.snow, "Thirday", "snow"));
        weathers.add(new WeatherModel(R.drawable.stormy, "Friday", "stormy"));
    }

    private void addControls() {
        lvWearther = findViewById(R.id.lvWeather);
        btnDel = findViewById(R.id.btnDelete);
    }
}
