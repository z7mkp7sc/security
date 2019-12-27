package com.swift.taylor.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @description:
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:03
 * @version: v1
 * @modified By:
 */
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
