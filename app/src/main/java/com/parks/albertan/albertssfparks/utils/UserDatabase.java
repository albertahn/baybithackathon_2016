package com.parks.albertan.albertssfparks.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by albert on 8/24/14.
 */
public class UserDatabase {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_USERINDEX = "user_index";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";

    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PROFILE_PICTURE = "profile_picture";
    public static final String KEY_FID = "FID";
    public static final String KEY_LEVEL = "level";
    //level

    public static final String KEY_TEXT_PROFILE = "text_profile";
    public static final String KEY_EXP_POINTS = "exp_points";


    //db stuff

    private static final String DATABASE_NAME = "TangGoalDb";
    private static final String DATABASE_TABLE ="membersTable";
    private static final int DATABASE_VERSION = 7;

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
                            KEY_USERINDEX + " TEXT NOT NULL, " +
                            KEY_USERNAME + " TEXT NOT NULL, " +
                            KEY_EMAIL + " TEXT NOT NULL, " +
                            KEY_PASSWORD + " TEXT NOT NULL, " +
                            KEY_PROFILE_PICTURE + " TEXT NOT NULL, " +
                            KEY_FID+ " TEXT NOT NULL, "+
                            KEY_LEVEL+ " TEXT NOT NULL, "+
                            KEY_TEXT_PROFILE+ " TEXT NOT NULL,"+
                            KEY_EXP_POINTS+ " TEXT NOT NULL);"
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

    public UserDatabase(Context c){
        ourContext = c;
    }
    //	initialize open database
    public UserDatabase open() throws SQLException {

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
            String user_index,
            String username,
            String email,
            String password,
            String profile_picture,
            String FID,
            String level,
            String text_profile,
            String exp_points){

        //write to database and close db
        ContentValues cv = new ContentValues();
        cv.put(KEY_USERINDEX, user_index);
        cv.put(KEY_USERNAME, username);
        cv.put(KEY_EMAIL, email);
        cv.put(KEY_PASSWORD, password);

        cv.put(KEY_PROFILE_PICTURE, profile_picture);
        cv.put(KEY_FID, FID);
        cv.put(KEY_LEVEL, level);
        cv.put(KEY_TEXT_PROFILE, text_profile);
        cv.put(KEY_EXP_POINTS, exp_points);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);

    }

    //get all the database data with string array
    public String[][] getData() {
        // get all the data from database

        String[] columns = new String[] {KEY_ROWID,KEY_USERINDEX, KEY_USERNAME, KEY_EMAIL, KEY_PASSWORD, KEY_PROFILE_PICTURE, KEY_FID, KEY_LEVEL, KEY_TEXT_PROFILE, KEY_EXP_POINTS};
        Cursor c = ourDatabase.query( DATABASE_TABLE, columns, null, null, null, null, null);


        int iRow = c.getColumnIndex(KEY_ROWID);
        int iUserIndex = c.getColumnIndex(KEY_USERINDEX);
        int iUsername = c.getColumnIndex(KEY_USERNAME);
        int iEmail = c.getColumnIndex(KEY_EMAIL);
        int iPassword = c.getColumnIndex(KEY_PASSWORD);

        int iProfilePicture = c.getColumnIndex(KEY_PROFILE_PICTURE);
        int iFID = c.getColumnIndex(KEY_FID);
        int iLevel = c.getColumnIndex(KEY_LEVEL);
        int iTextProfile = c.getColumnIndex(KEY_TEXT_PROFILE);
        int iexp_points = c.getColumnIndex(KEY_EXP_POINTS);

        String[][] result = null;

        //7 columns
        result= new String[c.getCount()][10];

        if(c.moveToFirst()){
            for (int i =0; i<c.getCount(); i++){
                result[i][0] =c.getString(iRow);
                result[i][1] =c.getString(iUserIndex);
                result[i][2] =c.getString(iUsername);
                result[i][3] =c.getString(iEmail);
                result[i][4] =c.getString(iPassword);
                result[i][5] =c.getString(iProfilePicture);
                result[i][6] =c.getString(iFID);
                result[i][7] =c.getString(iLevel);
                result[i][8] =c.getString(iTextProfile);
                result[i][9] =c.getString(iexp_points);

                c.moveToNext();
            }
        }// end if move to first

        return result;
    }


    //delete all the data in database
    public void deleteAllData() {
        // TODO Auto-generated method stub
        ourDatabase.delete(DATABASE_TABLE, null, null);

    }


    public void updateLevel(String level, String sqliteindex){

        String strSQL = "UPDATE "+DATABASE_TABLE+" SET "+KEY_LEVEL+" = "+level+" WHERE "+KEY_ROWID+" = "+ sqliteindex;

        ourDatabase.execSQL(strSQL);

/*
        Toast toast = Toast.makeText(ourContext,
                "my_index:"+sqliteindex, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(ourContext);
        imageCodeProject.setImageResource(R.drawable.ic_launcher);
        toastView.addView(imageCodeProject, 0);
        toast.show();*/
    }//end update

    //TODO SELECT day FROM TABLE WHERE ID = (SELECT MAX(ID) FROM TABLE); get last day



}
