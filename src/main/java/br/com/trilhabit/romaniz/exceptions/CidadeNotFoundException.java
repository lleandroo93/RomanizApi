package br.com.trilhabit.romaniz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "cidade not found")
public class CidadeNotFoundException extends RuntimeException{
    
}
