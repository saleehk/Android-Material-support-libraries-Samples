package com.saleeh.samples;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.PaletteItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saleeh.samples.utils.Item;

public class ImageDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        LinearLayout colorsLayout = (LinearLayout) findViewById(R.id.colors);
        int pos = getIntent().getExtras().getInt("pos");
        Item item = Item.ITEMS[pos];
        ImageView image = (ImageView) findViewById(R.id.imageview_item);

        TextView name = (TextView) findViewById(R.id.textview_name);
        if (item != null) {
            getSupportActionBar().setTitle(item.getName());
            image.setImageResource(item.image);
            name.setText(item.getName());
            Bitmap bm = BitmapFactory.decodeResource(getResources(), item.image);
            Palette palette = Palette.generate(bm);
            if (palette.getLightVibrantColor() != null) {
                name.setBackgroundColor(palette.getLightVibrantColor().getRgb());
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(palette.getLightVibrantColor().getRgb()));
                // getSupportActionBar().

            }

            if (palette.getDarkVibrantColor() != null) {
                name.setTextColor(palette.getDarkVibrantColor().getRgb());
                int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
                if (actionBarTitleId > 0) {
                    TextView title = (TextView) findViewById(actionBarTitleId);
                    if (title != null) {
                        title.setTextColor(palette.getDarkVibrantColor().getRgb());
                    }
                }
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
            for (PaletteItem pt : palette.getPallete()) {
                if (pt != null) {
                    View sv = new View(this);
                    sv.setBackgroundColor(pt.getRgb());

                    sv.setLayoutParams(params);
                    colorsLayout.addView(sv, 0);


                }
            }


        }

    }


}
