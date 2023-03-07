package br.com.erudio.restwithspringboot.vo.v1;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filename;
	private String fileDownloadUri;
	private String fileType;
	private long size;

}
