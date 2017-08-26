package enc.test.splashscreenexample;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;

public class ImageZoom extends AppCompatActivity  {



  String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhotoView photoView=new PhotoView(this);
        photoView.setMaximumScale(16f);
        setContentView(photoView);
        image=getIntent().getExtras().getString("image");
      //  Picasso.with(ImageZoom.this).load(image).into(photoView);
        Ion.with(photoView)
                .placeholder(R.drawable.placeholder)//image when loading
                .error(R.drawable.error)                            //image if error/ no connection/ wrong url etc
                //uncomment this line and set imageURL with wrong URL and see error image animation
//                .animateLoad(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spin_animation))
                //this defines animation of the successfully loaded image (animate it in)
                .animateIn(AnimationUtils.loadAnimation(ImageZoom.this,R.anim.anim_fade_in))
                .load(image);

    }


}
