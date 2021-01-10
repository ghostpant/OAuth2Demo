package lwt.serviceImpl;

import lwt.info.query.ThirdAppRegisterQuery;
import lwt.service.RegistThirdAppService;
import lwt.utls.ApiResult;
import org.springframework.stereotype.Service;

@Service
public class RegistThirdAppServiceImpl implements RegistThirdAppService {

    @Override
    public ApiResult getAppIdSecert(ThirdAppRegisterQuery query) {
        return null;
    }
}
