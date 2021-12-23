package BugTrackerSystem.User.services;

import BugTrackerSystem.User.exceptions.UserNotFoundException;
import BugTrackerSystem.User.models.User;


public interface UserService {
    User createUser(User user);
    User changeUser(Long id, User user) throws UserNotFoundException;
    boolean deleteUser(Long id) throws UserNotFoundException;
    User showUserInfo(String user) throws UserNotFoundException;




}
