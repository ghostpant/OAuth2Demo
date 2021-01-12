package lwt.builder;

import lwt.utls.ApiResult;

public class ApiResultBuilder {
    private ApiResult apiResult;

    public ApiResultBuilder(String trace, String msg, String errorCode, Object data, boolean isSuccess) {
        apiResult = new ApiResult();
        apiResult.setData(data);
        apiResult.setErrorCode(errorCode);
        apiResult.setTrace(trace);
        apiResult.setMsg(msg);
        apiResult.setSuccess(isSuccess);
    }

    public ApiResultBuilder(String trace, String msg, String errorCode, boolean isSuccess) {
        apiResult = new ApiResult();
        apiResult.setErrorCode(errorCode);
        apiResult.setTrace(trace);
        apiResult.setMsg(msg);
        apiResult.setSuccess(isSuccess);
    }

    public ApiResult build() {
        return this.apiResult;
    }

    /**
     * 返回成功
     */
    public static ApiResultBuilder success(String traceId, String msg, String errorCode, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS, data, true);
    }

    public static ApiResultBuilder success(String traceId, String msg, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS, data, true);
    }

    public static ApiResultBuilder success(String traceId, String msg) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS, true);
    }

    /**
     * 返回失败
     */
    public static ApiResultBuilder fail(String traceId, String msg, String errorCode, Object data) {
        return new ApiResultBuilder(traceId, msg, errorCode, data, false);
    }

    public static ApiResultBuilder fail(String traceId, String msg, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_ERROR, data, false);
    }

    public static ApiResultBuilder fail(String traceId, String msg, String errorCode) {
        return new ApiResultBuilder(traceId, msg, errorCode, false);
    }

    public static ApiResultBuilder fail(String traceId, String msg) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_ERROR, false);
    }
}
