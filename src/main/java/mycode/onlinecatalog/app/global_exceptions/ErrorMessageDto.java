package mycode.onlinecatalog.app.global_exceptions;

import lombok.Builder;

@Builder
public record ErrorMessageDto(String message) {
}
