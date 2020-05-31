package ntou.wbse.pharmacy.controller;

import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.entity.NoteRequest;
import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.entity.PharmacyParameter;
import ntou.wbse.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value = "/{pharmacyId}/note")
    public ResponseEntity<Note> addNote(@PathVariable("pharmacyId") String pharmacyId, @RequestBody String request){
        // url: /pharmacy/{id}/note
        Note note = pharmacyService.createNote(pharmacyId, request);
        //redirect to result page
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pharmacyId}").buildAndExpand(pharmacyId).toUri();
        return ResponseEntity.created(location).body(note);
    }

    @PutMapping(value = "/{pharmacyId}/note")
    public ResponseEntity<Note> replaceNote(@PathVariable("pharmacyId") String pharmacyId, @RequestBody String msg){
        // replace pharmacy note
        // url: /pharmacy/{PharmacyId}/note
        Note note = pharmacyService.replaceNote(pharmacyId, msg);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping(value = "/{pharmacyId}/note")
    public ResponseEntity<Note> removeNote(@PathVariable("pharmacyId") String pharmacyId){
        // remove pharmacy note
        // url: /pharmacy/{id}/note
        pharmacyService.removeNote(pharmacyId);
        return ResponseEntity.noContent().build();
    }
}
