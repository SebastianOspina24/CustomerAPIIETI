package edu.eci.ieti.exception;

import javax.ws.rs.InternalServerErrorException;

import org.springframework.http.HttpStatus;

import edu.eci.ieti.dto.ServerErrorResponseDto;
import edu.eci.ieti.util.ErrorCodeEnum;

public class InvalidCredentialsException extends InternalServerErrorException {
    public InvalidCredentialsException() {

        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND)
                .getMessage());

    }
}