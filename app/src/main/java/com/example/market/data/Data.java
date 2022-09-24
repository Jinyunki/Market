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


    public static final int ICON_LIKE = 1011;
    public static final int ICON_NEW = 1021;
    public static final int ICON_FEED = 1031;
    public static final int ICON_PHONE = 1041;
    public static final int ICON_PLACE = 1051;
    public static final int ICON_INVITE = 1061;
    public static final int ICON_TOTAL_MENU = 1071;

    public static final int ICON_JORDAN = 1012;
    public static final int ICON_SNEAKERS = 1022;
    public static final int ICON_CAMPING = 1032;
    public static final int ICON_BIKE = 1042;
    public static final int ICON_STAR = 1052;
    public static final int ICON_MOTOR_CYCLE = 1062;
    public static final int ICON_WATCH = 1072;



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
