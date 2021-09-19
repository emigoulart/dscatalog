package com.devsuperior.dscatalog.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name"})
public class Category implements Serializable {

    private Long id;
    private String name;
}
