package com.uppcl.dashboard.controller;

import java.util.InputMismatchException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uppcl.dashboard.config.Constants;

import com.uppcl.dashboard.domain.LookUp;
import com.uppcl.dashboard.domain.LookupDetail;
import com.uppcl.dashboard.dto.MobileNumberDTO;
import com.uppcl.dashboard.error.RecordNotFoundException;

import com.uppcl.dashboard.service.UppclDashboardService;

@RestController
@RequestMapping("api/details")
@CrossOrigin(origins = Constants.API_URL)

public class UppclDashboardController {

	private UppclDashboardService uppclService;

	public UppclDashboardController(UppclDashboardService uppclService) {
		super();
		this.uppclService = uppclService;
	}

	@PostMapping("/lookUp")
	public ResponseEntity<LookUp> creatlookUp(@Valid @RequestBody LookUp lookup) throws InputMismatchException {

		LookUp lookUpData = uppclService.createLookup(lookup);
		return new ResponseEntity<LookUp>(lookUpData, HttpStatus.OK);
	}

	@GetMapping("/getLookup")
	public ResponseEntity<List<LookUp>> getLookup() {

		List<LookUp> lookup = uppclService.getLookup();
		if (lookup.size() == 0) {
			throw new RecordNotFoundException("Record not found");
		}
		return new ResponseEntity<List<LookUp>>(lookup, HttpStatus.OK);

	}

	@PostMapping("/lookUpDetail")
	public ResponseEntity<LookupDetail> creatlookUpDetail(@Valid @RequestBody LookupDetail lookupDetail)
			throws InputMismatchException {

		LookupDetail lookUpDetailData = uppclService.createLookupDetail(lookupDetail);
		return new ResponseEntity<LookupDetail>(lookUpDetailData, HttpStatus.OK);
	}

	@GetMapping("/getLookupDetailAll")
	public ResponseEntity<List<LookupDetail>> getLookupDetail() {

		List<LookupDetail> lookupDetail = uppclService.getLookupDetail();
		if (lookupDetail.size() == 0) {
			throw new RecordNotFoundException("Record not found");
		}
		return new ResponseEntity<List<LookupDetail>>(lookupDetail, HttpStatus.OK);

	}

	@GetMapping("/getDetailByLookupId")
	public ResponseEntity<List<LookupDetail>> getDetailByLookupId(@RequestParam int lookupId) {

		List<LookupDetail> lookupDetail = uppclService.getDetailByLookupId(lookupId);
		if (lookupDetail.size() == 0) {
			throw new RecordNotFoundException("Record not found");
		}
		return new ResponseEntity<List<LookupDetail>>(lookupDetail, HttpStatus.OK);

	}

	@GetMapping("/getChildDetail")
	public ResponseEntity<List<LookupDetail>> getChildDetail(@RequestParam int parentId) {

		List<LookupDetail> lookupDetail = uppclService.getChildDetail(parentId);
		if (lookupDetail.size() == 0) {
			throw new RecordNotFoundException("Record not found");
		}
		return new ResponseEntity<List<LookupDetail>>(lookupDetail, HttpStatus.OK);

	}

	@GetMapping("/verifyMobNo")
	public MobileNumberDTO verifyMobNumber(@Valid @RequestParam String mobile) {

		MobileNumberDTO message = uppclService.verifyMobNo(mobile);

		return message;

	}

}
