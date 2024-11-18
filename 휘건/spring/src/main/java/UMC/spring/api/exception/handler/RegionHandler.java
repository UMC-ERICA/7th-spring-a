package UMC.spring.api.exception.handler;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}