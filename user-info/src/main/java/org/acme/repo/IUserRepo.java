package org.acme.repo;

import org.acme.model.User;

import java.util.List;

public interface IUserRepo {
    List<User> getAll();
}
