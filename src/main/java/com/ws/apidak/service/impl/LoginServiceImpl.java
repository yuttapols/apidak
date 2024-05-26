package com.ws.apidak.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
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
	public LoginResponseDto findByUserName(String userName) throws Exception {

		LoginEntity entity = loginRepository.findByUserName(userName);
		return null != entity ?this.userEntityToUserRespDto(loginRepository.findByUserName(userName)) : null;
	}

	@Override
	public List<LoginResponseDto> findAll() throws Exception {
		List<LoginEntity> entitys =  loginRepository.findAll();

		return CollectionUtils.isNotEmpty(entitys) ? entitys.stream().map(m-> this.userEntityToUserRespDto(m)).collect(Collectors.toList()) : null;
	}
	
	 public LoginEntity userReqDtoToUserEntity(LoginResponseDto loginDto){
        return this.modelMapper.map(loginDto,LoginEntity.class);
    }
    public LoginResponseDto userEntityToUserRespDto(LoginEntity entity){
        return this.modelMapper.map(entity,LoginResponseDto.class);
    }

}
