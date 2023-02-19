package br.com.erudio.restwithspringboot.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksVO extends RepresentationModel<BooksVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;

	private String author;

	private java.sql.Date launchDate;

	private Double price;

	private String title;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, key, launchDate, price, title);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksVO other = (BooksVO) obj;
		return Objects.equals(author, other.author) && Objects.equals(key, other.key)
				&& Objects.equals(launchDate, other.launchDate) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}
	
	

}
