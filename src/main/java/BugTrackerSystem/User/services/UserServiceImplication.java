package BugTrackerSystem.User.services;

import BugTrackerSystem.User.exceptions.UserNotFoundException;
import BugTrackerSystem.User.models.User;
import BugTrackerSystem.User.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplication implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplication.class);

    @Override
    public User createUser(User user) {
        User savedUser = UserRepo.save(user);
    }

    @Override
    public User changeUser(Long id, User user) throws UserNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUser(Long id) throws UserNotFoundException {
        return false;
    }

    @Override
    public User showUserInfo(String user) throws UserNotFoundException {
        return null;
    }
}
