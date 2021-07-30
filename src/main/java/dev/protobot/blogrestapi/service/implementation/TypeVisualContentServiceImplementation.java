package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrEmptyString;
import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrZeroLong;
import dev.protobot.blogrestapi.helper.shared.CheckIfStringHaveNumber;
import dev.protobot.blogrestapi.helper.shared.ConvertStringToLowerCase;
import dev.protobot.blogrestapi.model.TypeVisualContent;
import dev.protobot.blogrestapi.repository.TypeVisualContentRepository;
import dev.protobot.blogrestapi.service.TypeVisualContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeVisualContentServiceImplementation implements TypeVisualContentService {

    private final TypeVisualContentRepository typeVisualContentRepository;

    private final CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    private final CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    private final CheckIfStringHaveNumber checkIfStringHaveNumber;

    private final ConvertStringToLowerCase convertStringToLowerCase;

    @Autowired
    public TypeVisualContentServiceImplementation(TypeVisualContentRepository typeVisualContentRepository, CheckIfNullOrEmptyString checkIfNullOrEmptyString, CheckIfNullOrZeroLong checkIfNullOrZeroLong, CheckIfStringHaveNumber checkIfStringHaveNumber, ConvertStringToLowerCase convertStringToLowerCase) {
        this.typeVisualContentRepository = typeVisualContentRepository;
        this.checkIfNullOrEmptyString = checkIfNullOrEmptyString;
        this.checkIfNullOrZeroLong = checkIfNullOrZeroLong;
        this.checkIfStringHaveNumber = checkIfStringHaveNumber;
        this.convertStringToLowerCase = convertStringToLowerCase;
    }


    @Override
    public List<TypeVisualContent> getAllTypeVisualContent() {
        return typeVisualContentRepository.getAllTypeVisualContent();
    }

    @Override
    public Optional<TypeVisualContent> getTypeVisualContentById(Long id) {
        checkIfNullOrZeroLong.check(id);
        Optional<TypeVisualContent> typeVisualContentId = typeVisualContentRepository.getTypeVisualContentById(id);
        if(!typeVisualContentId.isPresent()){
            System.out.println("NO EXISTE");
        }
        return typeVisualContentId;
    }

    @Override
    public TypeVisualContent saveTypeVisualContent(TypeVisualContent typeVisualContent) {
        checkIfNullOrEmptyString.check(typeVisualContent.getName());
        checkIfStringHaveNumber.check(typeVisualContent.getName());
        String stringConverted = convertStringToLowerCase.convert(typeVisualContent.getName());
        TypeVisualContent typeVisualContentSaved = typeVisualContentRepository.saveTypeVisualContent(stringConverted);
        if(typeVisualContentSaved.equals("")){
            System.out.println("NO SE GUARDOO");
        }
        return typeVisualContentSaved;
    }

    @Override
    public String deleteTypeVisualContentById(Long id) {
        checkIfNullOrZeroLong.check(id);
        String responseWithAStringThatShouldNotExist = typeVisualContentRepository.deleteTypeVisualContentById(id);
        if(!responseWithAStringThatShouldNotExist.isEmpty()){
            System.out.println("NO SE BORRO");
        }
        return "BORRADO";
    }
}
