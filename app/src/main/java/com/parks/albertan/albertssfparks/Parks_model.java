package com.parks.albertan.albertssfparks;

/**
 * Created by albertan on 3/24/16.
 */
public class Parks_model {


    /**
     *
     *
     * "parktype" : "Mini Park",
     "parkname" : "15TH AVENUE STEPS",
     "email" : "charles.sheehy@sfgov.org",
     "zipcode" : "94122",
     "parkid" : "185",
     "supdist" : "7",
     "number" : "(415) 218-2226",
     "parkservicearea" : "PSA 4",
     "location_1" : {
     "needs_recoding" : false,
     "longitude" : "-122.47226783",
     "latitude" : "37.75956493",
     "human_address" : "{\"address\":\"15th Ave b w Kirkham\",\"city\":\"San Francisco\",\"state\":\"CA\",\"zip\":\"\"}"
     },
     *
     */



    String
            parktype,

    parkname,
     email,
    zipcode,
     parkid,
     number,
     parkservicearea,

     needs_recoding,
    longitude,
     latitude,
     human_address,
            acreage,
            psamanager;

    double distance;

    Parks_model(
            String parktype,

            String parkname,
            String email,
            String zipcode,
            String parkid,
            String number,
            String parkservicearea,

            String needs_recoding,
            String longitude,
            String latitude,
            String human_address,
            String acreage,
            String psamanager,
            double distance){

                this.parktype = parktype;

                this.parkname=parkname;
                this. email=email;
                this.zipcode=zipcode;
                this.parkid=parkid;
                this. number=number;
                this. parkservicearea=parkservicearea;

                this. needs_recoding=needs_recoding;
                this. longitude=longitude;
                this. latitude= latitude;
                this. human_address =human_address;
                this. acreage= acreage;
                this. psamanager= psamanager;
        this.distance = distance;


    }// constructor


    public String getparktype(){

        return parktype;
    }

    public String getparkname(){

        return parkname;
    }
    public String getemail(){

        return email;
    }
    public String getzipcode(){
        return zipcode;
    }
    public String getparkid(){
        return parkid;
    }
    public String getnumber(){

        return number;
    }
    public String getparkservicearea(){

        return parkservicearea;
    }//park

    public String getneeds_recoding(){

        return needs_recoding;
    }
    public String getlongitude(){
        return longitude;
    }
    public String getlatitude(){
        return latitude;
    }
    public String gethuman_address(){
        return human_address;
    }
    public String getacreage(){

        return acreage;
    }
    public String getpsamanager(){
        return psamanager;
    }

    public double getdistance(){

        return distance;
    }


}//end class
