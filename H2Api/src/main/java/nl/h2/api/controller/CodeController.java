package nl.h2.api.controller;

import nl.h2.api.api.CodeDTO;
import nl.h2.api.model.Users;
import nl.h2.api.repository.CodeRepository;
import nl.h2.api.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @Autowired
    private CodeRepository codeRepository;

    public CodeController(CodeService codeService) {

        this.codeService = codeService;
    }

    public CodeController() {

    }

    @PostMapping(value = "/users")
    @ResponseBody
    public CodeDTO createdUser(String source, String codeListCode, String code, String displayValue,
                               String longDescription, String fromDate, String toDate, String sortingPriority) {

        Users users = codeService.createUser(source, codeListCode,code,
                                            displayValue,longDescription,fromDate,toDate,sortingPriority);
        return CodeDTO.toUsersDTO(users);
    }
    /**
     * This method persists the data to the in-memory database and returns the DTOs of the persisted data
     * @param file
     * @return List of Objects that are queried from the database
     */
    @PostMapping("/upload")
    public ResponseEntity<List<CodeDTO>> importFromCsv(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            try {
                codeService.save(file);
                System.out.println("File save.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(getAllUsers());
    }
    /**
     *
     * @return List of elements found in the in-memory database
     */
    @GetMapping(value = "/users")
    @ResponseBody
    public List<CodeDTO> getAllUsers() {

        return codeService
                .getUsers()
                .stream()
                .map(CodeDTO::toUsersDTO)
                .collect(Collectors.toList());
    }
    /**
     *
     * @param code The code based on which to lookup the entries
     * @return Single element if it exists
     */
    @GetMapping
    @RequestMapping("/{code}")
    public Users getSingle(@PathVariable String code) {

        return codeService.getByCode(code);
    }

    /**
     * Removes all elements from the in-memory database
     * @return
     */
    @RequestMapping(value = "/removeAll")
    public ResponseEntity<List<Object>> removeAll() {

        codeRepository.deleteAll();
        return ResponseEntity.ok(Collections.emptyList());
    }
}
