package br.com.alura.owasp.validator;

import br.com.alura.owasp.model.Depoimento;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DepoimentoValidator implements Validator {

    /**
     * Checks if the given class is supported by this validator.
     *
     * @param clazz the class to check
     * @return true if the class is supported, false otherwise
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Depoimento.class.isAssignableFrom(clazz);
    }

    /**
     * Validates the object and captures any validation errors.
     *
     * @param target the object to validate
     * @param errors the errors object to capture validation errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        Depoimento depoimento = (Depoimento) target;
        String titulo = depoimento.getTitulo();
        String mensagem = depoimento.getMensagem();

        if(titulo.contains("<") || titulo.contains(">")){
            errors.rejectValue("titulo", "errors.titulo");
        }

        if(mensagem.contains("<") || mensagem.contains(">")){
            errors.rejectValue("mensagem", "errors.mensagem");
        }
    }
}
