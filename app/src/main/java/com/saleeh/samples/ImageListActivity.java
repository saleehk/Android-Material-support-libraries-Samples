package com.saleeh.samples;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.saleeh.samples.utils.Item;

public class ImageListActivity extends ActionBarActivity {
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        gv = (GridView) findViewById(R.id.grid);
        gv.setAdapter(new GridAdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ImageListActivity.this, ImageDetailActivity.class);
                intent.putExtra("pos", i);
                startActivity(intent);

            }
        });
    }

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Item.ITEMS.length;
        }

        @Override
        public Item getItem(int position) {
            return Item.ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.pl_item, viewGroup, false);
            }

            final Item item = getItem(position);

            // Load the thumbnail image
            ImageView image = (ImageView) view.findViewById(R.id.imageview_item);

            TextView name = (TextView) view.findViewById(R.id.textview_name);
            //    image.setImageUrl(item.getThumbnailUrl(), mImageLoader);
              image.setImageResource(item.image);

            // Set the TextView's contents
            name.setText(item.getName());

            // END_INCLUDE(grid_set_view_name)

            return view;
        }
    }


}
