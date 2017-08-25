package enc.test.splashscreenexample;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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
        Picasso.with(ImageZoom.this).load(image).into(photoView);

    }


}
