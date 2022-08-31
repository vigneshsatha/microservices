package org.acme.service;

import org.acme.model.User;
import org.acme.repo.IUserRepo;
import org.acme.repo.InMemoryUserRepo;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private IUserRepo userRepo;

    public UserService() {
        this.userRepo = new InMemoryUserRepo();
    }

    /**
     * Find User with unique email id and user id
     * @return
     */
    public Map<String, Integer> getUniqueUserId() {

        var uniqueUsers = this.userRepo.getAll().stream().collect(
                        Collectors.groupingBy(User::getEmail, Collectors.groupingBy(User::getUserId)))
                .entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().size())).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));

        return uniqueUsers;
    }

    /**
     * Find User with unique email id and user id
     * @return
     */
    public Map<Long, Map<String, Integer>> getDuplicatedUserId() {
        var duplicatedUsers = this.userRepo.getAll().stream().collect(
                        Collectors.groupingBy(User::getUserId, Collectors.groupingBy(User::getEmail)))
                .entrySet().stream().map(e -> {
                    var newValue = e.getValue().entrySet().stream().filter(se-> se.getValue().size() > 1)
                            .map(se -> new AbstractMap.SimpleEntry<>(se.getKey(), se.getValue().size())).collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue)
                    );
                    return new AbstractMap.SimpleEntry<>(e.getKey(), newValue);
                }).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue)
                );

        return duplicatedUsers;
    }
    public Integer getDuplicatedEntriesCount() {
        List<User> users = this.userRepo.getAll();
        Set<User> uniqueUsers = new HashSet<>(users);
        return users.size() - uniqueUsers.size();

    }
}
