package com.example.Dao;

import com.example.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDao extends JpaRepository<Data, Long> {

    @Query("select title from Data where title like ?1")
    public List<String> getTitleByParameter(String title);

    @Query("select description from Data where description like ?1")
    public List<String> getDescriptionByParam(String desc);

    @Query("select auth from Data where description like ?1")
    public List<String> getAuthByParam(String auth);

    @Query("select https from Data where description like ?1")
    public List<String> getHttpsByParam(Boolean https);

    @Query("select cors from Data where description like ?1")
    public List<String> getCorsByParam(String cors);

    @Query("select category from Data where description like ?1")
    public List<String> getCategoryByParam(String category);

}
