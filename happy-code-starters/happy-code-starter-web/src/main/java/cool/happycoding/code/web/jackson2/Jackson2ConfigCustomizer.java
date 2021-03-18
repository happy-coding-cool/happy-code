package cool.happycoding.code.web.jackson2;

/**
 * description
 *
 * @author lanlanhappy 2021/03/03 10:57 上午
 */
@FunctionalInterface
public interface Jackson2ConfigCustomizer {
    /**
     * 加载 个性化序列化/反序列化的配置
     * @param jackson2Config
     */
    void customize(CustomerJackson2Config jackson2Config);
}
