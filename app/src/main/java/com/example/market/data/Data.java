package com.example.market.data;

public class Data {

    public static final String HOME_POSITION = "HOME_POSITION";
    public static final String SEARCH_POSITION = "SEARCH_POSITION";
    public static final String ADD_POSITION = "ADD_POSITION";
    public static final String TALK_POSITION = "TALK_POSITION";
    public static final String MY_POSITION = "MY_POSITION";

    int bannerColor;

    public static final String BANNER_POSITION_ONE = "BANNER_POSITION_ONE";
    public static final String BANNER_POSITION_TWO = "BANNER_POSITION_TWO";
    public static final String BANNER_POSITION_THREE = "BANNER_POSITION_THREE";
    public static final String BANNER_POSITION_FOUR = "BANNER_POSITION_FOUR";
    public static final String BANNER_POSITION_FIVE = "BANNER_POSITION_FIVE";
    public static final String BANNER_POSITION_SIX = "BANNER_POSITION_SIX";
    public static final String BANNER_POSITION_SEVEN = "BANNER_POSITION_SEVEN";
    public static final String BANNER_POSITION_EIGHT = "BANNER_POSITION_EIGHT";


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
