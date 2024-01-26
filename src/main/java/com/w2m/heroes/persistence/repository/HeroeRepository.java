package com.w2m.heroes.persistence.repository;

import com.w2m.heroes.persistence.entity.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HeroeRepository extends JpaRepository<Heroe, Long> {


    //@Query(value = "SELECT * FROM HEROE where name like ':name'", nativeQuery = true)
    @Query(value = "SELECT * FROM HEROE where name like CONCAT('%', :name, '%') ", nativeQuery = true)
    public List<Heroe> findByName(@Param("name") String name);

    //@Query(value = "SELECT * FROM HEROE where id = :id", nativeQuery = true)
    public Optional<Heroe> findById(Long id) ;


    @Modifying
    @Query(value = "UPDATE HEROE SET NAME = :name, CAMPO1 = :campo1, CAMPO2 = :campo2, CAMPO3 = :campo3 " +
                   "WHERE ID = :id ", nativeQuery = true)
    public void updateHeroe(@Param("id") Long id,
                            @Param("name") String name,
                            @Param("campo1") String campo1,
                            @Param("campo2") String campo2,
                            @Param("campo3") String campo3
                            );


}

