package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.repository.EchipaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EchipaService {

    private final EchipaRepository echipaRepository;

    @Transactional
    public Echipa create(Echipa echipa) {
        List<Echipa> echipaList = echipaRepository.findAllEchipa()
                .stream()
                .sorted(Comparator.comparing(Echipa::getId))
                .collect(Collectors.toList());

        echipaRepository.insertEchipa(echipaList.get(echipaList.size() - 1).getId() + 1,
                echipa.getAntrenor(),
                echipa.getTelefon(),
                echipa.getEmail());
        echipa.setId(echipaList.get(echipaList.size() - 1).getId() + 1);
        return echipa;
    }

    public Echipa getOne(Integer idEchipa) {
        return echipaRepository.findEchipaById(idEchipa);
    }

    public List<Echipa> getAll(){
        return echipaRepository.findAllEchipa();
    }

    @Transactional
    public Echipa update(Echipa echipa) {
        echipaRepository.updateEchipa(echipa.getId(),
                echipa.getAntrenor(),
                echipa.getTelefon(),
                echipa.getEmail());
        return echipa;
    }

    @Transactional
    public void delete(Integer idEchipa) throws Exception {
        echipaRepository.deleteEchipaById(idEchipa);
    }
}
