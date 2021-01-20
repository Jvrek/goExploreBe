package praca.inzynierska.goExplore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import praca.inzynierska.goExplore.messages.ResponseMessage;
import praca.inzynierska.goExplore.models.FileInfo;
import praca.inzynierska.goExplore.services.FilesStorageService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api")
public class FilesController {

    @Autowired
    FilesStorageService storageService;

    @PostMapping("/files/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("subPath") String subPath) {
        String message = "";
        try {
            storageService.save(file, subPath);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{subPath}")
    @ResponseBody
    public ResponseEntity<List<FileInfo>> getListFiles(@PathVariable(value="subPath", required=true) String subPath) {

        List<FileInfo> fileInfos = storageService.loadAll(subPath).map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile",  subPath, path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/file/{subPath}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable("subPath") String subPath,@PathVariable("filename") String filename) {
        System.out.println(subPath);
        Resource file = storageService.load(filename, subPath);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
