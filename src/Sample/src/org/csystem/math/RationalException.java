package org.csystem.math;

import static org.csystem.math.RationalExceptionStatus.*;

public class RationalException extends RuntimeException {
    private RationalExceptionStatus m_rationalExceptionStatus;

    public RationalException(String msg, RationalExceptionStatus rationalExceptionStatus)
    {
        super(msg);
        m_rationalExceptionStatus = rationalExceptionStatus == null ? INDEFINITE : rationalExceptionStatus;
    }

    public String getMessage()
    {
        String msg =  super.getMessage();
        return  String.format("%sStatus:%s", msg != null ? "Message:" + msg + "," : "", m_rationalExceptionStatus);
    }

    public RationalExceptionStatus getRationalExceptionStatus()
    {
        return m_rationalExceptionStatus;
    }
}
