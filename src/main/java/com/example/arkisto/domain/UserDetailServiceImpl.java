package com.example.arkisto.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl {
	private final KayttajaRepository krepository;
	
	
	@Autowired
	public UserDetailServiceImpl(KayttajaRepository krepository) {
		this.krepository = krepository;
	}
	
	public UserDetails loadUserByKayttaja(String kayttaja) throws UsernameNotFoundException {
		Kayttaja curruser = krepository.findByKayttaja(kayttaja);
		UserDetails user = new org.springframework.security.core.userdetails.User(kayttaja,
				curruser.getSalasanaHash(),
				AuthorityUtils.createAuthorityList(curruser.getRooli()));
		return user;
	}
}

