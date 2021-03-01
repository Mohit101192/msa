package com.nagarro.msa.user.signup.service;

import java.util.List;

import com.nagarro.msa.user.signup.model.Address;
import com.nagarro.msa.user.signup.model.MSAUser;
import com.nagarro.msa.user.signup.model.ServiceResponse;
import com.nagarro.msa.user.signup.model.User;

public interface UserService {

	public MSAUser loadUserByUsername(String username);
	public ServiceResponse updateCity(String username,int cityId);
	public ServiceResponse updateDefaultAddress(String username,int addressId);
	public ServiceResponse addAddress(String username,Address address);
	public ServiceResponse removeAddress(String username,int addressId);
	public int cityId(String username);
	public String enableServiceProvider(String username);
	public List<User> spList(int cityId);
}
