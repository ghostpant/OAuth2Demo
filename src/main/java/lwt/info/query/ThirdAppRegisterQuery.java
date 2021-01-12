package lwt.info.query;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ThirdAppRegisterQuery {

    @NotEmpty(message = "appName不能为空")
    private String appName;

    @NotEmpty(message = "appNumber不能为空")
    private String appNumber;

    @NotEmpty(message = "url不能为空")
    private String redirectUrl;
}
