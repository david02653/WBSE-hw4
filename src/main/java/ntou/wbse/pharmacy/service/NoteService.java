package ntou.wbse.pharmacy.service;

import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.repository.NoteRespository;
import ntou.wbse.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    // TODO : add Note object handle functions

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private NoteRespository noteRespository;

    // TODO : add Note function
    public Note addNote(){
        return null;
    }

    // TODO : replace Note function
    public Note replaceNote(){
        return null;
    }

    // TODO : remove Note function
    public String removeNote(){
        return null;
    }
}
