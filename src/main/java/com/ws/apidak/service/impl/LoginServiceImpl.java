package com.ws.apidak.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.apidak.dto.response.LoginResponseDto;
import com.ws.apidak.entity.LoginEntity;
import com.ws.apidak.repository.LoginRepository;
import com.ws.apidak.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	LoginRepository loginRepository;
	
	 @Autowired
	 private ModelMapper modelMapper;
	
	@Override
	public LoginResponseDto findByUserNameAndPassword(String userName, String password) throws Exception {

		LoginEntity entity = loginRepository.findByUserNameAndPassword(userName, password);
		LoginResponseDto response = null;
		if(null != entity) {
			response = this.userEntityToUserRespDto(entity);
			
			entity.setLoginFail(0);
			loginRepository.save(entity);
		}else {
			LoginEntity entityCheck = loginRepository.findByUserName(userName);
			if(null != entityCheck) {
				
				int loginFail = entityCheck.getLoginFail();
				if(loginFail == 3) {
					entityCheck.setStatus("2");
					entityCheck.setLoginFail(0);
				}else {
					if("1".equals(entityCheck.getStatus())) {
						entityCheck.setLoginFail(entityCheck.getLoginFail() + 1);
					}
				}
				
				loginRepository.save(entityCheck);
				response = new LoginResponseDto();
				response.setStatus(entityCheck.getStatus());
				response.setLoginFail(entityCheck.getLoginFail());;
			}
		}
		
		
		return response;
	}

	@Override
	public LoginResponseDto findById(Long userId) throws Exception {
		Optional<LoginEntity>  entity = loginRepository.findById(userId);
		LoginResponseDto response = null;
		if(entity.isPresent()) {
			LoginEntity loginEntity = entity.get();
			response = this.userEntityToUserRespDto(loginEntity);
		}
		return response;
	}
	
	// *** set Map
	public LoginEntity userReqDtoToUserEntity(LoginResponseDto loginDto){
        return this.modelMapper.map(loginDto,LoginEntity.class);
    }
    public LoginResponseDto userEntityToUserRespDto(LoginEntity entity){
        return this.modelMapper.map(entity,LoginResponseDto.class);
    }

}
