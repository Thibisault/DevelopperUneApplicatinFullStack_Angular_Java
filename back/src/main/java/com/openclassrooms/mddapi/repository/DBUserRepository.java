//path: back/src/main/java/com/openclassrooms/mddapi/repository/DBUserRepository.java
package com.openclassrooms.mddapi.repository;


import com.openclassrooms.mddapi.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Integer> {
    public DBUser findByUsername(String username);
}