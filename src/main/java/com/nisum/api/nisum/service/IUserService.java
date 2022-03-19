package com.nisum.api.nisum.service;

import com.nisum.api.nisum.exception.BusinessException;
import com.nisum.api.nisum.web.request.UserRequest;
import com.nisum.api.nisum.web.response.UserResponse;

public interface IUserService {

	UserResponse registerUser(UserRequest request) throws BusinessException;
}
