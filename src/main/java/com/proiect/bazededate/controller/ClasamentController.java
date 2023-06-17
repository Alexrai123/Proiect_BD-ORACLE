package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Clasament;
import com.proiect.bazededate.service.ClasamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.IntegerSyntax;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clasament")
public class ClasamentController {
    private final ClasamentService clasamentService;

    @GetMapping("/all")
    public List<Clasament> getAll() {
        return clasamentService.getAll();
    }

    @GetMapping("/{idClasament}")
    public Clasament getOne(@PathVariable Integer idClasament) {
        return clasamentService.getOne(idClasament);
    }

    @PostMapping
    public Clasament create(@RequestBody Clasament clasament) {
        return clasamentService.create(clasament);
    }


    @PutMapping
    public Clasament update(@RequestBody Clasament clasamentToUpdate) {
        return clasamentService.update(clasamentToUpdate);
    }

    @DeleteMapping("/{idClasament}")
    public void delete(@PathVariable Integer idClasament) throws Exception {
        clasamentService.delete(idClasament);
    }
}
