package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

	private static final long serialVersionUID = 1L;

	private User user;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user) {
		this.user= user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user= user;
	}
	
	// 권한이 한개가 아닐수 있음.(3개 이상의 권한) but 여기서는 한개만
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collector = new ArrayList<>();
		// 람다식
		collector.add(()-> {
				return user.getRole();
		});
		return collector;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes; // {id:343434343, name: 김동찬, email: ~~}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String) attributes.get("name");
	}

}
