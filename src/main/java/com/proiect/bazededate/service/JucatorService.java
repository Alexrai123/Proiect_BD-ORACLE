package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.JucatorRepository;
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
public class JucatorService {
    private final JucatorRepository jucatorRepository;
    @Transactional
    public Jucator create(Jucator jucator) {
        List<Jucator> jucatorList = jucatorRepository.findAllJucator()
                .stream()
                .sorted(Comparator.comparing(Jucator::getId))
                .collect(Collectors.toList());
        if (!jucatorList.isEmpty()) {
            jucatorRepository.insertJucator(jucatorList.get(jucatorList.size() - 1).getId() + 1,
                    jucator.getNume(),
                    jucator.getPrenume(),
                    jucator.getPozitie(),
                    jucator.getTara_origine(),
                    jucator.getEchipa_id());
            jucator.setId(jucatorList.get(jucatorList.size() - 1).getId() + 1);
        } else {
            jucatorRepository.insertJucator(1,
                    jucator.getNume(),
                    jucator.getPrenume(),
                    jucator.getPozitie(),
                    jucator.getTara_origine(),
                    jucator.getEchipa_id());
            jucator.setId(1);
        }
        return jucator;
    }

    public Jucator getOne(Integer idJucator) {
        return jucatorRepository.findJucatorById(idJucator);
    }

    public List<Jucator> getAll(){
        return jucatorRepository.findAllJucator();
    }

    @Transactional
    public Jucator update(Jucator jucator) {
        jucatorRepository.updateJucator(jucator.getId(),
                jucator.getNume(),
                jucator.getPrenume(),
                jucator.getPozitie(),
                jucator.getTara_origine(),
                jucator.getEchipa_id());
        return jucator;
    }

    @Transactional
    public void delete(Integer idJucator) throws Exception {
        jucatorRepository.deleteJucatorById(idJucator);
    }
}
