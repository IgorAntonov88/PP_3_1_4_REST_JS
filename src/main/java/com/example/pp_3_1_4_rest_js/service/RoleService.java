package com.example.pp_3_1_4_rest_js.service;

import com.example.pp_3_1_4_rest_js.model.Role;
import com.example.pp_3_1_4_rest_js.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService{
    private final RoleRepository roleRepository;
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
