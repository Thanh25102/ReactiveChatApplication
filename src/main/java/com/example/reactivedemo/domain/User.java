package com.example.reactivedemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("newUser")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Persistable<UUID> {
    @Id UUID id;
    @Column("fullname") String fullName;
    String email;

    @JsonIgnore String password;
    @Transient
    boolean isNewUser;

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.isNewUser || id == null;
    }
}
