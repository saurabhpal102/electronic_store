package electronicStore.serviceImpl;


import electronicStore.exceptions.BadApiException;
import electronicStore.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class FileServiceImpl implements FileService {

    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {
        String orignalFileName = file.getOriginalFilename();
        logger.info("orignalFileName :{}", orignalFileName);
        String fileName = UUID.randomUUID().toString();
        String extension = orignalFileName.substring(orignalFileName.lastIndexOf("."));
        String fileNameWithExtension = fileName + extension;
        String fullPathWithFileName = path + fileNameWithExtension;
        logger.info("fullPathFileName : {}", fullPathWithFileName);

        if (extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg") || extension.equalsIgnoreCase(".png")) {
            File folder = new File(path);

            //folder to save file
            if (!folder.exists()) {
                folder.mkdirs();
            }

            //upload
            Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
            return fileNameWithExtension;
        } else {
            throw new BadApiException("file with this " + extension + " is not valid");
        }
    }

    @Override
    public InputStream getResource(String path, String name) throws IOException {
        String fullPath = path + File.separator + name;
        InputStream fileInputStream = new FileInputStream(fullPath);
        return fileInputStream;
    }
}

