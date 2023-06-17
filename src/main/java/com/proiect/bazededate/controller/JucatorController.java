package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.service.EchipaService;
import com.proiect.bazededate.service.JucatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jucator")
public class JucatorController {

    private final JucatorService jucatorService;

    @GetMapping("/all")
    public List<Jucator> getAll(){
        return jucatorService.getAll();
    }

    @GetMapping("/{idJucator}")
    public Jucator getOne(@PathVariable Integer idJucator) {
        return jucatorService.getOne(idJucator);
    }

    @PostMapping
    public Jucator create(@RequestBody Jucator jucator) {
        return jucatorService.create(jucator);
    }

    @PutMapping
    public Jucator update(@RequestBody Jucator jucatorToUpdate) {
        return jucatorService.update(jucatorToUpdate);
    }

    @DeleteMapping("/{idJucator}")
    public void delete(@PathVariable Integer idJucator) throws Exception {
        jucatorService.delete(idJucator);
    }
}
