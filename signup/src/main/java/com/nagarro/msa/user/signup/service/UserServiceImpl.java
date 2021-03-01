package com.nagarro.msa.user.signup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nagarro.msa.user.constants.IApplicationConstants;
import com.nagarro.msa.user.signup.model.Address;
import com.nagarro.msa.user.signup.model.AuthorityMSA;
import com.nagarro.msa.user.signup.model.MSAUser;
import com.nagarro.msa.user.signup.model.ServiceResponse;
import com.nagarro.msa.user.signup.model.User;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	@Qualifier("userMap")
	private Map<String, User> userMap;
	
	@Autowired
	@Qualifier("userEnableMap")
	private Map<String,Boolean> userEnableMap;
	
	@Override
	public MSAUser loadUserByUsername(String username) {
		
		return convertUser(userMap.get(username));
	}

	private MSAUser convertUser(User user) {
		
		MSAUser msaUser = new MSAUser();
		
		if(user!=null)
		{
			List<AuthorityMSA> authorityList = new ArrayList<>();
			
			AuthorityMSA authorityMSA = new AuthorityMSA();
			authorityMSA.setAuthority(user.getRole());
			authorityList.add(authorityMSA);
			
			msaUser.setUsername(user.getUsername());
			msaUser.setPassword(user.getPassword());
			
			msaUser.setAccountNonExpired(true);
			msaUser.setAccountNonLocked(true);
			msaUser.setCredentialsNonExpired(true);
			msaUser.setEnabled(userEnableMap.get(user.getUsername()));
			msaUser.setAuthorities(authorityList);
			
			
		}
		return msaUser;
	}

	@Override
	public ServiceResponse updateCity(String username, int cityId) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		User user = userMap.get(username);
		
		if(user!=null)
		{
			user.setCityId(cityId);
			serviceResponse.setStatus(IApplicationConstants.SUCCESS_STATUS);
			serviceResponse.setMessage(IApplicationConstants.CITY_UPDATE_SUCCESS_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.OK.value());
			
		}
		else
		{
			serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
			serviceResponse.setMessage(IApplicationConstants.USER_NOT_FOUND_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse updateDefaultAddress(String username, int addressId) {
		ServiceResponse serviceResponse = new ServiceResponse();
		User user = userMap.get(username);
		if(user!=null)
		{
			if(user.getAddressList()!=null && user.getAddressList().size()>=addressId)
			{
			user.setDefaultAddressId(addressId);
			serviceResponse.setStatus(IApplicationConstants.SUCCESS_STATUS);
			serviceResponse.setMessage(IApplicationConstants.DEFAULT_ADDRESS_UPDATE_SUCCESS_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.OK.value());
			}
			else
			{
				serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
				serviceResponse.setMessage(IApplicationConstants.ADDRESS_NOT_FOUND_MESSAGE);
				serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			}
		}
		else
		{
			serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
			serviceResponse.setMessage(IApplicationConstants.USER_NOT_FOUND_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse addAddress(String username, Address address) {
		ServiceResponse serviceResponse = new ServiceResponse();
		
		User user = userMap.get(username);
		
		if(user!=null)
		{
			if(user.getAddressList()!=null)
			{
				user.getAddressList().add(address);
			}
			else
			{
				List<Address> addresslist = new ArrayList<Address>();
				addresslist.add(address);
				user.setAddressList(addresslist);
			}
			
			serviceResponse.setStatus(IApplicationConstants.SUCCESS_STATUS);
			serviceResponse.setMessage(IApplicationConstants.ADDRESS_ADDED_SUCCESS_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.OK.value());
			
		}
		else
		{
			serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
			serviceResponse.setMessage(IApplicationConstants.USER_NOT_FOUND_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		
		return serviceResponse;
	}

	@Override
	public ServiceResponse removeAddress(String username, int addressId) {
		ServiceResponse serviceResponse = new ServiceResponse();
		
		User user = userMap.get(username);
		if(user!=null)
		{
			if(user.getAddressList()!=null && user.getAddressList().size()>=addressId)
			{
			user.getAddressList().remove(addressId);
			serviceResponse.setStatus(IApplicationConstants.SUCCESS_STATUS);
			serviceResponse.setMessage(IApplicationConstants.ADDRESS_REMOVED_SUCCESS_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.OK.value());
			}
			else
			{
				serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
				serviceResponse.setMessage(IApplicationConstants.ADDRESS_NOT_FOUND_MESSAGE);
				serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			}
		}
		else
		{
			serviceResponse.setStatus(IApplicationConstants.FAIL_STATUS);
			serviceResponse.setMessage(IApplicationConstants.USER_NOT_FOUND_MESSAGE);
			serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		}
		
		return serviceResponse;
	}

	@Override
	public int cityId(String username) {
		User user = userMap.get(username);
		int cityId = 0;
		if(user!=null)
		{
			cityId = user.getCityId();
		}
		return cityId;
	}

	@Override
	public String enableServiceProvider(String username) {
		userEnableMap.put(username, true);
		return IApplicationConstants.SUCCESS_STATUS;
	}

	@Override
	public List<User> spList(int cityId) {
		List<User> spList = new ArrayList<>();
		for(User user: userMap.values())
		{
			if(user.getCityId()==cityId && user.getRole().equals(IApplicationConstants.SERVICE_PROVIDER_ROLE))
			{
				spList.add(user);
			}
		}
		return spList;
	}
}
