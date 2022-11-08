package br.com.trilhabit.romaniz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "uf not found")
public class UfNotFoundException extends RuntimeException{
    
}
