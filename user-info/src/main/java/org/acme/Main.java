package org.acme;

import org.acme.service.UserService;

public class Main {
    public static void main(String[] args) {
        var userService = new UserService();

        // The number of unique userId for each emailId.
        System.out.println("The number of unique userId for each emailId.");
        System.out.println(userService.getUniqueUserId());

        // The number of duplicated userids for each emailId.
        System.out.println("\nThe number of duplicated userids for each emailId.");
        System.out.println(userService.getDuplicatedUserId());

        // The number of duplicated entries
        System.out.println("\nThe number of duplicated entries.");
        System.out.println(userService.getDuplicatedEntriesCount());

    }
}
