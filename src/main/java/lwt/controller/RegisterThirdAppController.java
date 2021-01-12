package lwt.controller;

import lwt.builder.ApiResultBuilder;
import lwt.info.query.ThirdAppRegisterQuery;
import lwt.serviceImpl.RegistThirdAppServiceImpl;
import lwt.utls.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterThirdAppController {

    private static final Logger log = LoggerFactory.getLogger(RegisterThirdAppController.class);

    private final RegistThirdAppServiceImpl registThirdAppService;

    @Autowired
    public RegisterThirdAppController(RegistThirdAppServiceImpl registThirdAppService) {
        this.registThirdAppService = registThirdAppService;
    }

    @RequestMapping(value = "third/app/register/getApp", method = RequestMethod.POST)
    public ApiResult registThirdApp(@Valid @RequestBody ThirdAppRegisterQuery query) {
        String tag = "获取AppId和AppSecert";
        log.info("【{}】 请求参数", tag, query);
        ApiResult appIdSecert = registThirdAppService.getAppIdSecert(query);
        log.info("【{}】请求结果: result = {}", tag, appIdSecert);
        return appIdSecert;
    }
}
