package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Stadion;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.StadionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StadionService {
    private final StadionRepository stadionRepository;

    @Transactional
    public Stadion create(Stadion stadion) {
        List<Stadion> stadionList = stadionRepository.findAllStadion()
                .stream()
                .sorted(Comparator.comparing(Stadion::getId))
                .collect(Collectors.toList());
        if (!stadionList.isEmpty()) {
            stadionRepository.insertStadion(stadionList.get(stadionList.size() - 1).getId() + 1,
                    stadion.getCapacitate(),
                    stadion.getAnInfiintare(),
                    stadion.getEchipa().getId());
            stadion.setId(stadionList.get(stadionList.size() - 1).getId() + 1);
        } else {
            stadionRepository.insertStadion(1,
                    stadion.getCapacitate(),
                    stadion.getAnInfiintare(),
                    stadion.getEchipa().getId());
            stadion.setId(1);
        }
        return stadion;
    }

    public Stadion getOne(Integer idStadion) {
        return stadionRepository.findStadionById(idStadion);
    }

    public List<Stadion> getAll() {
        return stadionRepository.findAllStadion();
    }

    @Transactional
    public Stadion update(Stadion stadion) {
        stadionRepository.updateStadion(stadion.getId(),
                stadion.getCapacitate(),
                stadion.getAnInfiintare(),
                stadion.getEchipa().getId());
        return stadion;
    }

    @Transactional
    public void delete(Integer idStadion) throws Exception {
        stadionRepository.deleteStadionById(idStadion);
    }
}

