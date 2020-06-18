package com.graka.service.repository;

import com.graka.service.model.Graka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrakaRepository extends JpaRepository<Graka,Long> {
    @Query("FROM Graka WHERE Name = ?1") Graka findByname(String Name);
}
