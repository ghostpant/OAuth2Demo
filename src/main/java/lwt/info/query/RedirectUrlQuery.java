package lwt.info.query;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class RedirectUrlQuery {

    @NotEmpty(message = "appid不能为空")
    private String appid;

    @NotEmpty(message = "appNumber不能为空")
    private String appNumber;

    @NotEmpty(message = "回调url不能为空")
    private String redirect_url;

    @NotEmpty(message = "认证类型不能为空")
    private String auth_type;

}
