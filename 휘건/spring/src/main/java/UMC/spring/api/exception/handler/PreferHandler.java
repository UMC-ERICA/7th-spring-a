package UMC.spring.api.exception.handler;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.exception.GeneralException;

public class PreferHandler extends GeneralException {

    public PreferHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
