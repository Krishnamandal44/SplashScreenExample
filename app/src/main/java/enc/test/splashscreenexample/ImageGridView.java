package enc.test.splashscreenexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ImageGridView extends AppCompatActivity {
    GridView grid;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Stumbleupon",
            "Flickr",
            "Pinterest",
            "Quora",
            "Vimeo",
            "Twitter",
            "Facebook",
            "Gmail",
            "Stumbleupon",
            "Youtube"

    } ;
    String image[]={
        "https://www.w3schools.com/css/img_fjords.jpg",
        "https://i1.wp.com/techbeasts.com/wp-content/uploads/2016/12/Best-Merry-Christmas-HD-Greetings-Wallpapers-free-by-newwallpapershd.com_.jpg?resize=100%2C100",
        "https://cdn.allwallpaper.in/wallpapers/100x100/4578/ethernet-cable-cables-computer-science-technology-optical-fiber-100x100-wallpaper.jpg",
        "http://www.mobile-phone.pk/images/wallpapers/small/beautiful_flower_wallpapers_nature_mobile_wallpaper.jpg",
        "https://i0.wp.com/techbeasts.com/wp-content/uploads/2014/04/Stunning-Nature-HD-Wallpaper.jpg?resize=100%2C100",
        "http://sherly.mobile9.com/download/thumb.php?d=cHJldmlldy81NTY&f=1393426615.jpg&w=100&h=100&q=70",
        "http://sherly.mobile9.com/download/thumb.php?d=cHJldmlldy81NTY&f=1400755101.png&w=100&h=100&q=70",
        "http://is2.mzstatic.com/image/thumb/Purple111/v4/26/53/91/265391f0-d081-ed11-96c3-e804ff8dd2f3/source/100x100bb.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4XD0dYk2z0YMXk85QY7uKyzFU984F_SVyLd00EjBQMhGBqsSYxE-lxcY",
        "https://cdn0.iconfinder.com/data/icons/social-flat-rounded-rects/512/facebook-256.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGSocORFPTHNmCeEzr7JHk_pYGjhBr6KGOac4EqNuFBe183PM_w0ZZIg",
       "https://galleryofgod.files.wordpress.com/2014/03/wpid-ganesh20wallpaper201.jpg?w=672&h=372&crop=1",
            "https://cdn0.iconfinder.com/data/icons/social-flat-rounded-rects/512/youtube_v2-256.png"
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gridview);

        CustomGridAdapter adapter = new CustomGridAdapter(ImageGridView.this, web, image);
        grid=(GridView)findViewById(R.id.gv);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ImageGridView.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ImageGridView.this,ImageZoom.class);
                String image1=web[+ position];
                intent.putExtra("image",image[+ position]);
                startActivity(intent);

            }
        });

    }

}
