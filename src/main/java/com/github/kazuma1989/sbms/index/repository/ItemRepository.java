
package com.github.kazuma1989.sbms.index.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public List<ItemEntity> findNewItems() {
        return jdbc
            .query(
                "SELECT"
                    + " item.id"
                    + ",item.title"
                    + ",album.title as album_title"
                    + ",album.jacket_img as jacket_img"
                    + ",artist.title as artist_title"
                    + ",genre.title as genre_title"
                    + ",item.price"
                    + ",item.release_date"
                    + " FROM item"
                    + " INNER JOIN album ON item.album_id = album.id"
                    + " INNER JOIN artist ON item.artist_id = artist.id"
                    + " INNER JOIN genre ON item.genre_id = genre.id"
                    + " WHERE item.release_date <= CURRENT_DATE"
                    + " ORDER BY item.release_date DESC, item.id ASC"
                    + " LIMIT :limit OFFSET 0",

                new MapSqlParameterSource().addValue("limit", 6),

                (rs, rowNum) -> {
                    ItemEntity e = new ItemEntity();
                    e.id = rs.getInt("id");
                    e.title = rs.getString("title");
                    e.albumTitle = rs.getString("album_title");
                    e.jacketImg = rs.getString("jacket_img");
                    e.artistTitle = rs.getString("artist_title");
                    e.genreTitle = rs.getString("genre_title");
                    e.price = rs.getInt("price");
                    e.releaseDate = rs.getDate("release_date");
                    return e;
                });
    }
}
