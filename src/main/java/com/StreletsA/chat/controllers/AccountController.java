package com.StreletsA.chat.controllers;

import com.StreletsA.chat.entity.Account;
import com.StreletsA.chat.repository.AccountRepository;
import com.StreletsA.chat.service.AccountService;
import com.StreletsA.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAccount(){
        return accountService.getAllAccounts();
    }

    @CrossOrigin
    @GetMapping(value="/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccount(String accountId){
        return accountService.getAccount(accountId);
    }

    @CrossOrigin
    @PostMapping(value="/{accountId}/add-friend", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addFriendIdToAccount(@PathVariable String accountId, @RequestBody String friendAccountId){
        System.out.println(accountId);
        accountService.addFriendIdToAccount(accountId, friendAccountId);
    }

    @CrossOrigin
    @PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addAccount(@RequestBody Account account){
        accountService.addAccount(account);
    }

}
