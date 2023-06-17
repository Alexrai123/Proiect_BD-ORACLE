package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Meci;
import com.proiect.bazededate.models.Stadion;
import com.proiect.bazededate.service.MeciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meci")
public class MeciController {
    private final MeciService meciService;

    @GetMapping("/all")
    public List<Meci> getAll(){
        return meciService.getAll();
    }

    @GetMapping("/{idMeci}")
    public Meci getOne(@PathVariable Integer idMeci) {
        return meciService.getOne(idMeci);
    }

    @PostMapping
    public Meci create(@RequestBody Meci meci) throws Exception {
        return meciService.create(meci);
    }

    @PutMapping
    public Meci update(@RequestBody Meci meciToUpdate) throws Exception {
        return meciService.update(meciToUpdate);
    }

    @DeleteMapping("/{idMeci}")
    public void delete(@PathVariable Integer idMeci) throws Exception {
        meciService.delete(idMeci);
    }
}
