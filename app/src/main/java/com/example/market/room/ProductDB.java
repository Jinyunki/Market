package com.example.market.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDB extends RoomDatabase {
    private static ProductDB INSTANCE = null;

    public abstract ProductDAO productDAO();


    public static ProductDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDB.class, "product.db").build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
