package com.otsi.mappings.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.otsi.mappings.model.RoleModel;
@Repository
public interface RoleRepository extends CrudRepository<RoleModel, Long> {

	RoleModel findByDescription(String  roleDescrption);

	RoleModel findByName(String name);


	

}
