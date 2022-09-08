package com.example.first_case.repository;

import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.dto.ProductDto;
import com.example.first_case.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<product,Integer> {

    @Query(value = "SELECT pc.Yorum, pc.yorumTarihi FROM urun p JOIN urunyorum pc on p.Id = pc.urunId WHERE p.Id = :id", nativeQuery = true)
    public List<ProductCommentDto> getProductCommentsByProduct(@Param("id") Long product_id);

    @Query(value = "SELECT pc.Yorum, pc.yorumTarihi FROM urun p JOIN urunyorum pc on p.Id = pc.urunId WHERE p.id = :id and pc.yorumTarihi between :date1 AND :date2", nativeQuery = true)
    public List<ProductCommentDto> getProductCommentsByProductBetweenDateInterval(@Param("id") Long product_id, @Param("date1") Date dateStart, @Param("date2") Date dateFinal);

    @Query(value = "SELECT p.Adı, p.Fiyat, p.Son_Kullanma_Tarihi FROM urun p WHERE p.Son_Kullanma_Tarihi > current_date and p.Son_Kullanma_Tarihi = NULL", nativeQuery = true)
    public List<ProductDto> getFreshProduct();

    @Query(value = "SELECT p.Adı, p.Fiyat, p.Son_Kullanma_Tarihi FROM urun p WHERE p.Son_Kullanma_Tarihi < current_date", nativeQuery = true)
    public List<ProductDto> getExpiredProduct();
}