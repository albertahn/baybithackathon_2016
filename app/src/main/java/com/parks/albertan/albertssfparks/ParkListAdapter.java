package com.parks.albertan.albertssfparks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.parks.albertan.albertssfparks.Parks_model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by albertan on 3/24/16.
 */
public class ParkListAdapter extends ArrayAdapter<MerchantNamesList> {


    static int rowList = R.layout.messagetabadapter_____message_frag_list_row;

    private final Context context;

    private final ArrayList<MerchantNamesList> itemsArrayList;

    private String parkname,zipcode,human_address,psamanager, email, number;

    public ParkListAdapter(Context context, ArrayList<MerchantNamesList> itemsArrayList) {


//ArrayList<HomeItem> itemsArrayList


        super(context, rowList, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(rowList, parent, false);

        // 3. Get the two text view from the rowView
        TextView parkname_view = (TextView) rowView.findViewById(R.id.parkname);
        TextView description_view = (TextView) rowView.findViewById(R.id.park_manager);
        ImageView product_picture = (ImageView) rowView.findViewById(R.id.product_picture);


        //4. set the text

        parkname_view.setText(" " + itemsArrayList.get(position).getName());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(context,
                        MessageInside.class);


                context.startActivity(i);

            }
        });

        switch (position){

            case 0:

                product_picture.setImageResource(R.drawable.cafe);

                break;

            case 1:

                product_picture.setImageResource(R.drawable.cafe);
                break;

            case 2:
                product_picture.setImageResource(R.drawable.cafe);
                break;

            case 3:
                product_picture.setImageResource(R.drawable.cafe);
                break;

            default:
                product_picture.setImageResource(R.drawable.cafe);
                break;

        }




        return rowView;
    }



}//park list adapter end
