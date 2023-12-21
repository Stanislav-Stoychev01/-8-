package com.pis.shoes.service;

import com.pis.shoes.entity.Shoe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoesService {

    public String getShoes(Shoe shoe) {

        if (shoe.getPrice() > 1000) {
            throw new RuntimeException("Too expensive");
        }

        return "Success";
    }

}
