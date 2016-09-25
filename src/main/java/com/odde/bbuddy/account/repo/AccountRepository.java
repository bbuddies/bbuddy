package com.odde.bbuddy.account.repo;

import com.odde.bbuddy.account.domain.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Repository
public interface AccountRepository extends org.springframework.data.repository.Repository<Account, Integer> {
    void save(Account account);
}
