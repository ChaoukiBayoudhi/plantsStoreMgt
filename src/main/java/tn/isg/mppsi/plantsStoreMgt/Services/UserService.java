package tn.isg.mppsi.plantsStoreMgt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.isg.mppsi.plantsStoreMgt.Entities.User;
import tn.isg.mppsi.plantsStoreMgt.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepos;

    public User add(User u1)
    {
        return userRepos.save(u1);
    }
    public List<User> getUsers()
    {
        return userRepos.findAll();
    }

    public ResponseEntity<User> getUser(Long id) {
        Optional<User> res= userRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res.get(),HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepos.existsByUserName(username);
    }
}
