package com.parks.albertan.albertssfparks.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseStuff {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_parktype= "parktype";
	public static final String KEY_parkname = "parkname";
	public static final String KEY_email = "email";
    public static final String KEY_zipcode = "zipcode";

	public static final String KEY_parkid = "parkid";
	public static final String KEY_number = "number";
	public static final String KEY_parkservicearea = "parkservicearea";
	public static final String KEY_needs_recoding = "needs_recoding";
	public static final String KEY_longitude = "longitude";
	public static final String KEY_latitude = "latitude";
	public static final String KEY_human_address = "human_address";

	public static final String KEY_acreage = "acreage";
	public static final String KEY_psamanager = "psamanager";
	public static final String KEY_distance = "distance";
	
	//db stuff 
	
	private static final String DATABASE_NAME = "ParkDb";
	private static final String DATABASE_TABLE ="progressTable";
	private static final int DATABASE_VERSION = 4;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// make the database
			
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
			KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
							KEY_parktype+ " TEXT NOT NULL, " +
							KEY_parkname+ " TEXT NOT NULL, " +

							KEY_email + " TEXT NOT NULL, " +

							KEY_zipcode + " TEXT NOT NULL, " +
							KEY_parkid + " TEXT NOT NULL, " +
							KEY_number + " TEXT NOT NULL, " +
							KEY_parkservicearea + " TEXT NOT NULL, " +
							KEY_needs_recoding + " TEXT NOT NULL, " +
							KEY_longitude + " TEXT NOT NULL, " +
							KEY_latitude + " TEXT NOT NULL, " +
							KEY_human_address+" TEXT NOT NULL, " +
							KEY_acreage+" TEXT NOT NULL, " +

							KEY_psamanager+ " TEXT NOT NULL, " +
							KEY_distance+ " TEXT NOT NULL);"
					
					);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//INSERT STUFF FOR FIRST TIME 
			
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
			
		}
	}
	//init context
	
	public DatabaseStuff(Context c){
		ourContext = c;
	}
	//	initialize open database
		public DatabaseStuff open() throws SQLException {
			
			ourHelper =  new DbHelper(ourContext);
			ourDatabase = ourHelper.getWritableDatabase();
			return this;
			
		}
		
//close database
		public void close(){
			ourHelper.close();
		}



//insert data
		public long createEntry(
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
				String distance


		){
			//write to database and close db
			
			ContentValues cv = new ContentValues();
			cv.put(KEY_parktype, parktype);
			cv.put(KEY_parkname, parkname);
            cv.put(KEY_email, email);

			cv.put(KEY_zipcode, zipcode);
			cv.put(KEY_parkid, parkid);
			cv.put(KEY_number, number);
			cv.put(KEY_parkservicearea, parkservicearea);
			cv.put(KEY_needs_recoding, needs_recoding);
			cv.put(KEY_longitude,longitude);
			cv.put(KEY_latitude, latitude);

			cv.put(KEY_human_address, human_address);
			cv.put(KEY_acreage, acreage);
			cv.put(KEY_psamanager,psamanager);
			cv.put(KEY_distance, distance);



			return ourDatabase.insert(DATABASE_TABLE, null, cv);
			
		}
		
