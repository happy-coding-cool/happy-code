package cool.happycoding.code.base;

/**
 * description
 *
 * @author lanlanhappy 2021/03/22 3:00 下午
 */
public final class HappyCodeVersion {

    private HappyCodeVersion(){}
    /**
     * Return the full version string of the present Spring codebase,
     * or {@code null} if it cannot be determined.
     * @see Package#getImplementationVersion()
     */
    public static String getVersion() {
        Package pkg = HappyCodeVersion.class.getPackage();
        return (pkg != null ? pkg.getImplementationVersion() : null);
    }
}
