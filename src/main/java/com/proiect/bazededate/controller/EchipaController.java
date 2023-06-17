package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.service.EchipaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/echipa")
public class EchipaController {

    private final EchipaService echipaService;

    @GetMapping("/all")
    public List<Echipa> getAll(){
        return echipaService.getAll();
    }

    @GetMapping("/{idEchipa}")
    public Echipa getOne(@PathVariable Integer idEchipa) {
        return echipaService.getOne(idEchipa);
    }

    @PostMapping
    public Echipa create(@RequestBody Echipa echipa) {
        return echipaService.create(echipa);
    }

    @PutMapping
    public Echipa update(@RequestBody Echipa echipaToUpdate) {
        return echipaService.update(echipaToUpdate);
    }

    @DeleteMapping("/{idEchipa}")
    public ResponseEntity delete(@PathVariable Integer idEchipa) throws Exception {
        echipaService.delete(idEchipa);
        return new ResponseEntity(HttpStatus.OK);
    }


}
