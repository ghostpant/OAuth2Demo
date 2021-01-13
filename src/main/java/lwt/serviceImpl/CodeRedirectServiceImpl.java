package lwt.serviceImpl;

import lwt.builder.ApiResultBuilder;
import lwt.dao.Impl.ThirdAppIdInfoServiceImpl;
import lwt.dao.table.ThirdAppIdInfo;
import lwt.info.query.RedirectUrlQuery;
import lwt.service.CodeRedirectService;
import lwt.utls.RandomIdSecertUtil;
import lwt.utls.RegexCheckParamsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CodeRedirectServiceImpl implements CodeRedirectService {


    private static final Logger log = LoggerFactory.getLogger(CodeRedirectServiceImpl.class);
    private final ThirdAppIdInfoServiceImpl thirdAppIdInfoService;

    public CodeRedirectServiceImpl(ThirdAppIdInfoServiceImpl thirdAppIdInfoService) {
        this.thirdAppIdInfoService = thirdAppIdInfoService;
    }

    @Override
    public boolean checkCodeRedirectParams(@Valid RedirectUrlQuery query) {
        String tag = "重定向参数校验";

        String appid = query.getAppid();
        String appNumber = query.getAppNumber();
        String auth_type = query.getAuth_type();
        String redirect_url = query.getRedirect_url();

        //校验 第三方APP的合法性
        ThirdAppIdInfo appByNumberID = thirdAppIdInfoService.getAppByNumberID(appNumber, appid);
        if (appByNumberID == null) {
            log.info("【{}】第三方app不存在或已注销, appNumber = {},appId = {}", tag, appByNumberID.getAppNumber(), appByNumberID.getAppId());
            return false;
        }
        //校验 auth_type是否是授权码模式
        if (!"code".equals(auth_type)) {
            log.info("【{}】请求非授权码模式", tag);
            return false;
        }
        //校验回调地址
        if (!RegexCheckParamsUtil.isURL(redirect_url)) {
            log.info("【{}】非法的url, redirectUrl = {}", tag, redirect_url);
            return false;
        }
        return true;
    }

    @Override
    public String createCode(String appId) {
        String tag = "生成授权码";

        return  RandomIdSecertUtil.getRandomString();
    }
}
