package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Meci;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.MeciRepository;
import com.proiect.bazededate.repository.StadionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeciService {

    private final MeciRepository meciRepository;

    @Transactional
    public Meci create(Meci meci) {
        List<Meci> meciList = meciRepository.findAllMeci()
                .stream()
                .sorted(Comparator.comparing(Meci::getId))
                .collect(Collectors.toList());
        if (!meciList.isEmpty()) {
            meciRepository.insertMeci(meciList.get(meciList.size() - 1).getId() + 1,
                    meci.getDateMeciului(),
                    meci.getGazde().getId(),
                    meci.getOaspeti().getId(),
                    meci.getLocatie().getId());
            meci.setId(meciList.get(meciList.size() - 1).getId() + 1);
        } else {
            meciRepository.insertMeci(1,
                    meci.getDateMeciului(),
                    meci.getGazde().getId(),
                    meci.getOaspeti().getId(),
                    meci.getLocatie().getId());
            meci.setId(1);
        }
        return meci;
    }

    public Meci getOne(Integer idMeci) {
        return meciRepository.findMeciById(idMeci);
    }

    public List<Meci> getAll(){
        return meciRepository.findAllMeci();
    }

    @Transactional
    public Meci update(Meci meci) {
        meciRepository.updateMeci(meci.getId(),
                meci.getDateMeciului(),
                meci.getGazde().getId(),
                meci.getOaspeti().getId(),
                meci.getLocatie().getId());
        return meci;
    }

    @Transactional
    public void delete(Integer idMeci) throws Exception {
        meciRepository.deleteMeciById(idMeci);
    }
}
