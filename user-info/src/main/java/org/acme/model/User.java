package org.acme.model;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private long userId;
    private String userName;
    private String email;
    private String location;
    private String organization;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(location, user.location) && Objects.equals(organization, user.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, email, location, organization);
    }
}
