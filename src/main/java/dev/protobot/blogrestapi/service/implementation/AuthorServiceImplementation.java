package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.exceptions.service.author.AuthorDoesntExistInDatabaseException;
import dev.protobot.blogrestapi.helper.shared.*;
import dev.protobot.blogrestapi.model.Author;
import dev.protobot.blogrestapi.repository.AuthorRepository;
import dev.protobot.blogrestapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    private final CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    private final CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    private final CheckIfStringHaveNumber checkIfStringHaveNumber;

    private final ConvertStringToLowerCase convertStringToLowerCase;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository,
                                       CheckIfNullOrEmptyString checkIfNullOrEmptyString,
                                       CheckIfNullOrZeroLong checkIfNullOrZeroLong,
                                       CheckIfStringHaveNumber checkIfStringHaveNumber,
                                       ConvertStringToLowerCase convertStringToLowerCase) {
        this.authorRepository = authorRepository;
        this.checkIfNullOrEmptyString = checkIfNullOrEmptyString;
        this.checkIfNullOrZeroLong = checkIfNullOrZeroLong;
        this.checkIfStringHaveNumber = checkIfStringHaveNumber;
        this.convertStringToLowerCase = convertStringToLowerCase;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        checkIfNullOrZeroLong.check(id);
        Optional<Author> authorById = authorRepository.getAuthorById(id);
        if(!authorById.isPresent()){
            throw new AuthorDoesntExistInDatabaseException();
        }
        return authorById;
    }

    @Override
    public Author saveAuthorWithMainInformation(Author author) {
        checkIfNullOrEmptyString.check(author.getFullName());
        checkIfNullOrEmptyString.check(author.getEmail());
        checkIfStringHaveNumber.check(author.getFullName());
        checkIfStringHaveNumber.check(author.getEmail());
        String convertFullName = convertStringToLowerCase.convert(author.getFullName());
        String convertEmail = convertStringToLowerCase.convert(author.getEmail());
        Author authorCreated = authorRepository.saveAuthorWithMainInformation(
                convertFullName,
                convertEmail
        );
        if(authorCreated.getFullName().equals("") || authorCreated.getEmail().equals("")){
            throw new AuthorDoesntExistInDatabaseException();
        }
        return authorCreated;


    }

    @Override
    public String deleteAuthorById(Long id) {
        checkIfNullOrZeroLong.check(id);
        String response = authorRepository.deleteAuthorById(id);
        if(!response.isEmpty() || response != null){
            return "NO SE REALIZOO";
        }
        return "SE REALIZO";
    }
}
