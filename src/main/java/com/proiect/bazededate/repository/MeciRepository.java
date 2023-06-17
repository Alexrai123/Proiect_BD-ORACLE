package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Meci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface MeciRepository extends JpaRepository<Meci, Integer> {
    @Modifying
    @Query(value = "INSERT INTO meci (id, date_meciului, gazde_id, oaspeti_id, locatie_id) " +
            "VALUES (:id, :dateMeciului, :gazdeId, :oaspetiId, :locatieId)", nativeQuery = true)
    void insertMeci(@Param("id") Integer id,
                    @Param("dateMeciului") LocalDate dateMeciului,
                    @Param("gazdeId") Integer gazdeId,
                    @Param("oaspetiId") Integer oaspetiId,
                    @Param("locatieId") Integer locatieId);

    @Modifying
    @Query(value = "UPDATE meci SET date_meciului = :dateMeciului, gazde_id = :gazdeId, " +
            "oaspeti_id = :oaspetiId, locatie_id = :locatieId " +
            "WHERE id = :id", nativeQuery = true)
    void updateMeci(@Param("id") Integer id,
                    @Param("dateMeciului") LocalDate dateMeciului,
                    @Param("gazdeId") Integer gazdeId,
                    @Param("oaspetiId") Integer oaspetiId,
                    @Param("locatieId") Integer locatieId);

    @Query(value = "SELECT * FROM meci", nativeQuery = true)
    List<Meci> findAllMeci();

    @Query(value = "SELECT * FROM meci WHERE id = :id", nativeQuery = true)
    Meci findMeciById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM meci WHERE id = :id", nativeQuery = true)
    void deleteMeciById(@Param("id") Integer id);
}
