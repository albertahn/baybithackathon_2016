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
public class ParkListAdapter extends ArrayAdapter<Parks_model> {


    static int rowList = R.layout.messagetabadapter_____message_frag_list_row;

    private final Context context;

    private final ArrayList<Parks_model> itemsArrayList;

    private String parkname,zipcode,human_address,psamanager, email, number;

    public ParkListAdapter(Context context, ArrayList<Parks_model> itemsArrayList) {


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
        TextView product_picture = (TextView) rowView.findViewById(R.id.product_picture);

        product_picture.setText(""+ itemsArrayList.get(position).getdistance()+ " km");



        //4. set the text

        parkname_view.setText("Park Name: "+ itemsArrayList.get(position).getparkname());
        description_view.setText("Park Manager: "+ itemsArrayList.get(position).getpsamanager() +",  "+
                                 "Park phone: "+ itemsArrayList.get(position).getnumber()
        +", Park email: "+ itemsArrayList.get(position).getemail());



        // 5. retrn rowView
        Integer memindex = Integer.parseInt(itemsArrayList.get(position).getparkid());
        rowView.setId(memindex);




        parkname = itemsArrayList.get(position).getparkname();
        zipcode = itemsArrayList.get(position).getzipcode();
        human_address = itemsArrayList.get(position).gethuman_address();
        psamanager= itemsArrayList.get(position).getpsamanager();
        email = itemsArrayList.get(position).getemail();
        number = itemsArrayList.get(position).getnumber();

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(context,
                        MessageInside.class);

                i.putExtra("otherguyname", parkname);

                i.putExtra("prevActivity", "MainActivity");

                i.putExtra("zipcode", zipcode);
                i.putExtra("human_address", human_address);
                i.putExtra("psamanager", psamanager);
                i.putExtra("email", email);
                i.putExtra("number", number);

                context.startActivity(i);

            }
        });




        return rowView;
    }



}//park list adapter end
