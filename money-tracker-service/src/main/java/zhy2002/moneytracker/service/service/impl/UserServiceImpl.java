package zhy2002.moneytracker.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhy2002.moneytracker.data.repository.UserRepository;
import zhy2002.moneytracker.domain.User;
import zhy2002.moneytracker.service.service.UserService;

/**
 * Created by JOHNZ on 8/01/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
