package com.uppcl.dashboard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uppcl.dashboard.domain.LookupDetail;



@Repository
public interface LookupDetailRepository extends JpaRepository<LookupDetail, Long>{

	@Query(value="select * from  `uppclDirectory`.`lookup_detail` where `lookup_detail`.`lookup_id`=?1",nativeQuery = true)
	List<LookupDetail> findByLookupId(int lookupId);

	@Query(value="select * from  `uppclDirectory`.`lookup_detail` where `lookup_detail`.`parent_id`=?1",nativeQuery = true)
	List<LookupDetail> findByParentId(int parentId);

}

