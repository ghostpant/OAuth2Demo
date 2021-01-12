package lwt.service;

import lwt.info.query.ThirdAppRegisterQuery;
import lwt.utls.ApiResult;

public interface RegistThirdAppService {

    ApiResult getAppIdSecert(ThirdAppRegisterQuery query);

}
