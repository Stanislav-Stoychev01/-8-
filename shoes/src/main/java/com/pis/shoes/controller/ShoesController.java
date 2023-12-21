package com.pis.shoes.controller;

import com.pis.shoes.entity.Shoe;
import com.pis.shoes.service.ShoesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoesController {

    private final ShoesService shoesService;

    @PostMapping("/shoes")
    public ResponseEntity<String> addShoe(@Valid @RequestBody Shoe shoe) {
        return ResponseEntity.ok(shoesService.getShoes(shoe));
    }
}
