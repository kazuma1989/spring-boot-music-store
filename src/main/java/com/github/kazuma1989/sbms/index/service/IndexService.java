
package com.github.kazuma1989.sbms.index.service;

import java.lang.invoke.MethodHandles;

import com.github.kazuma1989.sbms.index.repository.IndexRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IndexService {

    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    IndexRepository repo;

    public void testAccess() {
        logger.debug(String.valueOf(repo.testAccess()));
    }
}
