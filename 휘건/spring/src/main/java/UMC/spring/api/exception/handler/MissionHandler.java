package UMC.spring.api.exception.handler;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
