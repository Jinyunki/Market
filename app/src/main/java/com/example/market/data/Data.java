package com.example.market.data;

public class Data {

    public static final String HOME_POSITION = "HOME_POSITION";
    public static final String SEARCH_POSITION = "SEARCH_POSITION";
    public static final String ADD_POSITION = "ADD_POSITION";
    public static final String TALK_POSITION = "TALK_POSITION";
    public static final String MY_POSITION = "MY_POSITION";

    int bannerColor;

    public static final int HOME_BANNER = 101;
    public static final int HOME_ICON = 102;
    public static final int HOME_TEXT = 103;
    public static final int HOME_PRODUCT = 104;
    public static final int HOME_BRAND = 105;


    public static final int SEARCH_RECORD = 1011;
    public static final int SEARCH_TREND = 1021;
    public static final int SEARCH_RECOMMEND = 1031;
    public static final int SEARCH_CATEGORY = 1041;


    public static final int ICON_JORDAN = 1012;
    public static final int ICON_SNEAKERS = 1022;
    public static final int ICON_CAMPING = 1032;
    public static final int ICON_BIKE = 1042;
    public static final int ICON_STAR = 1052;
    public static final int ICON_MOTOR_CYCLE = 1062;
    public static final int ICON_WATCH = 1072;

    private String record;



    public Data(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Data(int bannerColor) {
        this.bannerColor = bannerColor;
    }
    public Data() {
    }

    public int getBannerColor() {
        return bannerColor;
    }

    public int setBannerColor(int bannerColor) {
        this.bannerColor = bannerColor;
        return bannerColor;
    }
}
