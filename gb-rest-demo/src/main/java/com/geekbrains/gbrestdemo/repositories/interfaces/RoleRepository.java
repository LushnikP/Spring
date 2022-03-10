package com.geekbrains.gbrestdemo.repositories.interfaces;

import com.geekbrains.gbrestdemo.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String theRoleName);
}

