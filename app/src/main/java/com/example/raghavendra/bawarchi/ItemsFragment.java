package com.example.raghavendra.bawarchi;

/**
 * Created by raghavendra on 5/7/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Provides UI for the view with Cards.
 */
public class ItemsFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView price;
        public TextView quantity;
        public int mQuantity = 0;
        int p;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.item_image);
            name = (TextView) itemView.findViewById(R.id.item_name);
            price = (TextView) itemView.findViewById(R.id.item_price);
            quantity =(TextView)itemView.findViewById(R.id.quantity);






            ImageButton addImageButton =
                    (ImageButton) itemView.findViewById(R.id.add_button);
            addImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    if (mQuantity == 5) {
                        return;
                    }

                    quantity.setText(String.valueOf(++mQuantity));

                }
            });

            ImageButton minusImageButton = (ImageButton) itemView.findViewById(R.id.minus_button);
            minusImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    if (mQuantity == 0) {
                        return;
                    }
                    quantity.setText(String.valueOf(--mQuantity));

                }
            });
        }

    }


    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 11;

        private final String[] mNames;
        private final String[] mPrice;
        private final Drawable[] mItemPics;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mNames = resources.getStringArray(R.array.ItemNames);
            mPrice = resources.getStringArray(R.array.ItemPrice);
            TypedArray a = resources.obtainTypedArray(R.array.item_picture);
            mItemPics = new Drawable[a.length()];
            for (int i = 0; i < mItemPics.length; i++) {
                mItemPics[i] = a.getDrawable(i);
            }
            a.recycle();
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mItemPics[position % mItemPics.length]);
            holder.name.setText(mNames[position % mNames.length]);
            holder.price.setText(mPrice[position % mPrice.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
