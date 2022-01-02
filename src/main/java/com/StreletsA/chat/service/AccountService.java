package com.StreletsA.chat.service;

import com.StreletsA.chat.entity.Account;
import com.StreletsA.chat.entity.Message;
import com.StreletsA.chat.repository.AccountRepository;
import com.StreletsA.chat.repository.MessageRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @NonNull
    public void addAccount(String name, List<String> friendIds){

        Account account = new Account();

        account.setName(name);
        account.setFriendIds(friendIds);

        addAccount(account);

    }

    @NonNull
    public void addAccount(String name){

        Account account = new Account();

        account.setName(name);
        account.setFriendIds(new ArrayList<String>());

        addAccount(account);

    }

    @NonNull
    public void addAccount(Account account){

        accountRepository.insert(account);

    }

    @NonNull
    public void addFriendIdToAccount(String accountId, String friendAccountId){

        Optional<Account> accountOptional = accountRepository
                                            .findAll()
                                            .stream()
                                            .filter(acc -> acc.getId().equals(accountId))
                                            .findFirst();

        if(!accountOptional.isPresent())
            throw new IllegalStateException("Account not found");

        boolean friendAccountExist = accountRepository
                                                .findAll()
                                                .stream()
                                                .anyMatch(acc -> acc.getId().equals(friendAccountId));

        if(friendAccountExist)
            throw new IllegalStateException("Friend account not found");

        Account account = accountOptional.get();

        List<String> friends = account.getFriendIds();

        if(friends == null)
            friends = new ArrayList<>();

        friends.add(friendAccountId);

        account.setFriendIds(friends);

        updateAccount(account);

    }

    public void updateAccount(Account account){

        accountRepository.save(account);

    }

    @NonNull
    public Account getAccount(String accountId){

        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        else{
            throw new IllegalStateException("Account not found");
        }

    }

    @NonNull
    public List<Account> getAllAccounts(){

        return accountRepository.findAll();

    }

}
