package com.PISZaverka.demo.Repository;

import com.PISZaverka.demo.Entity.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SizesRepository extends JpaRepository<Sizes, Long> {

    @Query("select s from Sizes s where s.size = ?1")
    Optional<Sizes> findSizesBySize(Integer sizes);

}
