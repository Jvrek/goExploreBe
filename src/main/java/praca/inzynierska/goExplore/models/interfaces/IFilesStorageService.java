package praca.inzynierska.goExplore.models.interfaces;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFilesStorageService {
    public void init();

    public void save(MultipartFile file, String subPath);

    public Resource load(String filename, String subPath);

    //public void deleteAll();

    public Stream<Path> loadAll(String subPath);
}
