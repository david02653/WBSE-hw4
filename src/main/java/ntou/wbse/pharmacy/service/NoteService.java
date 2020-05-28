package ntou.wbse.pharmacy.service;

import ntou.wbse.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    // TODO : add Note object handle functions

    @Autowired
    private PharmacyRepository repository;
}
