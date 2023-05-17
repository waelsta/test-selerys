package fr.selerys.selerystest.repository;


import fr.selerys.selerystest.model.WheatherStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheatherStationRepository extends JpaRepository<WheatherStation,Long> {
    WheatherStation findFirstByLatitudeAndLongitude(double latitude, double longitude);

}
