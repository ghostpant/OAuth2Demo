package lwt.info.query;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class RedirectUrlQuery {
    @NotEmpty(message = "appid不能为空")
    private String appid;
    @NotEmpty()
    private String appNumber;
    private String redirect_url;
    private String auth_type;

}
