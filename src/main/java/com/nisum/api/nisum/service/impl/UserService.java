package com.nisum.api.nisum.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.nisum.api.nisum.entity.Phone;
import com.nisum.api.nisum.entity.User;
import com.nisum.api.nisum.exception.BusinessException;
import com.nisum.api.nisum.repository.UserRepository;
import com.nisum.api.nisum.service.IUserService;
import com.nisum.api.nisum.web.request.UserRequest;
import com.nisum.api.nisum.web.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserResponse registerUser(UserRequest request) throws BusinessException {
		UserResponse response = new UserResponse();

		Optional<User> existEmail = repository.findOneByEmail(request.getEmail());
		if (existEmail.isPresent()) {
			throw new BusinessException("El correo ya esta registrado");
		} else {
			User user = User.builder().name(request.getName()).email(request.getEmail())
					.password(request.getPassword()).token(UUID.randomUUID().toString()).build();

			List<Phone> listPhones = new ArrayList<>();

			request.getPhones().forEach(p -> {
				Phone phone = Phone.builder().number(p.getNumber()).city(p.getCityCode())
						.country(p.getContryCode()).user(user).build();

				listPhones.add(phone);
			});
			user.setPhones(listPhones);
			user.setIsActive("SI");
			user.setCreated(new Date());
			user.setLastLogin(new Date());
			User register = repository.save(user);

			response.setId(register.getId());
			response.setCreated(register.getCreated());
			response.setModified(register.getModified());
			response.setLastLogin(register.getLastLogin());
			response.setToken(register.getToken());
			response.setIsActive(register.getIsActive());
		}


		return response;
	}

}
