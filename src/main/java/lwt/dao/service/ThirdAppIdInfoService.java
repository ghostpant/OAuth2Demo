package lwt.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lwt.dao.table.ThirdAppIdInfo;

public interface ThirdAppIdInfoService extends IService<ThirdAppIdInfo> {

    ThirdAppIdInfo getAppIdSecertByNumber(String appNumber);

    ThirdAppIdInfo getAppByNumberID(String appNumber, String appId);

}
