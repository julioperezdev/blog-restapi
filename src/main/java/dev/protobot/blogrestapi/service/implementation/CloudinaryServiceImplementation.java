package dev.protobot.blogrestapi.service.implementation;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dev.protobot.blogrestapi.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImplementation implements CloudinaryService {

    private final Cloudinary cloudinary;

    private final Map<String, String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryServiceImplementation() {
        valuesMap.put("cloud_name","protobot");
        valuesMap.put("api_key","597938134116938");
        valuesMap.put("api_secret","uV4LlXNKWoeu7tLcU8cMpITjG5k");

        cloudinary = new Cloudinary(valuesMap);
    }


    @Override
    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    @Override
    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    @Override
    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
