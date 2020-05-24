package com.telstra.codechallenge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.Exception.ErrorResponse;
import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.response.RepositoryResponse;
import com.telstra.codechallenge.response.UserResponse;
import com.telstra.codechallenge.service.SearchService;

@RestController
public class SearchController {
	@Autowired
	SearchService searchService;

	@RequestMapping(path = "/search/repositories", method = RequestMethod.GET)
	public ResponseEntity<List<RepositoryResponse>> searchRepository(
			@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false) String order)
			throws SearchException {
		List<RepositoryResponse> repositoryResponseList = null;
		if (q != null) {
			repositoryResponseList = searchService.searchRepository(q, sort, order);
			if (!CollectionUtils.isEmpty(repositoryResponseList)) {
				return new ResponseEntity<List<RepositoryResponse>>(repositoryResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<RepositoryResponse>>(repositoryResponseList, HttpStatus.NOT_FOUND);
			}
		} else {
			throw new SearchException("Validation Failed:Search q missing");
		}
	}

	@RequestMapping(path = "search/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserResponse>> searchUser(@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false) String order)
			throws SearchException {
		List<UserResponse> userResponseList = null;
		if (q != null) {
			userResponseList = searchService.searchUser(q, sort, order);
			if (!CollectionUtils.isEmpty(userResponseList)) {
				return new ResponseEntity<List<UserResponse>>(userResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<UserResponse>>(userResponseList, HttpStatus.NOT_FOUND);
			}
		} else {
			throw new SearchException("Validation Failed:Search q missing");
		}
	}

	@ExceptionHandler(SearchException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
