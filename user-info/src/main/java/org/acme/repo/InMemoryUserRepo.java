package org.acme.repo;

import org.acme.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class InMemoryUserRepo implements IUserRepo {
    private Logger logger = Logger.getLogger(InMemoryUserRepo.class.getName());

    private List<User> users;

    public InMemoryUserRepo() {
        this.users = Collections.unmodifiableList(this.loadUserInfo());
    }

    private List<User> loadUserInfo() {
        String filePath = System.getenv("filePath");
        if(null != filePath) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                List<User> users = lines.stream().map(s -> {
                    var user = new User();
                    var userAttributes = s.split(",");
                    user.setUserId(Long.parseLong(userAttributes[0]));
                    user.setUserName(userAttributes[1]);
                    user.setEmail(userAttributes[2]);
                    user.setLocation(userAttributes[3]);
                    user.setOrganization(userAttributes[4]);
                    return user;
                }).collect(Collectors.toList());
                return users;
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
