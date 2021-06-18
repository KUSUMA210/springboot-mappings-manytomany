package com.otsi.mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.otsi.mappings.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	

}
