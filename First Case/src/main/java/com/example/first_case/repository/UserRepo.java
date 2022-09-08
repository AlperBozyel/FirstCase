package com.example.first_case.repository;

import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.dto.ProductDto;
import com.example.first_case.dto.UserDto;
import com.example.first_case.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<user, Integer> {

    @Query(value = "SELECT pc.Yorum, pc.yorumTarihi FROM kullanıcı u JOIN urunyorum pc on u.Id = pc.urunId WHERE u.Id = :id", nativeQuery = true)
    public List<ProductCommentDto> getProductCommentsByUser(@Param("id") Long user_id);

    @Query(value = "SELECT pc.Yorum, pc.yorumTarihi FROM kullanıcı u JOIN urunyorum pc on u.Id = pc.urunId WHERE u.id = :id and pc.yorumTarihi between :date1 AND :date2", nativeQuery = true)
    public List<ProductCommentDto> getProductCommentsByUserBetweenDateInterval(@Param("id") Long user_id, @Param("date1") Date dateStart, @Param("date2") Date dateFinal);

}
