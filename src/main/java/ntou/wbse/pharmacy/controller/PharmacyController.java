package ntou.wbse.pharmacy.controller;

import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.entity.PharmacyParameter;
import ntou.wbse.pharmacy.service.NoteService;
import ntou.wbse.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/pharmacy")
public class PharmacyController {
    // TODO : add pharmacy api mapping and definition

    @Autowired
    private NoteService noteService;
    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/hello")
    public String TryToRun(){
        return "hello spring boot";
    }

    @GetMapping
    public ResponseEntity<Pharmacy> getPharmacies(@ModelAttribute PharmacyParameter param){
        // TODO : GET method mapping
        // return multiple pharmacies
        // two parameters , pharmacyName / zone
        // url: /pharmacy?pharmacyName=&zone=

        // search in mongo
        // get target pharmacy data sets
        // return result data set
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pharmacy> getPharmacy(@PathVariable("id") String id){
        // TODO : GET method mapping
        // return single pharmacy
        // url: /pharmacy/{id}
        Pharmacy target;
        return null;
    }

    @PostMapping
    public ResponseEntity<Pharmacy> addNote(){
        // TODO : POST method mapping
        // url: /pharmacy/{id}/note
        return null;
    }

    @PutMapping(value = "/{id}/note")
    public ResponseEntity<Pharmacy> replaceNote(@PathVariable("id") String id, @RequestBody Note note){
        // TODO : PUT method mapping
        // replace pharmacy note
        // url: /pharmacy/{id}/note


        return null;
    }

    @DeleteMapping
    public ResponseEntity<Pharmacy> removeNote(){
        // TODO : DELETE method mapping
        // remove pharmacy note
        // url: /pharmacy/{id}/note
        return null;
    }
}
