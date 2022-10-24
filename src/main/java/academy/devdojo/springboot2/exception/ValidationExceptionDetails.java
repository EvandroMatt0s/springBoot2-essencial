package academy.devdojo.springboot2.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDatails{
    private final String fields;
    private  final String fieldsMessage;

}
