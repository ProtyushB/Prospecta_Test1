package com.example.Controller;

import com.example.Exceptions.DataNotFoundException;
import com.example.Model.Data;
import com.example.ServiceLayer.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/")
    public ResponseEntity<Data> addData(@RequestBody Data data){
        return new ResponseEntity<>(dataService.addData(data), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Data> getData(@PathVariable ("id") Long id) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getData(id), HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<Data> updateData(@RequestBody Data data) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.updateData(data), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable ("id") Long id) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.deleteData(id), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<String>> getTitleBySubString(@PathVariable ("title") String title) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getTitleBySubstring(title), HttpStatus.FOUND);
    }

    @GetMapping("/{description}")
    public ResponseEntity<List<String>> getDescriptionBySubstring(@PathVariable ("description") String desc) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getDescriptionBySubstring(desc), HttpStatus.FOUND);
    }

    @GetMapping("/{auth}")
    public ResponseEntity<List<String>> getAuthBySubString(@PathVariable ("auth") String auth) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getAuthBySubstring(auth), HttpStatus.FOUND);
    }

    @GetMapping("/{https}")
    public ResponseEntity<List<String>> getHttpListBySubString(@PathVariable ("https") Boolean https) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getHttpsBySubstring(https), HttpStatus.FOUND);
    }

    @GetMapping("/{cors}")
    public ResponseEntity<List<String>> getCorsListBySubString(@PathVariable ("cors") String cors) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getCorsBySubstring(cors), HttpStatus.FOUND);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<String>> getCategoriesBySubString(@PathVariable ("category") String category) throws DataNotFoundException {
        return new ResponseEntity<>(dataService.getCategoryBySubstring(category), HttpStatus.FOUND);
    }
}
