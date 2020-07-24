package sg.edu.rp.c346.id19037610.mymovies;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);

        Movie currentItem = movieList.get(position);
        tvName.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear()+" - ");
        tvGenre.setText(currentItem.getGenre());

        String rating = currentItem.getRated();

        if(rating=="g"){
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(rating=="m18"){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else if(rating=="nc16"){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(rating=="pg"){
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(rating=="pg13"){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }else if(rating=="r21"){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
