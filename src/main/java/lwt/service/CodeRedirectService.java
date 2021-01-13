package lwt.service;

import lwt.info.query.RedirectUrlQuery;

public interface CodeRedirectService {

    boolean checkCodeRedirectParams(RedirectUrlQuery query);

    String createCode(String appId);
}
