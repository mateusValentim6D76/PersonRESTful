package br.com.erudio.restwithspringboot.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.restwithspringboot.config.FileStorageConfig;
import br.com.erudio.restwithspringboot.exception.FileStorageException;

@Service
public class FileStorageService {
	// Caminho completo da pasta onde os arquivos serão salvos
	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		Path path = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

		this.fileStorageLocation = path;
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be storad !",
					e);
		}
	}

	public String storeFile(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Filename..txt
			if (filename.contains("..")) {
				throw new FileStorageException("Sorry ! Filename contains invalid path sequence" + filename);
			}
			Path targetLocation = this.fileStorageLocation.resolve(filename);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return filename;
		} catch (Exception e) {
			throw new FileStorageException("Could not store file" + filename + ". Please try again !", e);
		}
	}

}
