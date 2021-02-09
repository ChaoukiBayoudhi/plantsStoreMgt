package tn.isg.mppsi.plantsStoreMgt.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import tn.isg.mppsi.plantsStoreMgt.Entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails existsByUserName(String username);
}