//get all the database data with string array		
		public String[][] getData() {
			// get all the data from database
			
			String[] columns = new String[] {KEY_ROWID, KEY_parktype, KEY_parkname, KEY_email,
					KEY_zipcode, KEY_parkid, KEY_number,KEY_parkservicearea,
					KEY_needs_recoding, KEY_longitude, KEY_latitude, KEY_human_address,
					KEY_acreage, KEY_psamanager, KEY_distance};
			Cursor c = ourDatabase.query( DATABASE_TABLE, columns, null, null, null, null, KEY_ROWID+" DESC");
			
			
			int iRow = c.getColumnIndex(KEY_ROWID);
			int iKEY_parktype = c.getColumnIndex(KEY_parktype);
			int iKEY_parkname= c.getColumnIndex(KEY_parkname);
            int iKEY_email = c.getColumnIndex(KEY_email);

			int iKEY_zipcode = c.getColumnIndex(KEY_zipcode);
			int iKEY_parkid = c.getColumnIndex(KEY_parkid);
			int iKEY_number = c.getColumnIndex(KEY_number);
			int iKEY_parkservicearea = c.getColumnIndex(KEY_parkservicearea);
			int iKEY_needs_recoding = c.getColumnIndex(KEY_needs_recoding);
			int iKEY_longitude = c.getColumnIndex(KEY_longitude);
			int iKEY_latitude = c.getColumnIndex(KEY_latitude);
			int iKEY_human_address = c.getColumnIndex(KEY_human_address);
			int iKEY_acreage = c.getColumnIndex(KEY_acreage);
			int iKEY_psamanager = c.getColumnIndex(KEY_psamanager);
			int iKEY_distance = c.getColumnIndex(KEY_distance);
			
			String[][] result = null;
			result= new String[c.getCount()][15];
			
			if(c.moveToFirst()){

				 for (int i =0; i<c.getCount(); i++){


					 result[i][0] =c.getString(iRow);
                     result[i][1] =c.getString(iKEY_parktype);
                     result[i][2] =c.getString(iKEY_parkname);
                     result[i][3] =c.getString(iKEY_email);

					 result[i][4] =c.getString(iKEY_zipcode);
					 result[i][5] =c.getString(iKEY_parkid);
					 result[i][6] =c.getString(iKEY_number);
					 result[i][7] =c.getString(iKEY_parkservicearea);
					 result[i][8] =c.getString(iKEY_needs_recoding);
					 result[i][9] =c.getString(iKEY_longitude);
					 result[i][10] =c.getString(iKEY_latitude);
					 result[i][11] =c.getString(iKEY_human_address);
					 result[i][12] =c.getString(iKEY_acreage);
					 result[i][13] =c.getString(iKEY_psamanager);
					 result[i][14] =c.getString(iKEY_distance);


					  //" "+c.getString(iDay) + "            " + c.getString(iNote) + "    "+ c.getString(iDate) ;
					c.moveToNext(); 
				 }
			}// end if move to first
			
			return result;
		}

/*
	//get the last dayfor main
		public String getLastDay() {
			
			String[] columns = new String[] {KEY_ROWID, KEY_DAY, KEY_NOTE, KEY_DATE};
			Cursor c = ourDatabase.query( DATABASE_TABLE, columns, null, null, null, null, null);
			
			int iRow =  c.getColumnIndex(KEY_ROWID);
			int iDay= c.getColumnIndex(KEY_DAY);
			int iNote= c.getColumnIndex(KEY_NOTE);
            int iDate = c.getColumnIndex(KEY_DATE);
			
			String result = "";
			
			if(c.moveToLast()){
				result= c.getString(iDay);
			}
			
			return result;
		}


    public String getFinalDate() {

        String[] columns = new String[] {KEY_ROWID, KEY_DAY, KEY_NOTE, KEY_DATE};
        Cursor c = ourDatabase.query( DATABASE_TABLE, columns, null, null, null, null, null);

        int iRow =  c.getColumnIndex(KEY_ROWID);
        int iDay= c.getColumnIndex(KEY_DAY);
        int iNote= c.getColumnIndex(KEY_NOTE);
        int iDate = c.getColumnIndex(KEY_DATE);

        String result = "";

        if(c.moveToLast()){
            result= c.getString(iDate);
        }

        return result;
    }*/
		
//delete all the data in database		
		public void deleteAllData() {
			// TODO Auto-generated method stub
			ourDatabase.delete(DATABASE_TABLE, null, null);
			   
		}
		
		//TODO SELECT day FROM TABLE WHERE ID = (SELECT MAX(ID) FROM TABLE); get last day

        public void deleteFromID(String rowid){

        String table = "progressTable";
        String whereClause = "_id"+"=?";
        String[]whereArgs = new String[] {String.valueOf(rowid)};
        ourDatabase.delete(table, whereClause , whereArgs);


    }//delete



}
