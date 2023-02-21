package br.com.erudio.restwithspringboot.vo.v1.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private Boolean authenticated;

	private Date created;

	private Date expirated;

	private String accessToken;

	private String refreshToken;

	@Override
	public int hashCode() {
		return Objects.hash(accessToken, authenticated, created, expirated, refreshToken, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(authenticated, other.authenticated)
				&& Objects.equals(created, other.created) && Objects.equals(expirated, other.expirated)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}

}
