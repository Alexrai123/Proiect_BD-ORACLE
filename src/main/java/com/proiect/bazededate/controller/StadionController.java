package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.models.Stadion;
import com.proiect.bazededate.service.StadionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadion")
public class StadionController {

    private final StadionService stadionService;

    @GetMapping("/all")
    public List<Stadion> getAll(){
        return stadionService.getAll();
    }

    @GetMapping("/{idStadion}")
    public Stadion getOne(@PathVariable Integer idStadion) {
        return stadionService.getOne(idStadion);
    }

    @PostMapping
    public Stadion create(@RequestBody Stadion stadion) {
        return stadionService.create(stadion);
    }

    @PutMapping
    public Stadion update(@RequestBody Stadion stadionToUpdate) {
        return stadionService.update(stadionToUpdate);
    }

    @DeleteMapping("/{idStadion}")
    public void delete(@PathVariable Integer idStadion) throws Exception {
        stadionService.delete(idStadion);
    }
}
