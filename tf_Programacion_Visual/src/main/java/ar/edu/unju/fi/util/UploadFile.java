package ar.edu.unju.fi.util;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class UploadFile {

private final static String UPLOADS_FOLDER = "src/main/resources/static/uploads";

public Resource load(String filename) throws MalformedURLException {
Path path = getPath(filename);
Resource resource = new UrlResource(path.toUri());
if (!resource.exists() || !resource.isReadable()) {
throw new RuntimeException("Error in path: " + path.toString());
}

return resource;

}

public Path getPath(String filename) {
return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();

}
public String copy(MultipartFile file) throws IOException {
String uniqueFilename = UUID.randomUUID().toString() + "_"+
file.getOriginalFilename();
Path rootPath = getPath(uniqueFilename);
Files.copy(file.getInputStream(), rootPath);

return uniqueFilename;

}

public boolean delete(String filename) {
Path rootPath = getPath(filename);
File file = rootPath.toFile();
if(file.exists() && file.canRead()) {
if(file.delete()) {
return true;
}
}
return false;
}
}