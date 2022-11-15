package com.example.ServiceLayer;

import com.example.Exceptions.DataNotFoundException;
import com.example.Model.Data;

import java.util.List;

public interface DataService {

    Data addData(Data data);

    Data getData(Long id) throws DataNotFoundException;

    Data updateData(Data data) throws DataNotFoundException;

    String deleteData(Long id) throws DataNotFoundException;

    List<String> getTitleBySubstring (String title) throws DataNotFoundException;

    List<String> getDescriptionBySubstring (String desc) throws DataNotFoundException;

    List<String> getAuthBySubstring (String auth) throws DataNotFoundException;

    List<String> getHttpsBySubstring (Boolean https) throws DataNotFoundException;

    List<String> getCorsBySubstring (String cors) throws DataNotFoundException;

    List<String> getCategoryBySubstring (String category) throws DataNotFoundException;

}
