package com.mm.curso.entiities;


import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class User implements Serializable {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public User(long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
