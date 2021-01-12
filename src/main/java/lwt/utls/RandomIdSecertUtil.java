package lwt.utls;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class RandomIdSecertUtil {

    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    /**
     * 生成不带"_"和空格的UUID
     *
     * @return 随机字符串
     */
    public static String getRandomString() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


    /**
     * 生成随机AppId
     *
     * @return appId
     */
    public static String createAppId() {
        return getRandomString();
    }

    /**
     * 获取AppSecert
     *
     * @param appId
     * @return appSecert
     */
    public static String createAppSecertById(String appId) {
        String base = appId + "/" + slat;
        String secert = DigestUtils.md5DigestAsHex(base.getBytes());
        return secert;
    }
}
