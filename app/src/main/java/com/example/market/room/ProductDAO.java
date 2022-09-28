package com.example.market.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    // 조회 (Read) SELECT
    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Query("SELECT * FROM Product WHERE id = :productId")
    Product getProductDataId (int productId);

    @Query("SELECT * FROM Product WHERE id IN (:productDataId)")
    List<Product> loadAllByIds (int[] productDataId);

    // 생성 (Create) Insert
    @Insert
    void insertAll(Product... productList);

    // 갱신 (Update)
    @Update
    void updateDiary(Product product);

    // 삭제 (Delete)
    @Delete
    void delete(Product product);

    @Query("DELETE FROM Product WHERE id in (:productList)")
    void deleteFromIds(List<Integer> productList);

    @Query("DELETE FROM Product WHERE id = :productId")
    void delete(int productId);

}
