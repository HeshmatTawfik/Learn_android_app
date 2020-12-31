package com.heshmat.learnandroid;

public class StaticFields {
    public final static int ROLE_ADMIN=1;
    public final static int ROLE_USER=2;
    public final static String LEVEL_EASY="EASY";
    public final static String LEVEL_MEDIUM="MEDIUM";
    public final static String LEVEL_HARD="HARD";
    public final static  String USER_COLUMN_ID="id";
    public final static String USER_COLUMN_ROLE="role";
    public final static String USER_COLUMN_NAME="name";
    public final static String USER_COLUMN_EMAIL="email";
    public final static String USER_COLUMN_PASSWORD="password";
    public final static String USER_COLUMN_IMG_URL="imgUrl";
    public final static String [] USER_TABLE_COLUMNS={USER_COLUMN_ID,USER_COLUMN_ROLE,USER_COLUMN_NAME,USER_COLUMN_EMAIL,USER_COLUMN_PASSWORD,USER_COLUMN_IMG_URL};

    public final static String[] TOPIC_TABLE_COLUMNS={"id","title","content","level","status"};



}
