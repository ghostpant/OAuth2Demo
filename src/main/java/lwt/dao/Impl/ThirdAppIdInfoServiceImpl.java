package lwt.dao.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lwt.dao.constants.ThirdAppIdInfoConstants;
import lwt.dao.mapper.ThirdAppIdInfoMapper;
import lwt.dao.service.ThirdAppIdInfoService;
import lwt.dao.table.ThirdAppIdInfo;
import org.springframework.stereotype.Service;

@Service
public class ThirdAppIdInfoServiceImpl extends ServiceImpl<ThirdAppIdInfoMapper, ThirdAppIdInfo> implements ThirdAppIdInfoService {
    @Override
    public ThirdAppIdInfo getAppIdSecertByNumber(String appNumber) {
        return baseMapper.selectOne(new QueryWrapper<ThirdAppIdInfo>()
                .eq(ThirdAppIdInfoConstants.APP_NUMBER, appNumber)
                .eq(ThirdAppIdInfoConstants.IS_DELETE, 0));

    }

}
