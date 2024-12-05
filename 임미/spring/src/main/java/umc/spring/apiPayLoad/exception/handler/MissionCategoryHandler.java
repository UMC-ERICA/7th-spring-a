package umc.spring.apiPayLoad.exception.handler;

import umc.spring.apiPayLoad.code.BaseErrorCode;
import umc.spring.apiPayLoad.exception.GeneralException;

public class MissionCategoryHandler extends GeneralException {

    public MissionCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
