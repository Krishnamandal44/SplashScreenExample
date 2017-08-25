package enc.test.splashscreenexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

/**
 * Created by pc41 on 26-07-2017.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final String[] Imageid;

    public CustomGridAdapter(Context c, String[] web, String[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.rowitem, null);
            TextView textView = (TextView) grid.findViewById(R.id.tv);
            ImageView imageView = (ImageView)grid.findViewById(R.id.iv);
            textView.setText(web[position]);
//            imageView.setImageResource(Integer.parseInt(Imageid[position]));
            String url = Imageid[position];
            //Picasso.with(mContext).load(url).into(imageView);
            Ion.with(imageView)
                    .placeholder(R.drawable.placeholder)//image when loading
                    .error(R.drawable.error)                            //image if error/ no connection/ wrong url etc
                    //uncomment this line and set imageURL with wrong URL and see error image animation
//                .animateLoad(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spin_animation))
                    //this defines animation of the successfully loaded image (animate it in)
                    .animateIn(AnimationUtils.loadAnimation(mContext,R.anim.anim_fade_in))
                    .load(url);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
