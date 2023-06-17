package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Echipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EchipaRepository extends JpaRepository<Echipa, Integer> {
    @Modifying
    @Query(value = "INSERT INTO echipa (id, antrenor, telefon, email) VALUES (:id, :antrenor, :telefon, :email)", nativeQuery = true)
    void insertEchipa(@Param("id") Integer id,
                      @Param("antrenor") String antrenor,
                      @Param("telefon") String telefon,
                      @Param("email") String email);

    @Modifying
    @Query(value = "UPDATE echipa SET antrenor = :antrenor, telefon = :telefon, email = :email WHERE id = :id", nativeQuery = true)
    void updateEchipa(@Param("id") Integer id,
                      @Param("antrenor") String antrenor,
                      @Param("telefon") String telefon,
                      @Param("email") String email);


    @Query(value = "SELECT * FROM echipa", nativeQuery = true)
    List<Echipa> findAllEchipa();

    @Query(value = "SELECT * FROM echipa WHERE id = :id", nativeQuery = true)
    Echipa findEchipaById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM echipa WHERE id = :id", nativeQuery = true)
    void deleteEchipaById(@Param("id") Integer id);
}
