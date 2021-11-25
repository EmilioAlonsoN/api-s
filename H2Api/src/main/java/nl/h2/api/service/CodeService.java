package nl.h2.api.service;


import nl.h2.api.CSVUtils.CSVUtils;
import nl.h2.api.model.Users;
import nl.h2.api.repository.CodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CodeService {

    CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Users createUser(String source, String codeListCode, String code, String displayValue,
                            String longDescription, String fromDate, String toDate, String sortingPriority) {

        return codeRepository.save(
                new Users(source, codeListCode, code, displayValue, longDescription, fromDate, toDate, sortingPriority));
    }

    public List<Users> getUsers() {

        return StreamSupport.stream(
                codeRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    public Users getByCode(String code) {

        return codeRepository.findByCode(code);
    }

    public void save(MultipartFile file) {

        try {
            List<Users> codes = CSVUtils.csvToCodes(file.getInputStream());
            codeRepository.saveAll(codes);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
