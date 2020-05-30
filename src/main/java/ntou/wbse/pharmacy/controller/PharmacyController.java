package ntou.wbse.pharmacy.controller;

import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.entity.PharmacyParameter;
import ntou.wbse.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pharmacy")
public class PharmacyController {
    // TODO : add pharmacy api mapping and definition

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/hello")
    public String TryToRun(){
        return "hello spring boot";
    }

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getPharmacies(@ModelAttribute PharmacyParameter param){
        // url: /pharmacy?pharmacyName=&zone=
        List<Pharmacy> list = PharmacyService.getPharmacies(param.getPharmacyName(), param.getZone());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pharmacy> getPharmacy(@PathVariable("id") String id){
        // url: /pharmacy/{id}
        Pharmacy target = PharmacyService.getPharmacy(id);
        return ResponseEntity.ok(target);
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
