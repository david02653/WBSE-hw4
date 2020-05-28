package ntou.wbse.pharmacy.repository;

import ntou.wbse.pharmacy.entity.Pharmacy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PharmacyRepository extends MongoRepository<Pharmacy, String> {

    ArrayList<Pharmacy> findByIdAndIdIsNotNull(String id);
}
