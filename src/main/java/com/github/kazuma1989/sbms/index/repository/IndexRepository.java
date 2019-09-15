
package com.github.kazuma1989.sbms.index.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndexRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public int testAccess() {
        return jdbc.query("SELECT COUNT(*) FROM PREFECTURE", (rs, rowNum) -> rs.getInt(1)).get(0);
    }
}
