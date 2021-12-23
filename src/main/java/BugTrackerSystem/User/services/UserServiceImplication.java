package BugTrackerSystem.User.services;

import BugTrackerSystem.User.exceptions.UserNotFoundException;
import BugTrackerSystem.User.models.User;
import BugTrackerSystem.User.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplication implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplication.class);

    private UserRepo userRepo;

    @Autowired
    public UserServiceImplication (UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
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
    public User showUserInfo(Long id) throws UserNotFoundException {
        return null;
    }
}
