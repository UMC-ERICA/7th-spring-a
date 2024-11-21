package UMC.spring.api.exception.handler;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode code) {
        super(code);
    }

}
