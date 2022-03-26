package com.devsuperior.dscatalog.controllers;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable){
        //params: page, size, sort
        Page<CategoryDTO> list = categoryService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);

    }
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO categoryDTO) {
        categoryDTO = categoryService.insert(categoryDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(categoryDTO.getId()).toUri();
        return ResponseEntity.ok().body(categoryDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id,
                                              @RequestBody CategoryDTO categoryDTO) {
        categoryDTO = categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().body(categoryDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
