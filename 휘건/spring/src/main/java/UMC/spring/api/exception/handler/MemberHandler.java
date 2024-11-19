package UMC.spring.api.exception.handler;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
