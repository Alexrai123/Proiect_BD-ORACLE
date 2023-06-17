package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Clasament;
import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.repository.ClasamentRepository;
import com.proiect.bazededate.repository.EchipaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClasamentService {
    private final ClasamentRepository clasamentRepository;

    @Transactional
    public Clasament create(Clasament clasament) {
        List<Clasament> clasamentList = clasamentRepository.findAllClasament()
                .stream()
                .sorted(Comparator.comparing(Clasament::getId))
                .collect(Collectors.toList());
        if (!clasamentList.isEmpty()) {
            clasamentRepository.insertClasament(
                    clasamentList.get(clasamentList.size() - 1).getId() + 1,
                    clasament.getLocInClasament(),
                    clasament.getEchipa().getId(), // Modify to use echipaId instead of echipa object
                    clasament.getPuncte(),
                    clasament.getVictorii(),
                    clasament.getEgaluri(),
                    clasament.getInfrangeri()
            );
            clasament.setId(clasamentList.get(clasamentList.size() - 1).getId() + 1);
        } else {
            clasamentRepository.insertClasament(
                    1,
                    clasament.getLocInClasament(),
                    clasament.getEchipa().getId(), // Modify to use echipaId instead of echipa object
                    clasament.getPuncte(),
                    clasament.getVictorii(),
                    clasament.getEgaluri(),
                    clasament.getInfrangeri()
            );
            clasament.setId(1);
        }
        return clasament;
    }
    public Clasament getOne(Integer idJucator) {
        return clasamentRepository.findClasamentById(idJucator);
    }

    public List<Clasament> getAll(){
        return clasamentRepository.findAllClasament();
    }

    @Transactional
    public Clasament update(Clasament clasament) {
        clasamentRepository.updateClasament(
                clasament.getId(),
                clasament.getLocInClasament(),
                clasament.getEchipa().getId(),
                clasament.getPuncte(),
                clasament.getVictorii(),
                clasament.getEgaluri(),
                clasament.getInfrangeri()
        );
        return clasament;
    }

    @Transactional
    public void delete(Integer idClasament) throws Exception {
        clasamentRepository.deleteClasamentById(idClasament);
    }
}
