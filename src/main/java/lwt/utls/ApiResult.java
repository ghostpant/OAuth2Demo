package lwt.utls;

public class ApiResult {

    //参数校验错误
    public static final String PARAMS_CHECK_ERROR = "10001";

    //查询数据不存在
    public static final String INFO_NOT_FOUND = "10002";

    //连接超时
    public static final String LINKING_TIME_OUT = "10003";

    //权限错误
    public static final String DO_NOT_HAS_PERMISSION = "10004";

    //接口异常
    public static final String DEFAULT_ERROR = "19000";

    //成功
    public static final String DEFAULT_SUCCESS = "200";

    private String trace;

    private String msg;

    private String errorCode;

    private Object data;

    private boolean success;

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ApiResult(String trace, String msg) {
        this.trace = trace;
        this.msg = msg;
    }

    public ApiResult(String trace, String msg, String errorCode) {
        this.trace = trace;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public ApiResult(String trace, String msg, String errorCode, Object data) {
        this.trace = trace;
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }
}
