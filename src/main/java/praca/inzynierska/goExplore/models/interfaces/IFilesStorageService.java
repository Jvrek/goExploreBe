package praca.inzynierska.goExplore.models.interfaces;

public interface IFileStorageService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
