package dev.protobot.blogrestapi.service;

import dev.protobot.blogrestapi.model.TypeVisualContent;

import java.util.List;
import java.util.Optional;

public interface TypeVisualContentService {

    List<TypeVisualContent> getAllTypeVisualContent();

    Optional<TypeVisualContent> getTypeVisualContentById(Long id);

    TypeVisualContent saveTypeVisualContent(TypeVisualContent typeVisualContent);

    String deleteTypeVisualContentById(Long id);
}
