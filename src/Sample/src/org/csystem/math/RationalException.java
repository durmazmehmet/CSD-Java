/*----------------------------------------------------------------------------------------------------------------------
    RationalException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class RationalException extends RuntimeException {
    private RationalExceptionStatus m_rationalExceptionStatus;

    public RationalException(String msg, RationalExceptionStatus rationalExceptionStatus)
    {
        super(msg);
        m_rationalExceptionStatus = rationalExceptionStatus;
    }

    public String getMessage()
    {
        return String.format("Message:%s%s",
                super.getMessage(), m_rationalExceptionStatus != null ? ", ExceptionStatus:%s" + m_rationalExceptionStatus : "");
    }
}
