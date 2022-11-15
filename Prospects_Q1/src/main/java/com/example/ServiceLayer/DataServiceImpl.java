package com.example.ServiceLayer;

import com.example.Dao.DataDao;
import com.example.Exceptions.DataNotFoundException;
import com.example.Model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    private DataDao dataDao;


    @Override
    public Data addData(Data data) {
        return dataDao.save(data);
    }

    @Override
    public Data getData(Long id) throws DataNotFoundException {
        Data data = null;

        Optional<Data> optData = dataDao.findById(id);

        if (optData.isPresent()){
            data = optData.get();
        }
        else {
            throw new DataNotFoundException("Data Not Found");
        }
        return data;
    }

    @Override
    public Data updateData(Data data) throws DataNotFoundException {

        Optional<Data> optionalData = dataDao.findById(data.getId());

        if (optionalData.isPresent()){
            return dataDao.save(data);
        }
        else {
            throw new DataNotFoundException("Data Not Found");
        }
    }

    @Override
    public String deleteData(Long id) throws DataNotFoundException {
        Data data = null;

        Optional<Data> optdata = dataDao.findById(id);

        if (optdata.isPresent()){
            data = optdata.get();
            dataDao.delete(data);
        }
        else {
            throw new DataNotFoundException("Data Not Found");
        }
        return "Data Deleted";
    }

    @Override
    public List<String> getTitleBySubstring(String title) throws DataNotFoundException {
        List<String> titles = new ArrayList<>();

        titles = dataDao.getTitleByParameter(title);

        if (titles.size()>0){
            return titles;
        }
        else throw new DataNotFoundException("No Titles Found With value : "+title);
    }

    @Override
    public List<String> getDescriptionBySubstring(String desc) throws DataNotFoundException {
        List<String> descriptions = new ArrayList<>();

        descriptions = dataDao.getTitleByParameter(desc);

        if (descriptions.size()>0){
            return descriptions;
        }
        else throw new DataNotFoundException("No Descriptions Found With value : "+desc);
    }

    @Override
    public List<String> getAuthBySubstring(String auth) throws DataNotFoundException {
        List<String> auths = new ArrayList<>();

        auths = dataDao.getTitleByParameter(auth);

        if (auths.size()>0){
            return auths;
        }
        else throw new DataNotFoundException("No Auths Found With value : "+auth);
    }

    @Override
    public List<String> getHttpsBySubstring(Boolean https) throws DataNotFoundException {
        List<String> httpList = new ArrayList<>();

        httpList = dataDao.getTitleByParameter(String.valueOf(https));

        if (httpList.size()>0){
            return httpList;
        }
        else throw new DataNotFoundException("No Https Found With value : "+https);
    }

    @Override
    public List<String> getCorsBySubstring(String cors) throws DataNotFoundException {
        List<String> corsList = new ArrayList<>();

        corsList = dataDao.getTitleByParameter(cors);

        if (corsList.size()>0){
            return corsList;
        }
        else throw new DataNotFoundException("No Cors Found With value : "+cors);
    }

    @Override
    public List<String> getCategoryBySubstring(String category) throws DataNotFoundException {
        List<String> categories = new ArrayList<>();

        categories = dataDao.getTitleByParameter(category);

        if (categories.size()>0){
            return categories;
        }
        else throw new DataNotFoundException("No Categories Found With value : "+category);
    }
}
