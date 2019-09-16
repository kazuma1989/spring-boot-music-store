
package com.github.kazuma1989.sbms.item;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql({
    "/init_test_data.sql",
})
public class ItemServiceTest {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    @Autowired
    ItemService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findById_IDが数字でないときはEmpty回答() throws Exception {
        assertThat(service.findById("not a number"), is(Optional.empty()));
    }
}
