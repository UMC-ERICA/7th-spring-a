package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class StoreCategoryHandler extends GeneralException {

    public StoreCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
