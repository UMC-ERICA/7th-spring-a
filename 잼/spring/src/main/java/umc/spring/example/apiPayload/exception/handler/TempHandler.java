package umc.spring.example.apiPayload.exception.handler;


import umc.spring.example.apiPayload.code.BaseErrorCode;
import umc.spring.example.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}