package cane.brothers.spring.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cane.brothers.spring.service.GoogleSheets;

@RestController
public class GoogleSheetController extends BaseController {

	@Autowired
	private GoogleSheets sheetsService;

	@RequestMapping(value = "/api/sheet", method = RequestMethod.GET)
	public ResponseEntity<List<List<Object>>> read() throws IOException {
		System.out.println("/api/sheet");

		// read spreadsheet
		List<List<Object>> responseBody = sheetsService.readTable();
		
		return new ResponseEntity<List<List<Object>>>(responseBody, HttpStatus.OK);
	}
}
