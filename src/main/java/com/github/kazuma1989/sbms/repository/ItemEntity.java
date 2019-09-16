
package com.github.kazuma1989.sbms.repository;

import java.util.Date;

import lombok.Data;

@Data
public class ItemEntity {

    private Integer id;

    private String title;

    private String albumTitle;

    private String jacketImg;

    private String artistTitle;

    private String genreTitle;

    private Integer price;

    private Date releaseDate;
}
