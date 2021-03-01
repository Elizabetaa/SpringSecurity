package com.example.demo.model.entities;

import com.example.demo.model.entities.BaseEntity;
import com.example.demo.model.entities.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
public class UserRoleEntity extends BaseEntity {

    private RoleName role;

    @Enumerated(EnumType.STRING)
    public RoleName getRole() {
        return role;
    }

    public UserRoleEntity setRole(RoleName role) {
        this.role = role;
        return this;
    }
}
