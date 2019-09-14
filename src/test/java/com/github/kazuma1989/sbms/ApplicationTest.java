
package com.github.kazuma1989.sbms;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    JdbcTemplate jdbc;

    @Test
    public void 起動できる() {
    }

    @Test
    public void DBアクセスできる() {
        int count = jdbc.query("SELECT COUNT(*) FROM billionaires", (rs, rowNum) -> rs.getInt(1)).get(0);

        assertThat(count, is(3));
    }
}
