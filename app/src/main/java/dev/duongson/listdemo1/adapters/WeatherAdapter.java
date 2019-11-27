package dev.duongson.listdemo1.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dev.duongson.listdemo1.R;
import dev.duongson.listdemo1.models.WeatherModel;

public class WeatherAdapter extends BaseAdapter {
    List<WeatherModel> weathers;
    Context context;
    int layout;

    public WeatherAdapter(List<WeatherModel> weathers, Context context, int layout) {
        this.weathers = weathers;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return weathers.size();
    }

    @Override
    public Object getItem(int position) {
        return weathers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        WeatherModel weather = (WeatherModel) getItem(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(layout,null, true);
        ImageView img = view.findViewById(R.id.imgWeather);
        TextView tvDay = view.findViewById(R.id.tvDay);
        TextView tvStatus = view.findViewById(R.id.tvStatus);
        img.setImageResource(weather.getImg());
        tvDay.setText(weather.getDay());
        tvStatus.setText(weather.getStatus());
        return view;
    }
}
