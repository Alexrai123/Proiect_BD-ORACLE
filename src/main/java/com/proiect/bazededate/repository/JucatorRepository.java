package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Jucator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface JucatorRepository extends JpaRepository<Jucator, Integer> {
    @Modifying
    @Query(value = "INSERT INTO jucator (id, nume, prenume, pozitie, tara_origine, echipa_id) VALUES (:id, :nume, :prenume, :pozitie, :tara_origine, :echipa_id)", nativeQuery = true)
    void insertJucator(@Param("id") Integer id,
                       @Param("nume") String nume,
                       @Param("prenume") String prenume,
                       @Param("pozitie") String pozitie,
                       @Param("tara_origine") String tara_origine,
                       @Param("echipa_id") Echipa echipa_id);
    @Modifying
    @Query(value = "UPDATE jucator SET nume = :nume, prenume = :prenume, pozitie = :pozitie, tara_origine = :tara_origine, echipa_id=:echipa_id WHERE id = :id", nativeQuery = true)
    void updateJucator(@Param("id") Integer id,
                       @Param("nume") String nume,
                       @Param("prenume") String prenume,
                       @Param("pozitie") String pozitie,
                       @Param("tara_origine") String tara_origine,
                       @Param("echipa_id") Echipa echipa_id);

    @Query(value = "SELECT * FROM jucator", nativeQuery = true)
    List<Jucator> findAllJucator();

    @Query(value = "SELECT * FROM jucator WHERE id = :id", nativeQuery = true)
    Jucator findJucatorById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM jucator WHERE id = :id", nativeQuery = true)
    void deleteJucatorById(@Param("id") Integer id);
}
