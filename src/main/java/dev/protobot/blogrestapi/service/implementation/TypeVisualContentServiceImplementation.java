package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.model.TypeVisualContent;
import dev.protobot.blogrestapi.service.TypeVisualContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeVisualContentServiceImplementation implements TypeVisualContentService {


    @Override
    public List<TypeVisualContent> getAllTypeVisualContent() {
        return null;
    }

    @Override
    public Optional<TypeVisualContent> getTypeVisualContentById(Long id) {
        return Optional.empty();
    }

    @Override
    public TypeVisualContent saveTypeVisualContent(TypeVisualContent typeVisualContent) {
        return null;
    }

    @Override
    public String deleteTypeVisualContentById(Long id) {
        return null;
    }
}
