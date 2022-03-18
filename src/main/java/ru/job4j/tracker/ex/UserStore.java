package ru.job4j.tracker.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getName())) {
                rsl = user;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("The User wasn't found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("The user isn't valid");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev")};
        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException fe) {
            fe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
