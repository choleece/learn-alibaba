package cn.choleece.cloud.nacos.config.request;

import lombok.Data;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 16:29
 **/
@Data
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    /**
     * 请求路径中的版本正则
     */
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/v(\\d+)/");

    private int apiVersion;

    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        // 就近原则，方法上的@ApiVersion > 类上的@ApiVersion
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());

        if (m.find()) {
            // 获得符合匹配条件的ApiVersionCondition
            int version = Integer.valueOf(m.group(1));
            if (version >= getApiVersion()) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        // 当出现多个符合匹配条件的ApiVersionCondition，优先匹配版本号较大的
        return apiVersionCondition.getApiVersion() - getApiVersion();
    }
}
