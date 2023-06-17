package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Clasament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasamentRepository extends JpaRepository<Clasament, Integer> {
    @Modifying
    @Query(value = "INSERT INTO clasament (id, loc_in_clasament, echipa_id, puncte, victorii, egaluri, infrangeri) " +
            "VALUES (:id, :locInClasament, :echipaId, :puncte, :victorii, :egaluri, :infrangeri)", nativeQuery = true)
    void insertClasament(@Param("id") Integer id,
                         @Param("locInClasament") Integer locInClasament,
                         @Param("echipaId") Integer echipaId,
                         @Param("puncte") Integer puncte,
                         @Param("victorii") Integer victorii,
                         @Param("egaluri") Integer egaluri,
                         @Param("infrangeri") Integer infrangeri);

    @Modifying
    @Query(value = "UPDATE clasament SET loc_in_clasament = :locInClasament, echipa_id = :echipaId, " +
            "puncte = :puncte, victorii = :victorii, egaluri = :egaluri, infrangeri = :infrangeri " +
            "WHERE id = :id", nativeQuery = true)
    void updateClasament(@Param("id") Integer id,
                         @Param("locInClasament") Integer locInClasament,
                         @Param("echipaId") Integer echipaId,
                         @Param("puncte") Integer puncte,
                         @Param("victorii") Integer victorii,
                         @Param("egaluri") Integer egaluri,
                         @Param("infrangeri") Integer infrangeri);

    @Query(value = "SELECT * FROM clasament", nativeQuery = true)
    List<Clasament> findAllClasament();

    @Query(value = "SELECT * FROM clasament WHERE id = :id", nativeQuery = true)
    Clasament findClasamentById(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM clasament WHERE id = :id", nativeQuery = true)
    void deleteClasamentById(@Param("id") Integer id);
}
