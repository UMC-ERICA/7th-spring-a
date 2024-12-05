package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class PageHandler extends GeneralException {

    public PageHandler(BaseErrorCode code) {
        super(code);
    }
}
