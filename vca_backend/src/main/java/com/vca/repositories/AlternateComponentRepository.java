package com.vca.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vca.entity.AlternateComponent;

public interface AlternateComponentRepository extends JpaRepository<AlternateComponent, Long>  {

//	@Query(nativeQuery = true, value = "SELECT DISTINCT(comp_id), is_configurable, comp_type, comp_name FROM vehicles JOIN components ON vehicles.comp_id = components.id JOIN models ON vehicles.mod_id = :modelId WHERE vehicles.comp_type = :comp_type")
//	List<Map<String,Object>> findCompByModelId(@Param("modelId") long id, @Param("comp_type") char comp_type);

//	@Query(nativeQuery = true, value = "SELECT * FROM alternate_components a WHERE a.mod_id = :mod_id AND a.comp_id = :comp_id and a.comp_id!=a.alt_comp_id")
//	@Query(nativeQuery = true, value = "SELECT * FROM alternate_components a JOIN components ON a.comp_id = components.id WHERE a.mod_id =:mod_id AND a.comp_Id =:comp_id")
	@Query(nativeQuery = true, value = "select c.id, c.comp_name from alternate_components a join components c on a.alt_comp_id = c.id where a.mod_id = :mod_id and a.comp_id = :comp_id and a.comp_id <> a.alt_comp_id")	
	List<Map<String,Object>> findByModelIdAndCompId(@Param("mod_id") int mod_id, @Param("comp_id") int comp_id);
}
