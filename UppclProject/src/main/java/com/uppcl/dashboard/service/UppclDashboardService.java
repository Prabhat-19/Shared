package com.uppcl.dashboard.service;

import java.util.List;

import javax.validation.Valid;

import com.uppcl.dashboard.domain.LookUp;
import com.uppcl.dashboard.domain.LookupDetail;
import com.uppcl.dashboard.dto.MobileNumberDTO;

public interface UppclDashboardService {

	LookUp createLookup(LookUp lookupDetail);

	List<LookUp> getLookup();

	LookupDetail createLookupDetail(@Valid LookupDetail lookupDetail);

	List<LookupDetail> getLookupDetail();

	List<LookupDetail> getDetailByLookupId(int lookupId);

	List<LookupDetail> getChildDetail(int parentId);

	MobileNumberDTO verifyMobNo(@Valid String mobile);

}
