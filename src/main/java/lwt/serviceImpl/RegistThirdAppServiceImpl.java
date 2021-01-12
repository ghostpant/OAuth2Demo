package lwt.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import lwt.builder.ApiResultBuilder;
import lwt.dao.Impl.ThirdAppIdInfoServiceImpl;
import lwt.dao.table.ThirdAppIdInfo;
import lwt.info.RsData.ThirdAppData;
import lwt.info.query.ThirdAppRegisterQuery;
import lwt.service.RegistThirdAppService;
import lwt.utls.ApiResult;
import lwt.utls.RandomIdSecertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistThirdAppServiceImpl implements RegistThirdAppService {

    private static final Logger log = LoggerFactory.getLogger(RegistThirdAppServiceImpl.class);

    private final ThirdAppIdInfoServiceImpl thirdAppIdInfoService;

    public RegistThirdAppServiceImpl(ThirdAppIdInfoServiceImpl thirdAppIdInfoService) {
        this.thirdAppIdInfoService = thirdAppIdInfoService;
    }


    @Override
    public ApiResult getAppIdSecert(ThirdAppRegisterQuery query) {
        String tag = "注册为第三方";
        String appName = query.getAppName();
        String appNumber = query.getAppNumber();
        //TODO 是否校验 appName和Number的合法性
        ThirdAppIdInfo appIdSecertByNumber = thirdAppIdInfoService.getAppIdSecertByNumber(appNumber);
        if (appIdSecertByNumber != null) {
            log.info("【{}】已经成第三方应用，无需注册, AppNumber = {}", tag, appNumber);
            return ApiResultBuilder.success("111", "已经成第三方应用，无需注册", appIdSecertByNumber).build();
        }
        //生成AppId 和AppSecert
        String appId = RandomIdSecertUtil.createAppId();
        String appSecert = RandomIdSecertUtil.createAppSecertById(appId);
        ThirdAppIdInfo thirdAppIdInfo = ThirdAppIdInfo.builder()
                .appId(appId).appSecert(appSecert)
                .appName(appName).appNumber(appNumber).build();
        thirdAppIdInfoService.save(thirdAppIdInfo);

        ThirdAppData rsData = ThirdAppData.builder().appId(appId).appSecert(appSecert).build();

        return ApiResultBuilder.success("111", "生成成功", rsData).build();
    }
}
