package lwt.controller;

import lwt.builder.ApiResultBuilder;
import lwt.info.query.RedirectUrlQuery;
import lwt.info.query.ThirdAppRegisterQuery;
import lwt.serviceImpl.CodeRedirectServiceImpl;
import lwt.serviceImpl.RegistThirdAppServiceImpl;
import lwt.utls.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RegisterThirdAppController {

    private static final Logger log = LoggerFactory.getLogger(RegisterThirdAppController.class);

    private final RegistThirdAppServiceImpl registThirdAppService;
    private final CodeRedirectServiceImpl codeRedirectService;

    @Autowired
    public RegisterThirdAppController(RegistThirdAppServiceImpl registThirdAppService, CodeRedirectServiceImpl codeRedirectService) {
        this.registThirdAppService = registThirdAppService;
        this.codeRedirectService = codeRedirectService;
    }

    @RequestMapping(value = "third/app/register/getApp", method = RequestMethod.POST)
    public ApiResult registThirdApp(@Valid @RequestBody ThirdAppRegisterQuery query) {
        String tag = "获取AppId和AppSecert";
        log.info("【{}】 请求参数", tag, query);
        ApiResult appIdSecert = registThirdAppService.getAppIdSecert(query);
        log.info("【{}】请求结果: result = {}", tag, appIdSecert);
        return appIdSecert;
    }

    @RequestMapping(value = "get/auth/page",method = RequestMethod.GET)
    public ApiResult redirectUrl2Auth(HttpServletRequest request, HttpServletResponse response) {
        String tag = "重定向到授权页面";
        String appid = request.getParameter("appid");
        String appNumber = request.getParameter("appNumber");
        String redirect_url = request.getParameter("redirect_url");
        String auth_type = request.getParameter("auth_type");

        RedirectUrlQuery query = RedirectUrlQuery.builder().appid(appid).appNumber(appNumber).redirect_url(redirect_url).auth_type(auth_type).build();

        boolean checkCodeRedirectParams = codeRedirectService.checkCodeRedirectParams(query);


        if (checkCodeRedirectParams) {
            try {
                response.sendRedirect(redirect_url + "?code="+123123);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ApiResultBuilder.success("11",redirect_url,redirect_url).build();
    }
}
