package com.example.pp_3_1_4_rest_js.repository;

import com.example.pp_3_1_4_rest_js.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}