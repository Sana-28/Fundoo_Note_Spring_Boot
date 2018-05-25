package com.fundoonotes.userservice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundoonotes.userservice.User;
@Repository(value = "userDao")
public interface UserDAO extends CrudRepository<User,Long> {

	 @Query("select u from User u where u.email = :email")
	 User getUserByEmailId(@Param("email") String email);
	    
	 @Query("select u from User u where u.userId = :userId")
	 User getUserById(@Param("userId") int userId);
	 @Query("UPDATE User c SET c.isActive = :isActive WHERE c.email = :email")
	 public boolean activeUser(User user);
	 
	/* String sql = "update Users set isActive = ? where email=?";
	 * 
	 * @Modifying(clearAutomatically = true)
	    @Query("UPDATE User c SET c.imageUrl = :imageUrl WHERE c.id = :id")
	    int updateUser(@Param("id") long id, @Param("imageUrl") String imageUrl);*/
    
	    }
