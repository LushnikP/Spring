package com.geekbrains.gbrestdemo.repositories.interfaces;

import com.geekbrains.gbrestdemo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // @Query(value = "SELECT id, username, password, first_name, last_name, email from users where username = ?1", nativeQuery = true)
    User findOneByUserName(String userName);


//    //
//    @Query(value ="select id, category_id, short_description, " +
//            "create_at, full_description, title, price, vendor_code, " +
//            "title from products where id = ?1", nativeQuery = true)
//    Product myQuery(Long id);

//    @Query(value = "SELECT s FROM Student s LEFT JOIN s.courses c GROUP BY s.id ORDER BY count(c)")
//    List<Student> getStudentsByCoursesCountDescHQL(Pageable pageable);
}

