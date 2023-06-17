package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Stadion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StadionRepository extends JpaRepository<Stadion, Integer> {
    @Modifying
    @Query(value = "INSERT INTO stadion (id, capacitate, an_infiintare, echipa_id) " +
            "VALUES (:id, :capacitate, :anInfiintare, :echipaId)", nativeQuery = true)
    void insertStadion(@Param("id") Integer id,
                       @Param("capacitate") Integer capacitate,
                       @Param("anInfiintare") LocalDate anInfiintare,
                       @Param("echipaId") Integer echipaId);

    @Modifying
    @Query(value = "UPDATE stadion " +
            "SET capacitate = :capacitate, an_infiintare = :anInfiintare, echipa_id = :echipaId " +
            "WHERE id = :id", nativeQuery = true)
    void updateStadion(@Param("id") Integer id,
                       @Param("capacitate") Integer capacitate,
                       @Param("anInfiintare") LocalDate anInfiintare,
                       @Param("echipaId") Integer echipaId);

    @Query(value = "SELECT * FROM stadion", nativeQuery = true)
    List<Stadion> findAllStadion();

    @Query(value = "SELECT * FROM stadion WHERE id = :id", nativeQuery = true)
    Stadion findStadionById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM stadion WHERE id = :id", nativeQuery = true)
    void deleteStadionById(@Param("id") Integer id);
}
