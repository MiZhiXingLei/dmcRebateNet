package com.dmc.service;

import java.util.List;

import com.dmc.entity.Useradds;

public interface UserAddsService {

	public boolean addUserAdd(Useradds udd, String s_province, String s_city, String s_county);

	public List<Useradds> querAdd(long userid);

	public boolean deletAdd(long addid);
}
