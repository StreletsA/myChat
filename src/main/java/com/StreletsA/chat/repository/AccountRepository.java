package com.StreletsA.chat.repository;

import com.StreletsA.chat.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {



}
