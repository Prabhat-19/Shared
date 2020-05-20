package com.uppcl.dashboard.serviceImp;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.uppcl.dashboard.domain.LookUp;
import com.uppcl.dashboard.domain.LookupDetail;
import com.uppcl.dashboard.dto.MobileNumberDTO;
import com.uppcl.dashboard.repository.EmployeeDetailRepo;
import com.uppcl.dashboard.repository.LookupDetailRepository;
import com.uppcl.dashboard.repository.LookupRepository;
import com.uppcl.dashboard.service.UppclDashboardService;

@Service
@Transactional
public class UppclDashboardServiceImpl implements UppclDashboardService {

	private LookupDetailRepository lookupDetailRepo;

	private LookupRepository lookupRepo;

	private EmployeeDetailRepo empRepo;

	public UppclDashboardServiceImpl(LookupDetailRepository lookupDetailRepo, LookupRepository lookupRepo,
			EmployeeDetailRepo empRepo) {
		super();
		this.lookupDetailRepo = lookupDetailRepo;
		this.lookupRepo = lookupRepo;
		this.empRepo = empRepo;

	}

	@Override
	public LookUp createLookup(LookUp lookupDetail) {
		lookupRepo.save(lookupDetail);
		return lookupDetail;

	}

	@Override
	public List<LookUp> getLookup() {

		return lookupRepo.findAll();
	}

	@Override
	public LookupDetail createLookupDetail(@Valid LookupDetail lookupDetail) {
		lookupDetailRepo.save(lookupDetail);
		return lookupDetail;
	}

	@Override
	public List<LookupDetail> getLookupDetail() {

		return lookupDetailRepo.findAll();
	}

	@Override
	public List<LookupDetail> getDetailByLookupId(int lookupId) {

		return lookupDetailRepo.findByLookupId(lookupId);
	}

	@Override
	public List<LookupDetail> getChildDetail(int parentId) {
		return lookupDetailRepo.findByParentId(parentId);
	}

	@Override
	public MobileNumberDTO verifyMobNo(@Valid String mobile) {
		int result = empRepo.verifyMobNo(mobile);
		MobileNumberDTO mobileNumberDTO = new MobileNumberDTO();

		if (result == 1) {
			mobileNumberDTO.setCheckMobileNumber("Present");
		} else {
			mobileNumberDTO.setCheckMobileNumber("Absent");
		}

		return mobileNumberDTO;
	}

}
